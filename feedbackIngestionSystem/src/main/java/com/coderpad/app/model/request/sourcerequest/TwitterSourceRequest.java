package com.coderpad.app.model.request.sourcerequest;

import com.coderpad.app.model.SourceType;

public class TwitterSourceRequest extends SourceRequest {

  public TwitterSourceRequest(int topicId) {
    super(SourceType.DISCOURSE);
  }

}