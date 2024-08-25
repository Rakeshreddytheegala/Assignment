package com.coderpad.app.model.topicsource;

import com.coderpad.app.model.SourceType;

public class IntercomTopicSource extends TopicSource {

  public IntercomTopicSource(int topicSourceId, int topicId) {
    super(topicSourceId, topicId, SourceType.INTERCOM);
  }
}