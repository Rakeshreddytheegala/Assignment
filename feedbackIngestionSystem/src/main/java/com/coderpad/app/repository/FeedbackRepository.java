package com.coderpad.app.repository;

import java.util.*;
import java.util.stream.Collectors;

import com.coderpad.app.model.feedback.*;

public class FeedbackRepository {
  Map<Integer, Feedback> feedbacks;
  IdGenerator idGenerator;

  public FeedbackRepository() {
    feedbacks = new HashMap<Integer, Feedback>();
    idGenerator = new IdGenerator();
  }

  public IdGenerator getIdGenerator() {
    return idGenerator;
  }

  public void addFeedback(Feedback feedback) {
    feedbacks.put(feedback.getFeedbackId(), feedback);
  }

  public List<Feedback> getFeedbacks(int topicSourceId) {
    return feedbacks.values()
        .stream()
        .filter(feedback -> feedback.getTopicSourceId() == topicSourceId)
        .collect(Collectors.toList());
  }

}