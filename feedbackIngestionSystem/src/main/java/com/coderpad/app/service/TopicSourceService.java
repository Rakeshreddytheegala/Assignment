package com.coderpad.app.service;

import java.util.*;

import com.coderpad.app.model.request.*;
import com.coderpad.app.model.topicsource.TopicSource;


public interface TopicSourceService {

  int addTopicSource(AddTopicSourceRequest request);

  TopicSource getTopicSource(int topicSourceId);

  List<TopicSource> getAllTopicSources();

}