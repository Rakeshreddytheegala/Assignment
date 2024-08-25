package com.coderpad.app.model.topic;

import java.time.Instant;

public class Topic {
  int id;
  String topicName;
  int tenantId;
  Instant createdTime;
  TopicState state;

  public Topic(int id , int tenantId, String topicName) {
    this.id = id;
    this.topicName = topicName;
    this.tenantId = tenantId;
    this.createdTime = Instant.ofEpochMilli(System.currentTimeMillis());
    this.state = TopicState.ACTIVE;
  }

  public int getId() {
    return id;
  }

}
