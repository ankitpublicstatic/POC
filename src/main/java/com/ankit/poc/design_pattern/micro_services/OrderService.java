package com.ankit.poc.design_pattern.micro_services;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import com.ankit.poc.design_pattern.micro_services.events.OrderCreatedEvent;

@Service
public class OrderService {

  private final KafkaTemplate<String, Object> kafkaTemplate;

  public OrderService(KafkaTemplate<String, Object> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void createOrder(String orderId, BigDecimal amount) {
    // 1. Local transaction
    saveOrder(orderId);

    // 2. Publish event
    kafkaTemplate.send("order-events", new OrderCreatedEvent(orderId, amount));
  }

  private void saveOrder(String orderId) {
    // DB save
  }

  private final OrderRepository orderRepo;
  private final OutboxRepository outboxRepo;

  @Transactional
  public void createOrder(Order order) {

    orderRepo.save(order);

    OutboxEvent event = new OutboxEvent();
    event.setId(UUID.randomUUID());
    event.setAggregateType("ORDER");
    event.setAggregateId(order.getId());
    event.setEventType("OrderCreated");
    event.setPayload(toJson(order));
    event.setStatus("NEW");

    outboxRepo.save(event);
  }

}
