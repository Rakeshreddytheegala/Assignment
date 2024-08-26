# FeedbackIngestionSystem.

* The backend ingestion supports different types of sources to ingest feedback into a topic.
* Tenants can listen to this feedback in the topic.

## Data Model

* System has mainly three components - Tenant, Topic, TopicSource
* Tenant : 
  *  This refers to the end users of the backend system.
  *  Each tenant needs to register with the system and start creating new topics. 
* Topic :
   * This refers to the topics to which sources will ingest the feedback to.
   * Each Topic can have multiple sources like two play store apps or one playstore app and one discourse etc.    
* TopicSource :
   * This refers to the system which ingest the feedbacks to a topic.
   * While adding new source , source specific identifiers needs to be provided. For example, topic_id for discourse , app id for play store. 
   * System currently supports three type of sources : DISCOURSE , INTERCOM , PLAY_STORE , TWITTER

## Features

* System runs a corn job to which reads all the topicSources database and call the sources. The System needs to invoke : PullFeedbackCornJob.java daily to extract the data. 
* System also created the endpoints for sources to push the data.
* Currently only DISCOURSE source data extractor and push endpointsare implemented.

## Usage 

* BackendSystem.java provides the services to the backend system which you can call from Main.java
    
* PullFeedbackCornJob.java is currenlty not scheduled but you can invoke it Main.java
