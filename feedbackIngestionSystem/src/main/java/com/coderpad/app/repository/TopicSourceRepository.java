package com.coderpad.app.repository;

import java.util.*;
import com.coderpad.app.model.topicsource.*;

public class TopicSourceRepository {
  Map<Integer , TopicSource> topicSources;
  IdGenerator idGenerator; 

  public TopicSourceRepository() {
    topicSources = new HashMap<Integer, TopicSource>();
    idGenerator = new IdGenerator();
  }

  public IdGenerator getIdGenerator() {
      return idGenerator;
  }

  public void addTopicSource(TopicSource topicSource) {
     topicSources.put(topicSource.getTopicSourceId(), topicSource);
  }

  public TopicSource getTopicSource(int topicsourceId) {
    if(!topicSources.containsKey(topicsourceId)) {
      throw new NoSuchElementException("Topic source not present");
    }
    return topicSources.get(topicsourceId);
  }

  public List<TopicSource> getAllTopicSource() {
    return new ArrayList<>(topicSources.values());
  }

}