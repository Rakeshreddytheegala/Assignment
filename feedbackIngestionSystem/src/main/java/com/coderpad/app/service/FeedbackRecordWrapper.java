package com.coderpad.app.service;

import com.coderpad.app.model.feedback.*;

public abstract class FeedbackRecordWrapper {

  public abstract RecordData getData();

  public abstract RecordMetadata getMetadata();
}