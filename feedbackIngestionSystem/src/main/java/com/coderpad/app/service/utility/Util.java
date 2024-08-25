package com.coderpad.app.service.utility;

import com.coderpad.app.model.SourceType;
import com.coderpad.app.model.feedback.DiscourseRecordMetadata;
import com.coderpad.app.model.feedback.RecordMetadata;
import com.coderpad.app.model.request.sourcerequest.DiscourseSourceRequest;
import com.coderpad.app.model.request.sourcerequest.SourceRequest;
import com.coderpad.app.model.topicsource.*;
import java.util.*;

public class Util {

  public static TopicSource createTopicSource(int sourceId, int topicId, SourceRequest request) {

    switch (request.getSourceType()) {
      case DISCOURSE:
        return DiscourseUtil.createTopicSource(sourceId, topicId, (DiscourseSourceRequest) request);
      default:
        throw new RuntimeException(
            String.format("Utility handler for sourceType %d not yet implemented", request.getSourceType()));
    }
  }

  public static boolean compareFeedbackRecords(SourceType sourceType, RecordMetadata metadata1,
      RecordMetadata metadata2) {

    switch (sourceType) {
      case DISCOURSE:
        return DiscourseUtil.compare(
            (DiscourseRecordMetadata) metadata1,
            (DiscourseRecordMetadata) metadata2);
      default:
        throw new RuntimeException(
            String.format("Utility handler for sourceType %d not yet implemented", sourceType));
    }
  }
}