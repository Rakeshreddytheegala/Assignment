package com.coderpad.app.service;

import java.util.*;

import com.coderpad.app.model.request.*;
import com.coderpad.app.model.topic.*;


public interface TopicService {

  int addTopic(AddTopicRequest request);

  Topic getTopic(int topicId);

}