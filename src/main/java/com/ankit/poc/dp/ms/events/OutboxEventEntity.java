package com.ankit.poc.dp.ms.events;

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

