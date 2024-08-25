package com.coderpad.app.model.topicsource;

import com.coderpad.app.model.SourceType;

public abstract class TopicSource {
  int topicSourceId;

  int topicId;
  SourceType sourceType;

  TopicSource(int topicSourceId, int topicId, SourceType sourceType) {
    this.topicSourceId = topicSourceId;
    this.topicId = topicId;
    this.sourceType = sourceType;
  }

  public SourceType getSourceType() {
      return sourceType;
  }

  public int getTopicSourceId() {
      return topicSourceId;
  }
}