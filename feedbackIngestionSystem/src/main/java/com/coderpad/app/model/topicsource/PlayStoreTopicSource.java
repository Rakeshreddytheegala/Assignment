package com.coderpad.app.model.topicsource;

import com.coderpad.app.model.SourceType;
import com.coderpad.app.model.feedback.RecordMetadata;

public class PlayStoreTopicSource extends TopicSource {

  public PlayStoreTopicSource(int topicSourceId, int topicId) {
    super(topicSourceId, topicId, SourceType.PLAY_STORE);
  }
}