package com.coderpad.app.model.request.sourcerequest;

import com.coderpad.app.model.SourceType;

public class DiscourseSourceRequest extends SourceRequest {

  int topicId;

  public DiscourseSourceRequest(int topicId) {
    super(SourceType.DISCOURSE);
    this.topicId = topicId;
  }

  public int getTopicId() {
      return topicId;
  }

}