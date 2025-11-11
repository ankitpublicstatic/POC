package com.ankit.poc.spring_boot;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EmployeeDTO {

  @NotNull(message = "ID cannot be null")
  private Long id;

  @NotBlank(message = "Name is mandatory")
  @Size(min = 3, max = 50, message = "Name must be between 3 and 50 chars")
  private String name;

  @Email(message = "Email should be valid")
  private String email;

  @Min(value = 18, message = "Age must be >= 18")
  @Max(value = 60, message = "Age must be <= 60")
  private int age;

  @Pattern(regexp = "^\\d{10}$", message = "Phone must be 10 digits")
  private String phone;

  // getters & setters
}


public class SpringBootValidations {

}
/*
 * It connects domain modeling, input validation, exception handling, and REST APIs — making your
 * services robust, secure, and user-friendly.
 * 
 * Let’s go step-by-step in a deep-dive explanation with full code examples 👇
 * 
 * 🧭 What Is Validation in Spring Boot?
 * 
 * Validation ensures that the data you receive or persist meets defined constraints (e.g., email
 * format, min/max value, required fields).
 * 
 * Spring Boot integrates JSR-380 / JSR-303 Bean Validation API using Hibernate Validator under the
 * hood.
 * 
 * ⚙️ Core Components of Validation Component Description
 * 
 * @Valid / @Validated Triggers validation on a bean Constraint annotations Define rules
 * (@NotNull, @Size, @Email, etc.) javax.validation API Core interface for validators Hibernate
 * Validator Default implementation BindingResult / MethodArgumentNotValidException Catch validation
 * errors Custom validators For complex logic beyond built-in constraints 💻 1️⃣ Add Maven
 * Dependencies
 * 
 * ✅ In Spring Boot 3.x or higher, validation starter comes by default. If not, add it manually:
 * 
 * <dependency> <groupId>org.springframework.boot</groupId>
 * <artifactId>spring-boot-starter-validation</artifactId> </dependency>
 * 
 */


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

  @PostMapping
  public ResponseEntity<String> createEmployee(@Valid @RequestBody EmployeeDTO employee) {
    return ResponseEntity.ok("Employee created: " + employee.getName());
  }
}
// @Valid triggers validation before entering the method.

// If constraints fail → Spring throws MethodArgumentNotValidException.


// Handling Validation Errors Gracefully (Global Exception Handler)


@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidationErrors(
      MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getFieldErrors()
        .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }
}
// Output Example (400 BAD REQUEST):

// {
// "name": "Name must be between 3 and 50 chars",
// "email": "Email should be valid",
// "age": "Age must be >= 18"
// }



// 5️⃣ Difference Between @Valid and @Validated
// Annotation Scope Where Used Notes
// @Valid Standard JSR-303 DTOs, entities Works on fields recursively
// @Validated Spring-specific Method-level Enables group validation


// Example — Using Validation Groups
public interface OnCreate {
}


public interface OnUpdate {
}


public class UserDTO {

  @Null(groups = OnCreate.class) // id must be null when creating
  @NotNull(groups = OnUpdate.class) // id required when updating
  private Long id;

  @NotBlank
  private String name;
}


  @PostMapping
  public ResponseEntity<String> createUser(@Validated(OnCreate.class) @RequestBody UserDTO user) {}

  @PutMapping
  public ResponseEntity<String> updateUser(@Validated(OnUpdate.class) @RequestBody UserDTO user) {}



  // 🧩 6️⃣ Custom Validator Example
  // Sometimes you need to validate complex business rules (e.g., startDate < endDate).
  //
  // Step 1️⃣ Create Custom Annotation
  @Target({ElementType.TYPE})
  @Retention(RetentionPolicy.RUNTIME)
  @Constraint(validatedBy = DateRangeValidator.class)
  public @interface ValidDateRange {
    String message()

    default "Start date must be before end date";Class<?>[] groups() default {
  };

  Class<? extends Payload>[] payload()default{};
}


// Step 2️⃣ Implement the Logic
public class DateRangeValidator implements ConstraintValidator<ValidDateRange, ProjectDTO> {

  @Override
  public boolean isValid(ProjectDTO project, ConstraintValidatorContext context) {
    if (project.getStartDate() == null || project.getEndDate() == null) {
      return true;
    }
    return project.getStartDate().isBefore(project.getEndDate());
  }
}


// Step 3️⃣ Apply on DTO
@ValidDateRange
public class ProjectDTO {
  private LocalDate startDate;
  private LocalDate endDate;
}
//
// ✅ If validation fails:
// {
// "error": "Start date must be before end date"
// }


// 🔄 7️⃣ Validation in Service Layer (Programmatic Validation)
// Sometimes validation is required outside of controllers — e.g., inside a service before
// persistence.
@Service
public class UserService {

  private final Validator validator;

  public UserService(Validator validator) {
    this.validator = validator;
  }

  public void saveUser(UserDTO user) {
    Set<ConstraintViolation<UserDTO>> violations = validator.validate(user);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }
    // continue saving user
  }
}

// This approach is ideal for validating data from non-REST sources (e.g., Kafka messages, cron
// jobs).


// ⚙️ 8️⃣ Validation with Nested Objects
// You can also validate nested objects or lists.
public class DepartmentDTO {
  @NotBlank
  private String name;

  @Valid
  @NotEmpty
  private List<EmployeeDTO> employees;
}

// ✅ @Valid on the nested field triggers recursive validation for each employee.

// 🧰 9️⃣ Common Built-in Validation Annotations
// AnnotationDescription@NotNullValue must not be null@NotEmptyString/Collection must not be
// empty@NotBlankString must have non-whitespace chars@EmailMust be valid email format@PatternMust
// match regex@Min / @MaxNumeric range@Positive / @NegativeSign constraints@Past / @FutureDate
// constraints@AssertTrue / @AssertFalseBoolean logic@Size(min, max)Length or collection size


// 🧱 10️⃣ Example: Full Working Spring Boot Validation Project
@RestController
@RequestMapping("/api/users")
public class UserController {

  @PostMapping
  public ResponseEntity<String> registerUser(@Valid @RequestBody UserDTO user) {
    return ResponseEntity.ok("Registered user: " + user.getName());
  }
}


@Data
public class UserDTO {
  @NotBlank
  private String name;

  @Email
  private String email;

  @Pattern(regexp = "^[0-9]{10}$")
  private String phone;
}


@RestControllerAdvice
public class ValidationHandler {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidationError(
      MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getFieldErrors()
        .forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }
}


// ✅ Test Request:
// POST /api/users
// {
// "name": "",
// "email": "notemail",
// "phone": "123"
// }
//
// ✅ Response:
// {
// "name": "must not be blank",
// "email": "must be a well-formed email address",
// "phone": "must match regex ^[0-9]{10}$"
// }
//
//
// 🔒 11️⃣ Integration with Security (Real World Example)
// Validate credentials at login:
public class LoginRequest {
  @NotBlank
  private String username;
  @NotBlank
  @Size(min = 8)
  private String password;
  }

  // In AuthenticationController:
  @PostMapping("/login")
  public ResponseEntity<String> login(@Valid @RequestBody LoginRequest login) {
      // handle authentication
      return ResponseEntity.ok("Login successful");
  }


// 🧠 Interview Insights
// QuestionKey PointsWhat is the difference between @Valid and @Validated?@Valid is JSR-303;
// @Validated supports validation groups.What happens internally with @Valid?Spring creates a
// MethodValidationInterceptor → delegates to LocalValidatorFactoryBean → calls Hibernate
// Validator.Can you validate nested objects?Yes, using @Valid on the field.How do you handle
// validation errors?Via MethodArgumentNotValidException or BindingResult.What’s the default
// validator?Hibernate Validator.

// 🧩 Summary
// LayerPurposeTools / AnnotationsDTODefine constraints@NotNull, @Email, @PatternControllerTrigger
// validation@Valid, @ValidatedHandlerHandle errors@RestControllerAdviceServiceProgrammatic
// validationValidator beanCustom LogicComplex rules@Constraint, custom validator class

// Would you like me to show a visual diagram of how validation flows inside Spring Boot (from
// @Valid → Hibernate Validator → Exception Handler → JSON error response)? It’s a great mental
// model for interviews.
