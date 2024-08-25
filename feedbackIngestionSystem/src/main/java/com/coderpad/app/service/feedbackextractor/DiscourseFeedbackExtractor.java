package com.coderpad.app.service.feedbackextractor;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.lang.*;

import org.json.*;

import com.coderpad.app.model.TimeRange;
import com.coderpad.app.model.topicsource.DiscourseTopicSource;
import com.coderpad.app.model.topicsource.TopicSource;
import com.coderpad.app.service.FeedbackRecordWrapper;
import com.coderpad.app.service.parsers.DiscourseParser;

public class DiscourseFeedbackExtractor implements Extractor {

  DiscourseFeedbackExtractor() {
  }

  public List<FeedbackRecordWrapper> extract(TopicSource source, TimeRange range) {

    DiscourseTopicSource discourseSource = (DiscourseTopicSource) source;

    JSONArray posts;
    try {
      posts = getDiscourcePosts(range);
    } catch (IOException e) {
      throw new RuntimeException(
          String.format("Error while extracing disouce post for source %d", source.getTopicSourceId()), e);
    }

    return IntStream.range(0, posts.length())
        .mapToObj(posts::getJSONObject)
        .filter(post -> post.getInt("topic_id") == discourseSource.getDiscourceTopicId()) // Get posts for a topic.
        .map(DiscourseParser::parse) // Parse the post.
        .collect(Collectors.toList());
  }

  private JSONArray getDiscourcePosts(TimeRange range) throws IOException {

    String command = getUrlCommandToGetDiscoursePost(range);

    Process process = Runtime.getRuntime().exec(command);
    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

    String line;
    String jsonResponse = "";
    while ((line = reader.readLine()) != null) {
      jsonResponse = jsonResponse.concat(line);
    }

    return new JSONObject(jsonResponse).getJSONArray("posts");
  }

  private static String getUrlCommandToGetDiscoursePost(TimeRange range) {
    return "curl --location --request GET https://meta.discourse.org/search.json?q=after%3A+"
        + getDate(range.getStartMillis()) + "+before%3A" + getDate(range.getEndMillis());
  }

  private static String getDate(long timeMillis) {
    return Instant.ofEpochMilli(timeMillis)
        .atZone(ZoneId.systemDefault())
        .toLocalDate()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
  }

}