package com.coderpad.app.service.impl;

import java.util.*;

import com.coderpad.app.model.request.*;
import com.coderpad.app.model.request.sourcerequest.SourceRequest;
import com.coderpad.app.repository.TopicSourceRepository;
import com.coderpad.app.service.TopicSourceService;
import com.coderpad.app.service.utility.Util;
import com.coderpad.app.model.topicsource.*;

public class TopicSourceServiceImpl implements TopicSourceService {

  TopicSourceRepository topicSourceRepository;

  public TopicSourceServiceImpl(TopicSourceRepository topicSourceRepository) {
    this.topicSourceRepository = topicSourceRepository;
  }

  public int addTopicSource(AddTopicSourceRequest request) {
    
    TopicSource topicSource =  Util.createTopicSource(
      topicSourceRepository.getIdGenerator().getNewId(),
      request.getTopicId(),
      request.getSourcerequest()
    );
    topicSourceRepository.addTopicSource(topicSource);

    return topicSource.getTopicSourceId();
  }

  public TopicSource getTopicSource(int topicSourceId) {
    return topicSourceRepository.getTopicSource(topicSourceId);
  }

  public List<TopicSource> getAllTopicSources() {
    return topicSourceRepository.getAllTopicSource();
  }

}