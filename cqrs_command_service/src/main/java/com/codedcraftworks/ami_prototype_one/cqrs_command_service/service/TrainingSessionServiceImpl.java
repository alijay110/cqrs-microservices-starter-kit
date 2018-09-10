package com.codedcraftworks.ami_prototype_one.cqrs_command_service.service;


import java.lang.IllegalArgumentException;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.codedcraftworks.ami_prototype_one.cqrs_command_service.dto.TrainingSessionDto;
import com.codedcraftworks.ami_prototype_one.cqrs_command_service.domain.TrainingSession;
import com.codedcraftworks.ami_prototype_one.cqrs_command_service.repository.TrainingSessionRepository;
import com.codedcraftworks.ami_prototype_one.cqrs_command_service.utils.DtoEntityMappingConversions;


import com.codedcraftworks.ami_prototype_one.cqrs_command_service.domain.AthleteBioDetails;

import com.codedcraftworks.ami_prototype_one.cqrs_command_service.publisher.TrainingSessionMessageProducer;

import java.time.*;

@Service
public class TrainingSessionServiceImpl implements TrainingSessionService {


	@Autowired
	private TrainingSessionRepository trainingSessionRepository;

	@Autowired 
	private DtoEntityMappingConversions mapper;

	@Autowired
	private TrainingSessionMessageProducer trainingSessionMessageProducer;

	@Override
	public TrainingSessionDto saveTrainingSession( TrainingSessionDto trainingSessionDto ) {

//System.out.println( "===============> " );
//System.out.println( "MADE IT TO HERE " );

		TrainingSession convertedToEntity = mapper.convertToEntity( trainingSessionDto );

//System.out.println( "AFTER MAPPER CONVERSION!!! " );
//System.out.println( "THE PASSED IN AGE IS: " + convertedToEntity.getAthleteBioDetails().getAge() );
//System.out.println( "THE PASSED IN GENDER IS: " + convertedToEntity.getAthleteBioDetails().getGender() );
//System.out.println( "THE PASSED IN WEIGHT IS: " + convertedToEntity.getAthleteBioDetails().getWeight() );

// { "email": "mccarthy.richard@gmail.com","activityName": "cycling","duration": 120,"averageHeartRate": 145,"loggedDate": "15/08/2018", "athleteBioDetailsDto": { "age": 41, "gender": "male", "weight": 78.4 } }
/*AthleteBioDetails abd = new AthleteBioDetails( 41, "male", 78.4F );
TrainingSession ts = new TrainingSession( 
	"mccarthy.richard@gmail.com",
	"cycling",
	2.5F,
	120,
	LocalDate.now()
 );
ts.setAthleteBioDetails( abd );
*/


	TrainingSession savedSession = trainingSessionRepository.save( convertedToEntity );

System.out.println( "****** =========>>>> AFTER SAVING TO THE DATABASE!!! " );
System.out.println( savedSession.getAthleteBioDetails().getAge() );
System.out.println( "===============> " );

	TrainingSessionDto convertedToDto = mapper.convertToDto( savedSession );


	//****** PUT IN A CALL TO A NEW TRAINING-SESSION PUBLISHER HERE THAT WILL SEND THE DATA TO RABBITMQ... ******
	String returnValue = trainingSessionMessageProducer.publishNewTrainingSession( convertedToDto );
	System.out.println( "======> The PUBLISHER returned!... " + returnValue );

	return convertedToDto;

	}



	public void deleteTrainingSession( String email ) {

		try {

			trainingSessionRepository.deleteById( email );	

		} catch( IllegalArgumentException e ) {
			e.printStackTrace();
		}		
	}


	public TrainingSessionDto updateTrainingSession( TrainingSessionDto trainingSessionDto ) {

		TrainingSession convertedToEntity = mapper.convertToEntity( trainingSessionDto );
		TrainingSession updatedSession = trainingSessionRepository.save( convertedToEntity );
		TrainingSessionDto convertedToDto = mapper.convertToDto( updatedSession );
		
		return convertedToDto;
	}

	
}


