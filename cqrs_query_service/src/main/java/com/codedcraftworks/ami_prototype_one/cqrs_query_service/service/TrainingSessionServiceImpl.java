package com.codedcraftworks.ami_prototype_one.cqrs_query_service.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.codedcraftworks.ami_prototype_one.cqrs_query_service.domain.TrainingSession;
import com.codedcraftworks.ami_prototype_one.cqrs_query_service.dto.TrainingSessionDto;
import com.codedcraftworks.ami_prototype_one.cqrs_query_service.repository.TrainingSessionRepository;

import org.modelmapper.ModelMapper;

/**
 * This service class implements {@link TrainingSessionService} to provide
 * functionality for accessing the data storage layer.
 *
 * @author Richard McCarthy 
 *
 */
@Service
public class TrainingSessionServiceImpl implements TrainingSessionService {

	@Autowired
	private TrainingSessionRepository trainingSessionRepository;

	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public List<TrainingSessionDto> getTrainingSessionsByActivity( String activityName ) {

		List<TrainingSession> trainingSessions = trainingSessionRepository.findTrainingSessionsByActivityName( activityName );
		return convertListOfDocumentsToDtoList( trainingSessions );
	}



	@Override
	public List<TrainingSessionDto> getTrainingSessionsByAge( int age ) {

			List<TrainingSession> trainingSessions = trainingSessionRepository.findTrainingSessionsByAge( age );
			return convertListOfDocumentsToDtoList( trainingSessions );
	}


	private List<TrainingSessionDto> convertListOfDocumentsToDtoList( List<TrainingSession> trainingSessions ) {

		List<TrainingSessionDto> convertedTrainingSessions = new ArrayList<>();
		for ( TrainingSession trainingSession: trainingSessions ) {
			convertedTrainingSessions.add( modelMapper.map( trainingSession, TrainingSessionDto.class ) );
		}
		return convertedTrainingSessions;
	}


}




