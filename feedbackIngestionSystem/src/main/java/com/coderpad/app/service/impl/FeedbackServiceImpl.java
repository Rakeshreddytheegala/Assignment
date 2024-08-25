package com.coderpad.app.service.impl;

import com.coderpad.app.model.feedback.*;
import com.coderpad.app.model.request.IngestFeedbackRequest;
import com.coderpad.app.model.topicsource.*;
import com.coderpad.app.repository.TopicRepository;
import com.coderpad.app.repository.TopicSourceRepository;
import com.coderpad.app.repository.FeedbackRepository;
import com.coderpad.app.service.FeedbackService;
import com.coderpad.app.service.utility.Util;

import java.util.*;

public class FeedbackServiceImpl implements FeedbackService {

  FeedbackRepository feedbackRepository;
  TopicSourceRepository topicSourceRepository;

  public FeedbackServiceImpl(FeedbackRepository feedbackRepository, TopicSourceRepository topicSourceRepository) {
    this.feedbackRepository = feedbackRepository;
    this.topicSourceRepository = topicSourceRepository;
  }

  public void ingestFeedback(IngestFeedbackRequest request) {

    int topicSourceId = request.getTopicSourceId();
    System.out.println("request is " + topicSourceId);

    TopicSource topicSource = getTopicSource(topicSourceId);

    Optional<Feedback> existingSimilarFeedback = getExistingSimilarFeedback(topicSource,
        request.getRecordMetadata());

    if (existingSimilarFeedback.isPresent()) {
      existingSimilarFeedback.get().updateData(request.getData());
      existingSimilarFeedback.get().updateRecordMetadata(request.getRecordMetadata());

    } else {

      Feedback feedbackToIngest = new Feedback(
          feedbackRepository.getIdGenerator().getNewId(),
          topicSourceId,
          request.getData(),
          request.getRecordMetadata());

      feedbackRepository.addFeedback(feedbackToIngest);
    }
  }

  public List<Feedback> getFeedbacks(int topicSourceId) {
    return feedbackRepository.getFeedbacks(topicSourceId);
  }

  private Optional<Feedback> getExistingSimilarFeedback(TopicSource ingestingSource,
      RecordMetadata ingestingMetadata) {
    List<Feedback> existingFeedbacks = feedbackRepository.getFeedbacks(ingestingSource.getTopicSourceId());

    return existingFeedbacks.stream()
        .filter(feedback -> Util.compareFeedbackRecords(ingestingSource.getSourceType(), ingestingMetadata,
            feedback.getRecordMetadata()))
        .findFirst();
  }

  private TopicSource getTopicSource(int topicSourceId) {
    try {
      return topicSourceRepository.getTopicSource(topicSourceId);
    } catch (NoSuchElementException e) {
      throw new IllegalArgumentException(String.format("Topic Source Id %d not found", topicSourceId), e);
    }
  }

}