package com.codedcraftworks.ami_prototype_one.cqrs_command_service.utils;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.codedcraftworks.ami_prototype_one.cqrs_command_service.domain.AthleteBioDetails;

import com.codedcraftworks.ami_prototype_one.cqrs_command_service.domain.TrainingSession;
import com.codedcraftworks.ami_prototype_one.cqrs_command_service.dto.TrainingSessionDto;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;


@Component
public final class DtoEntityMappingConversions {


	@Autowired
	private ModelMapper modelMapper;

	

	public TrainingSessionDto convertToDto( TrainingSession trainingSession ) {

		// Entity is more complex than DTO so needs to be flattened to map correctly

		PropertyMap <TrainingSession, TrainingSessionDto> trainingSessionDtoMap = new PropertyMap<TrainingSession, TrainingSessionDto>() {
			protected void configure() {
				map().setAge( source.getAthleteBioDetails().getAge() );
				map().setGender( source.getAthleteBioDetails().getGender() );
				map().setWeight( source.getAthleteBioDetails().getWeight() );
			}
		};

		// NOTE: ***FIX FROM STACKOVERFLOW - TRIES TO RESET PROPERTY MAP ON EACH INCOMMING REQUEST SO EVERY SUBSEQUENT REQUEST FAILS DUE TO ERROR
		//						SAYING MAPPING ALREADY EXISTS - THE LINES BELOW ARE THE WORKAROUND SOLUTION... ***
		TypeMap<TrainingSession, TrainingSessionDto> typeMap = modelMapper.getTypeMap( TrainingSession.class, TrainingSessionDto.class );
		if ( typeMap == null ) {
			modelMapper.addMappings( trainingSessionDtoMap );
		}

		return modelMapper.map( trainingSession, TrainingSessionDto.class );
	}


	public TrainingSession convertToEntity( TrainingSessionDto trainingSessionDto ) {

		
		// DTO is currently in a Flattened Structure and need to Project it into more complext Domain Model Structure...
	
		PropertyMap <TrainingSessionDto, TrainingSession> trainingSessionMap = new PropertyMap<TrainingSessionDto, TrainingSession>() {
			protected void configure() {
				map().getAthleteBioDetails().setAge( source.getAge() );
				map().getAthleteBioDetails().setGender( source.getGender() );
				map().getAthleteBioDetails().setWeight( source.getWeight() );
			}
		};

		TypeMap<TrainingSessionDto, TrainingSession> typeMap = modelMapper.getTypeMap( TrainingSessionDto.class, TrainingSession.class );
		if ( typeMap == null ) {
			modelMapper.addMappings( trainingSessionMap );
		}

		return modelMapper.map( trainingSessionDto, TrainingSession.class );
	}


}