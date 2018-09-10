package com.codedcraftworks.ami_prototype_one.cqrs_query_service.dto;



public class TrainingSessionDto {


	private String activityName;

	private float duration;

	private int averageHeartRate;

  private int age;

	private String gender;

	private float weight;


  public TrainingSessionDto() {}

  public TrainingSessionDto( String activityName, float duration, int averageHeartRate, 
  	int age, String gender, float weight ) {

		this.activityName = activityName;
		this.duration = duration;
		this.averageHeartRate = averageHeartRate;

		this.age = age;
		this.gender = gender;
		this.weight = weight;
  }

	@Override
  public String toString() {
  	return activityName + "=" + duration + "=" + averageHeartRate + "=" + age + "=" + gender+ "=" + weight;
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


