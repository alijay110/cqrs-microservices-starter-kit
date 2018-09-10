package com.codedcraftworks.ami_prototype_one.cqrs_query_service.consumer_service;


import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.codedcraftworks.ami_prototype_one.cqrs_query_service.domain.TrainingSession;
import com.codedcraftworks.ami_prototype_one.cqrs_query_service.dto.TrainingSessionDto;
import com.codedcraftworks.ami_prototype_one.cqrs_query_service.repository.TrainingSessionConsumerRepository;

import org.modelmapper.ModelMapper;




@Service
public class TrainingSessionConsumerServiceImpl implements TrainingSessionConsumerService {


	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private TrainingSessionConsumerRepository trainingSessionConsumerRepository;


	public TrainingSession insertIntoStorage( TrainingSessionDto trainingSessionDtoMessage ) {

		TrainingSession savedTrainingSession = trainingSessionConsumerRepository.insert( convertDtoToEntity( trainingSessionDtoMessage ) );
		return savedTrainingSession;

	}


	private TrainingSession convertDtoToEntity( TrainingSessionDto trainingSessionDtoMesage ) {

		return modelMapper.map( trainingSessionDtoMesage, TrainingSession.class );
	}


}

	
	