package com.coderpad.app.service.impl;

import java.util.*;

import com.coderpad.app.model.request.*;
import com.coderpad.app.model.request.sourcerequest.SourceRequest;
import com.coderpad.app.repository.TopicRepository;
import com.coderpad.app.service.TopicService;
import com.coderpad.app.service.utility.Util;
import com.coderpad.app.model.topic.*;

public class TopicServiceImpl implements TopicService {

  TopicRepository topicRepository;

  public TopicServiceImpl(TopicRepository topicRepository) {
    this.topicRepository = topicRepository;
  }

  public int addTopic(AddTopicRequest request) {
    Topic topic = new Topic(
        topicRepository.getIdGenerator().getNewId(),
        request.getTenantId(),
        request.getTopicName());
    topicRepository.addTopic(topic);
    return topic.getId();
  }

  public Topic getTopic(int topicId) {
    return topicRepository.getTopic(topicId);
  }



}