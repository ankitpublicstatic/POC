package com.ankit.poc.dp.ms;

import org.springframework.stereotype.Service;

// SagaOrchestrator
// ------↓ Command
// PaymentService → InventoryService → ShippingService

// Why Orchestration is less preferred
//
// ❌ Central bottleneck
// ❌ Harder to extend
// ❌ Tighter coupling
@Service
public class OrderSagaOrchestrator {

  public void startSaga(Order order) {
    sendChargePayment(order);
  }

  public void onPaymentSuccess() {
    sendReserveInventory();
  }

  public void onInventoryFailure() {
    sendRefundPayment();
  }
}
