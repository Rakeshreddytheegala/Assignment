package com.coderpad.app.service.feedbackextractor;

import com.coderpad.app.model.SourceType;

public class ExtractorFactory {

  private static ExtractorFactory INSTANCE = new ExtractorFactory();

  DiscourseFeedbackExtractor discourseFeedbackExtractor;

  ExtractorFactory() {
    discourseFeedbackExtractor = new DiscourseFeedbackExtractor();
  }

  public static ExtractorFactory getInstance() {
    return INSTANCE;
  }

  public Extractor getExtractor(SourceType type) {

    switch (type) {
      case DISCOURSE:
        return discourseFeedbackExtractor;
      default:
        throw new RuntimeException(String.format("Extractor for source type %s is not yet implemented", type));
    }

  }
}