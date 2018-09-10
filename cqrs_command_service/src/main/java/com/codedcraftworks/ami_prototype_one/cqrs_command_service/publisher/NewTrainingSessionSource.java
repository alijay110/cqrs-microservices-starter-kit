package com.codedcraftworks.ami_prototype_one.cqrs_command_service.publisher;


import org.springframework.cloud.stream.annotation.Output;

import org.springframework.messaging.MessageChannel;



public interface NewTrainingSessionSource {


	@Output( "newTrainingSessionsChannel" )
	MessageChannel newTrainingSessions();


}
