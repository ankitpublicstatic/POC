package com.ankit.poc.design_pattern.micro_services;

import com.ankit.poc.design_pattern.micro_services.events.InventoryFailedEvent;
import com.ankit.poc.design_pattern.micro_services.events.InventoryReservedEvent;
import com.ankit.poc.design_pattern.micro_services.events.PaymentCompletedEvent;

public class InventoryService {

  @KafkaListener(topics = "payment-events", groupId = "inventory-group")
  public void handlePayment(PaymentCompletedEvent event) {

    try {
      reserveInventory(event.getOrderId());

      kafkaTemplate.send("inventory-events", new InventoryReservedEvent(event.getOrderId()));

    } catch (Exception e) {

      kafkaTemplate.send("inventory-events", new InventoryFailedEvent(event.getOrderId()));
    }
  }

  private void reserveInventory(Object orderId) {
    // TODO Auto-generated method stub

  }

}
