package com.ankit.poc.dp.ms.events;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentCompletedEvent {

  private String orderId;
  private BigDecimal amount;
  private String eventId;

  public PaymentCompletedEvent(String orderId) {
    this.orderId = orderId;
  }

}
