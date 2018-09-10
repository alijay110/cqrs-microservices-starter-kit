package com.codedcraftworks.ami_prototype_one.cqrs_command_service.domain;


import javax.persistence.Embeddable;
import javax.persistence.Column;


@Embeddable
public class AthleteBioDetails {


	@Column( name = "age" )
	private int age;

	@Column( name = "gender" )
	private String gender;

	@Column( name = "weight" )
	private float weight;



	// JPA requirement
	public AthleteBioDetails() {}

	public AthleteBioDetails( int age, String gender, float weight ) {

		this.age = age;
		this.gender = gender;
		this.weight = weight;
	}


	// Getters & Setters

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