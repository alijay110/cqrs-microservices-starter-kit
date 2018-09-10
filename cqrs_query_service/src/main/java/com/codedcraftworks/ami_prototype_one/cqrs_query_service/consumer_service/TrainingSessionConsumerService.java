package com.codedcraftworks.ami_prototype_one.cqrs_query_service.consumer_service;

import com.codedcraftworks.ami_prototype_one.cqrs_query_service.dto.TrainingSessionDto;
import com.codedcraftworks.ami_prototype_one.cqrs_query_service.domain.TrainingSession;


public interface TrainingSessionConsumerService {


	public abstract TrainingSession insertIntoStorage( TrainingSessionDto trainingSessionDtoMessage );




}