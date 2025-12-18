package com.ankit.poc.design_pattern.micro_services;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import com.ankit.poc.design_pattern.micro_services.events.InventoryFailedEvent;
import com.ankit.poc.design_pattern.micro_services.events.OrderCreatedEvent;
import com.ankit.poc.design_pattern.micro_services.events.PaymentCompletedEvent;
import com.ankit.poc.design_pattern.micro_services.events.PaymentFailedEvent;


@Service
public class PaymentService {

  private final KafkaTemplate<String, Object> kafkaTemplate;

  public PaymentService(KafkaTemplate<String, Object> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  @KafkaListener(topics = "order-events", groupId = "payment-group")
  public void handleOrderCreated(OrderCreatedEvent event) {

    try {
      if (eventAlreadyProcessed(event.getEventId())) {
        return;
      }

      chargePayment(event.getOrderId(), event.getAmount());

      kafkaTemplate.send("payment-events", new PaymentCompletedEvent(event.getOrderId()));

    } catch (Exception ex) {

      kafkaTemplate.send("payment-events", new PaymentFailedEvent(event.getOrderId()));
    }
  }

  private void chargePayment(String orderId, BigDecimal amount) {
    // TODO Auto-generated method stub

  }

  @KafkaListener(topics = "inventory-events", groupId = "payment-group")
  public void handleInventoryFailure(InventoryFailedEvent event) {
    refundPayment(event.getOrderId());
  }

}
