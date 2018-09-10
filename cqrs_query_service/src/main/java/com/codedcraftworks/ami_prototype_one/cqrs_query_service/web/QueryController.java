package com.codedcraftworks.ami_prototype_one.cqrs_query_service.web;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;

import com.codedcraftworks.ami_prototype_one.cqrs_query_service.dto.TrainingSessionDto;
import com.codedcraftworks.ami_prototype_one.cqrs_query_service.service.TrainingSessionService;


/*
curl -H "Content-Type: application/json" -X GET  http://localhost:8080/api/getTrainingSessions/activity/{activity}

curl -H "Content-Type: application/json" -X GET  http://localhost:8080/api/getTrainingSessions/age/{age}   (something like age greater than 30 for example)

Return structure:
{
	"activityName": "cycling",
	"duration": 120,
	"averageHeartRate": 145,
	"age": 41, 
	"gender": "male", 
	"weight": 78.4
}
*/


@RestController
@RequestMapping( value = "/api" )
public class QueryController {


	@Autowired
	private TrainingSessionService trainingSessionService;


	@RequestMapping( value = "/getTrainingSessions/activity/{activityName}", method = RequestMethod.GET )
	@ResponseStatus( HttpStatus.OK )
	public List<TrainingSessionDto> getTrainingSessionsByActivity( @PathVariable String activityName ) {

		List<TrainingSessionDto> trainingSessions = trainingSessionService.getTrainingSessionsByActivity( activityName );
		return trainingSessions;
	}


	@RequestMapping( value = "/getTrainingSessions/age/{age}", method = RequestMethod.GET )
	@ResponseStatus( HttpStatus.OK )
	public List<TrainingSessionDto> getTrainingSessionsByAge( @PathVariable int age ) {

		List<TrainingSessionDto> trainingSessions = trainingSessionService.getTrainingSessionsByAge( age );
		return trainingSessions;
	}

}

