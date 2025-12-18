package com.ankit.poc.design_pattern.micro_services.background_job;

import java.util.List;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OutboxPublisher {

  private final OutboxRepository repo;
  private final KafkaTemplate<String, String> kafka;

  @Scheduled(fixedDelay = 5000)
  public void publishEvents() {

    List<OutboxEvent> events = repo.findByStatus("NEW");

    for (OutboxEvent event : events) {
      kafka.send("order-events", event.getPayload());
      event.setStatus("SENT");
      repo.save(event);
    }
  }
}
