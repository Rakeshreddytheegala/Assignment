package com.coderpad.app;

import com.coderpad.app.repository.*;
import com.coderpad.app.service.*;
import com.coderpad.app.service.impl.*;

public class BackendSystem {

  private static BackendSystem INSTANCE = new BackendSystem();

  // Setup services
  private FeedbackService feedbackService;
  private TenantService tenantService;
  private TopicService topicService;
  private TopicSourceService topicSourceService;
  private PullFeedbackService pullFeedbackService;

  BackendSystem() {

    // Setup repositories
    FeedbackRepository feedbackRepository = new FeedbackRepository();
    TenantRepository tenantRepository = new TenantRepository();
    TopicRepository topicRepository = new TopicRepository();
    TopicSourceRepository topicSourceRepository = new TopicSourceRepository();

    // Setup services
    tenantService = new TenantServiceImpl(tenantRepository);
    topicService = new TopicServiceImpl(topicRepository);
    topicSourceService = new TopicSourceServiceImpl(topicSourceRepository);
    feedbackService = new FeedbackServiceImpl(feedbackRepository, topicSourceRepository);
    pullFeedbackService = new PullFeedbackServiceImpl();

  }

  public static BackendSystem getInstance() {
      return INSTANCE;
  }

  public FeedbackService getFeedbackService() {
      return feedbackService;
  }

  public TenantService getTenantService() {
      return tenantService;
  }

  public TopicService getTopicService() {
      return topicService;
  }

  public TopicSourceService getTopicSourceService() {
      return topicSourceService;
  }

  public PullFeedbackService getPullFeedbackService() {
      return pullFeedbackService;
  }

}