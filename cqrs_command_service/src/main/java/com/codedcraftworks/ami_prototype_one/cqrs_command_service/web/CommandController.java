package com.codedcraftworks.ami_prototype_one.cqrs_command_service.web;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// Can use these instead of @RequestMapping - used below for @DeleteMapping
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codedcraftworks.ami_prototype_one.cqrs_command_service.domain.TrainingSession;
import com.codedcraftworks.ami_prototype_one.cqrs_command_service.dto.TrainingSessionDto;
import com.codedcraftworks.ami_prototype_one.cqrs_command_service.service.TrainingSessionService;



/*
{
	"email": "mccarthy.richard@gmail.com",
	"activityName": "cycling",
	"duration": 120,
	"averageHeartRate": 145,
	"loggedDate": "15/08/2018",
	"age": 41, 
	"gender": "male", 
	"weight": 78.4
}

curl -H "Content-Type: application/json" -X POST -d '{ "email": "mccarthy.richard@gmail.com","activityName": "cycling","duration": 95,"averageHeartRate": 145,"loggedDate": "15/08/2018", "age": 41, "gender": "male", "weight": 78.4 }' http://localhost:8081/api/createTrainingSession

curl -H "Content-Type: application/json" -X PUT -d '{"email": "mccarthy.richard@gmail.com","activityName": "cycling456","duration": 120,"averageHeartRate": 145,"loggedDate": "15/08/2018", "age": 41, "gender": "male", "weight": 78.4}' http://localhost:8081/api/updateTrainingSession

curl -H "Content-Type: application/json" -X DELETE  http://localhost:8081/api/deleteTrainingSession/mccarthy.richard@gmail.com

*/



@RestController
@RequestMapping( value = "/api" )
public class CommandController {


	@Autowired
	private TrainingSessionService trainingSessionService;

	

	@RequestMapping( value = "/createTrainingSession", method = RequestMethod.POST )
	@ResponseStatus( HttpStatus.CREATED )
	public TrainingSessionDto createTrainingSession( @RequestBody TrainingSessionDto trainingSessionDto ) {

		return trainingSessionService.saveTrainingSession( trainingSessionDto );
	}



	@RequestMapping( value = "/updateTrainingSession", method = RequestMethod.PUT )
	@ResponseStatus( HttpStatus.OK )
	public TrainingSessionDto updateTrainingSession( @RequestBody TrainingSessionDto trainingSessionDto ) {

		return trainingSessionService.updateTrainingSession( trainingSessionDto );
	}


	@DeleteMapping( value = "/deleteTrainingSession/{email}" )
	public ResponseEntity<?> deleteTrainingSession( @PathVariable String email ) {

		trainingSessionService.deleteTrainingSession( email );

		return new ResponseEntity<>( HttpStatus.OK );
	}


}




