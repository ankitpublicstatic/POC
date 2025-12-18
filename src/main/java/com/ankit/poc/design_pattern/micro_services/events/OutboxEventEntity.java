package com.ankit.poc.design_pattern.micro_services.events;

import lombok.Data;

@Entity
@Table(name = "outbox_event")
@Data
public class OutboxEventEntity {

  @Id
  private UUID id;

  private String aggregateType;
  private String aggregateId;
  private String eventType;

  @Column(columnDefinition = "jsonb")
  private String payload;

  private String status; // NEW, SENT
}

