package com.coderpad.app.model.request.sourcerequest;

import com.coderpad.app.model.SourceType;

public class IntercomSourceRequest extends SourceRequest {

  public IntercomSourceRequest(int topicId) {
    super(SourceType.INTERCOM);
  }

}