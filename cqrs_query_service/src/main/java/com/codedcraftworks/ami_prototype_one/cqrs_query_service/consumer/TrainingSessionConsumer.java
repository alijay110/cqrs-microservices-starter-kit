package com.codedcraftworks.ami_prototype_one.cqrs_query_service.consumer;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import org.springframework.cloud.stream.messaging.Sink;

import org.springframework.beans.factory.annotation.Autowired;

import com.codedcraftworks.ami_prototype_one.cqrs_query_service.domain.TrainingSession;
import com.codedcraftworks.ami_prototype_one.cqrs_query_service.dto.TrainingSessionDto;
import com.codedcraftworks.ami_prototype_one.cqrs_query_service.repository.TrainingSessionRepository;


import com.codedcraftworks.ami_prototype_one.cqrs_query_service.consumer_service.TrainingSessionConsumerService;

import org.modelmapper.ModelMapper;


@EnableBinding( Sink.class )
public class TrainingSessionConsumer {


	@Autowired
	private TrainingSessionRepository trainingSessionRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private TrainingSessionConsumerService trainingSessionConsumerService;


	@StreamListener( target = Sink.INPUT )
	public void processTrainingSessionMessage( TrainingSessionDto trainingSessionMessage ) {

		System.out.println( "******======> The QUERY Service has received the message from RabbitMQ! <======******" + trainingSessionMessage );

		TrainingSession trainingSession = trainingSessionConsumerService.insertIntoStorage( trainingSessionMessage );

	}




// {"email":"mccarthy.richard@gmail.com","activityName":"cycling","duration":95.0,"averageHeartRate":145,"loggedDate":"15/08/2018","age":41,"gender":"male","weight":78.4}


/*
*** NOTE ***
MIGHT NEED SOME TYPE OF OBJECT MAPPING ON THIS SIDE SO THAT THE OBJECTS THAT GET PUBLISHED ARE MAPPED TO THE DOCUMENT HERE SO CAN 
SEND TO MONGODB AS NEEDED... ???
*/


}

