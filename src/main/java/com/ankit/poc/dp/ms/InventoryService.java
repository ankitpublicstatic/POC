package com.ankit.poc.dp.ms;

import com.ankit.poc.dp.ms.events.InventoryFailedEvent;
import com.ankit.poc.dp.ms.events.InventoryReservedEvent;
import com.ankit.poc.dp.ms.events.PaymentCompletedEvent;

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
