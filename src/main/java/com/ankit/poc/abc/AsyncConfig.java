package com.ankit.poc.abc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {

  @Bean(name = "asyncExecutor")
  Executor asyncExecutor2() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(20);// 20 running always idle thread by Spring
    executor.setMaxPoolSize(50);// Maximum thread pool size
    executor.setQueueCapacity(100); // 21st - to 50th thread created after Queue capacity full
    executor.setThreadNamePrefix("AsyncThread-");
    executor.initialize();
    return executor;
  }

  @Async("asyncExecutor")
  public CompletableFuture<Boolean> triggerJob() {

    return CompletableFuture.completedFuture(false);
  }

  @Bean(name = "asyncExecutor")
  Executor asyncExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(20);// 20 running always idle thread by Spring
    executor.setMaxPoolSize(50);
    executor.setQueueCapacity(100);// 21st - to 50th thread created after Queue capacity full
    executor.setThreadNamePrefix("AsynchThread-");
    executor.initialize();
    return executor;
  }

  @SuppressWarnings("unused")
  @Async("asyncExecutor")
  public CompletableFuture<Boolean> triggerDatabaseSync(Object databaseDetails, String userName) {
    if (databaseDetails == null) {
      throw new RuntimeException("DATABASE_DETAILS_CAN_NOT_BE_NULL");
    }
    Object queryDetailsList = new Object();
    // queryDetailsRepository.findAllByIsActive(ServiceConstraint.Y,
    // Sort.by(Sort.Direction.ASC, "seq"));

    if (queryDetailsList == null) {
      throw new RuntimeException("DATABASE_QUERY_CAN_NOT_BE_NULL_OR_EMPTY");
    }
    boolean result = triggerSync(databaseDetails, queryDetailsList, userName);

    return CompletableFuture.completedFuture(result);
  }

  private boolean triggerSync(Object databaseDetails, Object queryDetailsList, String userName) {
    try {
      Thread.sleep(9000l);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return true;
  }

}
