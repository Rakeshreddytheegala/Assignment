package com.coderpad.app.service.feedbackextractor;

import java.io.*;
import java.util.*;

import com.coderpad.app.model.TimeRange;
import com.coderpad.app.model.topicsource.*;
import com.coderpad.app.service.FeedbackRecordWrapper;

public interface Extractor {

  List<FeedbackRecordWrapper> extract(TopicSource source, TimeRange range);
  
}