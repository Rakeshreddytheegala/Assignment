package com.coderpad.app.service.pushfeedbackendpoints;

import org.json.JSONObject;

import com.coderpad.app.BackendSystem;
import com.coderpad.app.model.request.IngestFeedbackRequest;
import com.coderpad.app.service.FeedbackRecordWrapper;
import com.coderpad.app.service.FeedbackService;
import com.coderpad.app.service.parsers.DiscourseParser;

public class DiscourseFeedbackEndpoint {

  void pushfeedbackendpoints(int topicSourceId, String discoursePost) {

    JSONObject post = new JSONObject(discoursePost);

    FeedbackRecordWrapper record = DiscourseParser.parse(post);

    IngestFeedbackRequest request = new IngestFeedbackRequest(topicSourceId, record.getData(),
        record.getMetadata());

    FeedbackService feedbackService = BackendSystem.getInstance().getFeedbackService();

    feedbackService.ingestFeedback(request);

  }

}