package com.coderpad.app.model.feedback;

public class Feedback {
  int feedbackId;

  int topicSourceId;

  RecordData data;
  RecordMetadata recordMetadata;

  public Feedback(int feedbackId,int topicSourceId,
      RecordData data, RecordMetadata recordMetadata) {
    this.feedbackId = feedbackId;
    this.topicSourceId = topicSourceId;
    this.data = data;
    this.recordMetadata = recordMetadata;
  }

  public int getFeedbackId() {
    return feedbackId;
  }

  public int getTopicSourceId() {
    return topicSourceId;
  }

  public RecordData getData() {
    return data;
  }

  public void updateData(RecordData data) {
    this.data = data;
  }

  public RecordMetadata getRecordMetadata() {
    return recordMetadata;
  }

  public void updateRecordMetadata(RecordMetadata metadata) {
    this.recordMetadata = metadata;
  }

}