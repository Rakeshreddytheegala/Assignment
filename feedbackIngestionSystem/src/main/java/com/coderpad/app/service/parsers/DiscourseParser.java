package com.coderpad.app.service.parsers;

import org.json.JSONObject;

import com.coderpad.app.model.feedback.*;
import com.coderpad.app.service.FeedbackRecordWrapper;

public class DiscourseParser {

  public static FeedbackRecordWrapper parse(JSONObject discoursePost) {

    int postId = discoursePost.getInt("id");
    String blurb = discoursePost.getString("blurb");
    String topicTitleHeadline = discoursePost.getString("topic_title_headline");
    int likeCount = discoursePost.getInt("like_count");


    ReviewRecordData data = new ReviewRecordData(blurb);
    DiscourseRecordMetadata metadata = new DiscourseRecordMetadata(postId, topicTitleHeadline, likeCount);


    return new FeedbackRecordWrapper() {
      @Override
      public RecordData getData() {
        return data;
      }

      @Override
      public RecordMetadata getMetadata() {
        return metadata;
      }
    };
  }
}