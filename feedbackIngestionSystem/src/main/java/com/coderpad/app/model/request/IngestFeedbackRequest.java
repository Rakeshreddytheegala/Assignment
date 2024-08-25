package com.coderpad.app.model.request;

import com.coderpad.app.model.feedback.*;

public class IngestFeedbackRequest {

  int topicSourceId;

  RecordData data;

  RecordMetadata recordMetadata;

  public IngestFeedbackRequest(int topicSourceId, RecordData data, RecordMetadata metadata) {
    this.topicSourceId = topicSourceId;
    this.data = data;
    this.recordMetadata = metadata;
  }

  public int getTopicSourceId() {
      return topicSourceId;
  }

  public RecordData getData() {
      return data;
  }

  public RecordMetadata getRecordMetadata() {
      return recordMetadata;
  }

}