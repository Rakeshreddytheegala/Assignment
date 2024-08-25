package com.coderpad.app.repository;

import java.util.*;
import com.coderpad.app.model.topic.*;

public class TopicRepository {
  Map<Integer , Topic> topics;
  IdGenerator idGenerator; 

  public TopicRepository() {
    topics = new HashMap<Integer, Topic>();
    idGenerator = new IdGenerator();
  }

  public IdGenerator getIdGenerator() {
      return idGenerator;
  }

  public void addTopic(Topic topic) {
    topics.put(topic.getId(), topic);
  }

  public Topic getTopic(int topicId) {
    if(!topics.containsKey(topicId)) {
      throw new NoSuchElementException("Topic not present");
    }
    return topics.get(topicId);
  }
}