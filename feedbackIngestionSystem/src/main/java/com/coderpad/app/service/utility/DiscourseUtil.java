package com.coderpad.app.service.utility;

import com.coderpad.app.model.feedback.*;
import com.coderpad.app.model.request.sourcerequest.*;
import com.coderpad.app.model.topicsource.*;

public class DiscourseUtil {

  public static TopicSource createTopicSource(int sourceId, int topicId, DiscourseSourceRequest request) {
    return new DiscourseTopicSource(sourceId, topicId, request.getTopicId());
  }

  public static boolean compare(DiscourseRecordMetadata metadata1, DiscourseRecordMetadata metadata2) {
    return metadata1.getPostId() == metadata2.getPostId();
  }

}