package com.coderpad.app.model.topicsource;

import com.coderpad.app.model.SourceType;

public class TwitterTopicSource extends TopicSource {

  public TwitterTopicSource(int topicSourceId, int topicId) {
    super(topicSourceId, topicId, SourceType.TWITTER);
  }
}