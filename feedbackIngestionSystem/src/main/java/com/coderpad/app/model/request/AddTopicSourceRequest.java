package com.coderpad.app.model.request;

import com.coderpad.app.model.request.sourcerequest.SourceRequest;

public class AddTopicSourceRequest {
  int topicId;
  SourceRequest sourcerequest;

  public AddTopicSourceRequest(int topicId, SourceRequest sourceRequest) {
    this.topicId = topicId;
    this.sourcerequest = sourceRequest;
  }

  public int getTopicId() {
      return topicId;
  }

  public SourceRequest getSourcerequest() {
      return sourcerequest;
  }
}
