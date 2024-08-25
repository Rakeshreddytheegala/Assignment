package com.coderpad.app.model.request.sourcerequest;

import com.coderpad.app.model.SourceType;

public abstract class SourceRequest {

  SourceType sourceType;

  SourceRequest(SourceType sourceType) {
    this.sourceType = sourceType;    
  }

  public SourceType getSourceType() {
      return sourceType;
  }

}