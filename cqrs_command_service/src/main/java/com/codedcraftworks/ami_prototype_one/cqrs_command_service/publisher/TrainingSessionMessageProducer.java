package com.codedcraftworks.ami_prototype_one.cqrs_command_service.publisher;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.integration.support.MessageBuilder;

import org.springframework.stereotype.Service;

import com.codedcraftworks.ami_prototype_one.cqrs_command_service.dto.TrainingSessionDto;


@Service
public class TrainingSessionMessageProducer {


	@Autowired
	private NewTrainingSessionSource newTrainingSessionSource;

/*
	public String publishNewTrainingSession() {

		String testPayload = "Richard-Payload-Publish-TEST";
		newTrainingSessionSource.newTrainingSessions().send( MessageBuilder.withPayload( testPayload ).build() );

		return "======> The New Training Session has been Published! <======";
	}
*/


	public String publishNewTrainingSession( TrainingSessionDto trainingSessionDto ) {


		newTrainingSessionSource.newTrainingSessions().send( MessageBuilder.withPayload( trainingSessionDto ).build() );

		return "======> The New Training Session has been Published! <======";
	}


}