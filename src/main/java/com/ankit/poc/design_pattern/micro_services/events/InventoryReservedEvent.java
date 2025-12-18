package com.ankit.poc.design_pattern.micro_services.events;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryReservedEvent {

  private String orderId;
  private BigDecimal amount;
  private String eventId;

  public InventoryReservedEvent(String orderId) {
    this.orderId = orderId;
  }

}
