package com.coderpad.app.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import com.coderpad.app.BackendSystem;
import com.coderpad.app.model.TimeRange;
import com.coderpad.app.model.request.IngestFeedbackRequest;
import com.coderpad.app.model.topicsource.TopicSource;
import com.coderpad.app.service.*;
import com.coderpad.app.service.feedbackextractor.*;

public class PullFeedbackServiceImpl implements PullFeedbackService {

  ExtractorFactory extractorFactory;

  public PullFeedbackServiceImpl() {
    this.extractorFactory = ExtractorFactory.getInstance();
  }

  public void pullFeedbacks(TopicSource topicSource, TimeRange range) {

    Extractor feedbackextractor = extractorFactory.getExtractor(topicSource.getSourceType());
    List<FeedbackRecordWrapper> records = feedbackextractor.extract(topicSource, range);
    List<IngestFeedbackRequest> ingestionRequests = getIngestFeedbackRequests(topicSource, records);
    FeedbackService feedbackService = BackendSystem.getInstance().getFeedbackService();

    ingestionRequests.forEach(request -> feedbackService.ingestFeedback(request));
  }

  private List<IngestFeedbackRequest> getIngestFeedbackRequests(TopicSource topicSource,
      List<FeedbackRecordWrapper> records) {
    return records.stream().map(record -> new IngestFeedbackRequest(topicSource.getTopicSourceId(), record.getData(),
        record.getMetadata())).collect(Collectors.toList());
  }

}