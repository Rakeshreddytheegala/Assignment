package com.coderpad.app.model.feedback;

public abstract class RecordData {

  RecordType recordType;

  public RecordData(RecordType type) {
    this.recordType = type;
  }

  RecordType getType() {
    return recordType;
  }  

}