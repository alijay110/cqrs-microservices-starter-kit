package com.codedcraftworks.ami_prototype_one.cqrs_query_service.service;

import java.util.List;

import com.codedcraftworks.ami_prototype_one.cqrs_query_service.dto.TrainingSessionDto;


public interface TrainingSessionService {

	List<TrainingSessionDto> getTrainingSessionsByActivity( String activityName );

	List<TrainingSessionDto> getTrainingSessionsByAge( int age );

}
