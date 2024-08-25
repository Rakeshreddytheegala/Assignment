package com.coderpad.app.service;

import com.coderpad.app.model.request.IngestFeedbackRequest;
import com.coderpad.app.model.feedback.*;
import java.util.*;

public interface FeedbackService {

  void ingestFeedback(IngestFeedbackRequest request);

  List<Feedback> getFeedbacks(int topicSourceId);

}