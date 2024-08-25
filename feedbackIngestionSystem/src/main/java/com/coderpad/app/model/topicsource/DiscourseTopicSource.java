package com.coderpad.app.model.topicsource;

import com.coderpad.app.model.SourceType;

public class DiscourseTopicSource extends TopicSource {

  int discourceTopicId;

  public DiscourseTopicSource(int topicSourceId, int topicId, int discourceTopicId) {
    super(topicSourceId, topicId, SourceType.DISCOURSE);
 
    this.discourceTopicId = discourceTopicId;
  } 

  public int getDiscourceTopicId() {
      return discourceTopicId;
  }
}