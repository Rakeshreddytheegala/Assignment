package com.coderpad.app.model.feedback;

public class DiscourseRecordMetadata extends RecordMetadata {

  int postId;
  String topicTitleHeadLine;
  int likeCount;

  public DiscourseRecordMetadata(int postId, String topicTitleHeadLine, int likeCount) {
    this.postId = postId;
    this.likeCount = likeCount;
    this.topicTitleHeadLine = topicTitleHeadLine;
  }

  public int getPostId() {
      return postId;
  }

  public String getTopicTitleHeadLine() {
      return topicTitleHeadLine;
  }
  
  public int getLikeCount() {
      return likeCount;
  }

}