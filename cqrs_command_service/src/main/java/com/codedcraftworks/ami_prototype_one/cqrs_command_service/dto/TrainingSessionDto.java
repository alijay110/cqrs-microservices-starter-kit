package com.codedcraftworks.ami_prototype_one.cqrs_command_service.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public class TrainingSessionDto {


	private String email;

	private String activityName;

	private float duration;

	private int averageHeartRate;


	// Formats output date when this DTO is passed through JSON
	@JsonFormat( pattern = "dd/MM/yyyy" )
	// Allows dd/MM/yyyy date to be passed into GET request in JSON
	@DateTimeFormat( pattern = "dd/MM/yyyy" )
  private LocalDate loggedDate;

  // The next 3 properties will be mapped to a separate ValueObject in the Domain Model

  private int age;

	private String gender;

	private float weight;



  public TrainingSessionDto() {}

  public TrainingSessionDto( String email, String activityName, float duration, int averageHeartRate, 
  	LocalDate loggedDate, int age, String gender, float weight ) {

  	this.email = email;
		this.activityName = activityName;
		this.duration = duration;
		this.averageHeartRate = averageHeartRate;
		this.loggedDate = loggedDate;

		this.age = age;
		this.gender = gender;
		this.weight = weight;
  }


  // Getters & Setters

	public String getEmail() {
		return email;
	}

	public void setEmail( String email ) {
		this.email = email;
	}

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

	public LocalDate getLoggedDate() {
		return loggedDate;
	}

	public void setLoggedDate( LocalDate loggedDate ) {
		this.loggedDate = loggedDate;
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


