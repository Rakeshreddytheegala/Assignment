package com.coderpad.app.cornjob;

import com.coderpad.app.BackendSystem;
import com.coderpad.app.service.*;
import com.coderpad.app.model.*;
import com.coderpad.app.model.topicsource.*;

import java.util.*;

public class PullFeedbackCornJob {

  private final static long CYCLE_LENTH_IN_MILLIS = 12 * 60 * 60 * 1000;

  public PullFeedbackCornJob() {
  }

  public void pullFeedbacks() {
    TopicSourceService topicSourceService = BackendSystem.getInstance().getTopicSourceService();
    PullFeedbackService pullFeedbackService = BackendSystem.getInstance().getPullFeedbackService();

    List<TopicSource> topicSources = topicSourceService.getAllTopicSources();

    TimeRange range = getRange();

    for (TopicSource topicSource : topicSources) {
      pullFeedbackService.pullFeedbacks(topicSource, range);
    }

  }

  private TimeRange getRange() {
    long endMillis = System.currentTimeMillis();
    long startMillis = endMillis - CYCLE_LENTH_IN_MILLIS;
    return new TimeRange(startMillis, endMillis);
  }

}