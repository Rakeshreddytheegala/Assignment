package com.coderpad.app.model.request.sourcerequest;

import com.coderpad.app.model.SourceType;

public class PlayStoreSourceRequest extends SourceRequest {


  public PlayStoreSourceRequest(int topicId) {
    super(SourceType.PLAY_STORE);
  }

}