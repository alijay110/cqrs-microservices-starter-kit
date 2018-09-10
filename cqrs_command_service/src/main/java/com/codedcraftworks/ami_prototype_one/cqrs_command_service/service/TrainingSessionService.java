package com.codedcraftworks.ami_prototype_one.cqrs_command_service.service;


import com.codedcraftworks.ami_prototype_one.cqrs_command_service.dto.TrainingSessionDto;

public interface TrainingSessionService {

	TrainingSessionDto saveTrainingSession( TrainingSessionDto trainingSession );

	void deleteTrainingSession( String email );

	TrainingSessionDto updateTrainingSession( TrainingSessionDto trainingSession );

}
