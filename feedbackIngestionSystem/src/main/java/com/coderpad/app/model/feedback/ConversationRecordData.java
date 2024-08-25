package com.coderpad.app.model.feedback;

import java.util.*;

public class ConversationRecordData extends RecordData {

  List<String> conversations;

  public ConversationRecordData(List<String> conversations) {
    super(RecordType.CONVERSATION);

    this.conversations = conversations;
  }

}