package com.coderpad.app.service;


import com.coderpad.app.model.topicsource.*;
import com.coderpad.app.model.TimeRange;

public interface PullFeedbackService {

  void pullFeedbacks(TopicSource topicSource, TimeRange range);
}