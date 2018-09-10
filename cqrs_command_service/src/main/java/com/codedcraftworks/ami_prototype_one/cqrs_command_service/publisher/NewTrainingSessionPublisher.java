package com.codedcraftworks.ami_prototype_one.cqrs_command_service.publisher;


import org.springframework.cloud.stream.annotation.EnableBinding;


@EnableBinding( NewTrainingSessionSource.class )
public class NewTrainingSessionPublisher {}

