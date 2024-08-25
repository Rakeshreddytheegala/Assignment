package com.coderpad.app.model.feedback;

public class ReviewRecordData extends RecordData {

  String review;

  public ReviewRecordData(String review) {
    super(RecordType.REVIEW);

    this.review = review;
  }

  public String getReview() {
      return review;
  }
}