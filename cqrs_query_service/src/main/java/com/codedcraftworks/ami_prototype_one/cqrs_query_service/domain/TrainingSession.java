package com.codedcraftworks.ami_prototype_one.cqrs_query_service.domain;


import org.bson.types.ObjectId;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This class is the Domain Model for the MongoDB Collection 
 * called training_sessions
 *
 *
 * @author Richard McCarthy
 */

@Document( collection = "training_sessions" )
public class TrainingSession {


	@Id
	private ObjectId id;

	@Indexed
	private String activityName;

	private float duration;

	private int averageHeartRate;

  private int age;

	private String gender;

	private float weight;


  public TrainingSession() {} 

  public TrainingSession( String activityName, float duration, int averageHeartRate, 
  	int age, String gender, float weight ) {

		this.activityName = activityName;
		this.duration = duration;
		this.averageHeartRate = averageHeartRate;

		this.age = age;
		this.gender = gender;
		this.weight = weight;
  }

  // Getters & Setters

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName( String activityName ) {
		this.activityName = activityName;
	}

	public float getDuration() {
		return duration;
	}

	public void setDuration( float duration ) {
		this.duration = duration;
	}

	public int getAverageHeartRate() {
		return averageHeartRate;
	}

	public void setAverageHeartRate( int averageHeartRate ) {
		this.averageHeartRate = averageHeartRate;
	}

	public int getAge() {
		return age;
	}

	public void setAge( int age ) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender( String gender ) {
		this.gender = gender;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight( float weight ) {
		this.weight = weight;
	}


}


