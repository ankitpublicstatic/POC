If two requests come concurrently for an account number with a 100 rupee debit and credit, then how will the API reflect these concurrent API requests and service logic, as well as database behavior? Explain each and every step to handle this type of request in a Java Spring Boot API implementation

Great question — this is a classic real-world concurrency + transaction + isolation problem.
I’ll walk you through it end-to-end, exactly how it works in a Java Spring Boot API, covering:

1. Concurrent API requests (what happens at API layer)
2. Service logic (threading + transactions)
3. Database behavior (locking, isolation, ACID)
4. Correct implementation patterns
5. What goes wrong if you don’t do it right
6. Production-grade solution (code + flow)

Assume:

* Account balance = ₹1000
* Two concurrent requests:

  * Request A → Debit ₹100
  * Request B → Credit ₹100

---

# 1️⃣ Concurrent Requests at API Layer

### Incoming requests

```
T1 ── POST /accounts/123/debit   (₹100)
T2 ── POST /accounts/123/credit  (₹100)
```

### What Spring Boot does

* Each request handled by separate thread from Tomcat thread pool
* No ordering guarantee

```
Thread-1 → Debit
Thread-2 → Credit
```

⚠️ Spring Boot does NOT synchronize requests by default

---

# 2️⃣ Problem If You Do NOTHING (Race Condition)

### Naive service code (❌ wrong)

```java
public void debit(Long accId, BigDecimal amount) {
    Account acc = repo.findById(accId).get();   // balance = 1000
    acc.setBalance(acc.getBalance().subtract(amount));
    repo.save(acc);
}
```

### Timeline (Race Condition)

| Time | Debit Thread        | Credit Thread        |
| ---- | ------------------- | -------------------- |
| t1   | Read balance = 1000 |                      |
| t2   |                     | Read balance = 1000  |
| t3   | Write balance = 900 |                      |
| t4   |                     | Write balance = 1100 |

❌ Final balance = 1100 (wrong)
Correct result should be 1000

This is called Lost Update Problem

---

# 3️⃣ Correct Way: Transaction + Locking

We must ensure:

* Only one transaction modifies account at a time
* Reads are consistent
* Writes are atomic

---

# 4️⃣ Database-Level Protection (Most Important)

## Option 1️⃣ Pessimistic Locking (Recommended for money)

### SQL Behavior

```sql
SELECT * FROM accounts WHERE id = 123 FOR UPDATE;
```

* Locks the row
* Other transaction waits
* No lost updates

---

### Spring Boot Implementation

#### Repository

```java
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT a FROM Account a WHERE a.id = :id")
    Optional<Account> findByIdForUpdate(@Param("id") Long id);
}
```

---

#### Service Layer (Transactional)

```java
@Service
public class AccountService {

    @Transactional
    public void debit(Long accId, BigDecimal amount) {
        Account acc = repo.findByIdForUpdate(accId)
                          .orElseThrow();

        if (acc.getBalance().compareTo(amount) < 0) {
            throw new InsufficientBalanceException();
        }

        acc.setBalance(acc.getBalance().subtract(amount));
    }

    @Transactional
    public void credit(Long accId, BigDecimal amount) {
        Account acc = repo.findByIdForUpdate(accId)
                          .orElseThrow();

        acc.setBalance(acc.getBalance().add(amount));
    }
}
```

---

# 5️⃣ What Happens Step-by-Step (Correct Flow)

### Step-by-step timeline

| Time | Debit Tx (T1)                     | Credit Tx (T2)                    |
| ---- | --------------------------------- | --------------------------------- |
| t1   | BEGIN TX                          |                                   |
| t2   | SELECT FOR UPDATE (lock acquired) |                                   |
| t3   | Read balance = 1000               |                                   |
| t4   | Update → 900                      |                                   |
| t5   | COMMIT                            |                                   |
| t6   |                                   | BEGIN TX                          |
| t7   |                                   | SELECT FOR UPDATE (lock acquired) |
| t8   |                                   | Read balance = 900                |
| t9   |                                   | Update → 1000                     |
| t10  |                                   | COMMIT                            |

✅ Final balance = 1000
✅ ACID preserved

---

# 6️⃣ Database Internals (What DB Is Doing)

### InnoDB (MySQL) / PostgreSQL

* Row-level exclusive lock
* Lock held until commit
* WAL ensures durability
* Isolation = `READ COMMITTED` or higher

---

# 7️⃣ Alternative: Optimistic Locking (Versioning)

Used when:

* High read
* Low contention

### Entity

```java
@Entity
public class Account {

    @Id
    private Long id;

    private BigDecimal balance;

    @Version
    private Long version;
}
```

### What happens

* Both read version = 1
* Debit commits → version becomes 2
* Credit tries to commit with version 1 → ❌ fails

```text
OptimisticLockException
```

### Retry logic needed

---

# 8️⃣ Atomic SQL Update (Best Performance)

Instead of read-modify-write:

```sql
UPDATE accounts
SET balance = balance - 100
WHERE id = 123 AND balance >= 100;
```

### Spring Data

```java
@Modifying
@Query("""
UPDATE Account a
SET a.balance = a.balance - :amount
WHERE a.id = :id AND a.balance >= :amount
""")
int debitAtomic(Long id, BigDecimal amount);
```

✔ No race condition
✔ Single DB call
✔ High throughput
❌ Less domain logic

---

# 9️⃣ API Layer Design (Idempotency)

To avoid duplicate API calls:

* Use `X-Request-Id`
* Store processed request IDs

```http
POST /debit
X-Request-Id: abc-123
```

Prevents:

* Retry duplication
* Network retry issues

---

# 🔥 Production Best Practice Summary

| Layer     | Solution                          |
| --------- | --------------------------------- |
| API       | Separate threads                  |
| Service   | `@Transactional`                  |
| DB        | Pessimistic lock OR atomic update |
| Entity    | Optimistic lock (optional)        |
| Isolation | READ_COMMITTED                    |
| Safety    | Idempotency keys                  |

---

# 💡 What I’d Choose in Real Banking System

✅ Pessimistic Locking + Atomic SQL
✅ Short transactions
✅ Retry on deadlock
✅ Idempotent APIs
✅ Audit table for transactions

---

If you want next:
✔ Sequence diagram
✔ Complete Spring Boot project
✔ Deadlock handling
✔ Kafka-based async ledger
✔ Interview explanation answer

Just tell me 👍
