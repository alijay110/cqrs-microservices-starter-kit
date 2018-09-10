package com.codedcraftworks.ami_prototype_one.cqrs_command_service.domain;


import java.time.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Embedded;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;



@Entity( name = "TrainingSession" )
@Table( name = "training_session" )
public class TrainingSession {

	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column( name = "id" )
	private int id;

	@Id
	private String email;

	@Column( name = "activity_name" )
	private String activityName;

	// E.g 2.5 means two and a half hours
	@Column( name = "duration" )
	private float duration;

	@Column( name = "average_heart_rate" )
	private int averageHeartRate;

	@Column( name = "logged_date" )
	private LocalDate loggedDate; 


	@AttributeOverrides({
            @AttributeOverride(name="age",
                               column=@Column(name="age")),
            @AttributeOverride(name="gender",
                               column=@Column(name="gender")),
            @AttributeOverride(name="weight",
                               column=@Column(name="weight"))
        })
	@Embedded
	private AthleteBioDetails athleteBioDetails;



	public TrainingSession() {}


	public TrainingSession( String email, String activityName, float duration, int averageHeartRate, LocalDate loggedDate ) {

		this.email = email;
		this.activityName = activityName;
		this.duration = duration;
		this.averageHeartRate = averageHeartRate;
		this.loggedDate = loggedDate;
	}


	@Override
	public String toString() {
		return this.email + " - " + this.activityName + " - " + this.loggedDate;
	}

	/**
	 * Using Business Key Equality - 
	 * Best not to use == as this can end up different between attached and detached objects in Hiberate
   * Best not to use generated identifiers as end up with different states between a 
   * persisted object (that has been assigned an identifier) than to a new created instance which 
   * will not have any identifier value generated for it yet.
	 */
	@Override
	public boolean equals( Object obj ) {

		if ( !( obj instanceof TrainingSession ) ) {
			return false;
		}

		TrainingSession tr = (TrainingSession)obj;
		if ( !tr.getEmail().equals( this.getEmail() ) ) {
			return false;
		}

		return true;
	}


	// Getters & Setters

	public int getId() {
		return id;
	}

	public void setId( int id ) {
		this.id = id;
	}

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

	public AthleteBioDetails getAthleteBioDetails() {
		return athleteBioDetails;
	}

	public void setAthleteBioDetails( AthleteBioDetails athleteBioDetails ) {
		this.athleteBioDetails = athleteBioDetails;
	}

}