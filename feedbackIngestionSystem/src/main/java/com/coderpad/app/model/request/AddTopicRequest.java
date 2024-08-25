package com.coderpad.app.model.request;

public class AddTopicRequest {
  int tenantId;
  String topicName;

  public AddTopicRequest(int tenantId, String topicName) {
    this.tenantId = tenantId;
    this.topicName = topicName;
  }

  public int getTenantId() {
      return tenantId;
  }

  public String getTopicName() {
      return topicName;
  }

}