package com.coderpad.app;

import com.coderpad.app.cornjob.*;
import com.coderpad.app.model.feedback.*;
import com.coderpad.app.model.request.*;
import com.coderpad.app.model.request.sourcerequest.DiscourseSourceRequest;
import com.coderpad.app.service.*;

public class Main {
  public static void main(String[] args) {
    BackendSystem factory = BackendSystem.getInstance();
    TenantService tenantService = factory.getTenantService();
    TopicService topicService = factory.getTopicService();
    TopicSourceService topicSourceService = factory.getTopicSourceService();
    FeedbackService feedbackService = factory.getFeedbackService();

    PullFeedbackCornJob cornJob = new PullFeedbackCornJob();

    int tenantId = tenantService.addTenant(new AddTenantRequest("tenant1"));
    int topicId = topicService.addTopic(new AddTopicRequest(tenantId, "topicName"));

    // Add Discourse source Request;
    DiscourseSourceRequest sourceRequest = new DiscourseSourceRequest(320712);
    int topicSourceId = topicSourceService.addTopicSource(new AddTopicSourceRequest(topicId, sourceRequest));    

    cornJob.pullFeedbacks();

    // Get Feedback;
    for(Feedback feedback : feedbackService.getFeedbacks(topicSourceId)) {
      ReviewRecordData data = (ReviewRecordData)feedback.getData();
      DiscourseRecordMetadata metadata = (DiscourseRecordMetadata)feedback.getRecordMetadata();

      System.out.println("data " + data.getReview());
    }

  }
}