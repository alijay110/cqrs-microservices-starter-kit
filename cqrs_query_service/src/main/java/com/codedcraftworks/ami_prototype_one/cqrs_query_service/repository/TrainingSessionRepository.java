package com.codedcraftworks.ami_prototype_one.cqrs_query_service.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.codedcraftworks.ami_prototype_one.cqrs_query_service.domain.TrainingSession;



public interface TrainingSessionRepository extends MongoRepository<TrainingSession, String> {


	/**
	 * This method will retrieve a List of Training Sessions based on the activity name.
	 *
	 * @param activityName - The name of the activity searching for.
	 *
	 * @return - A List of {@link TrainingSession} instances.
	 */	 
	@Query( "{ 'activityName' : ?0 }" )
	List<TrainingSession> findTrainingSessionsByActivityName( String activityName );


	/**
	 * This method will retrieve a List of Training Sessions based that are
	 * greater than or equal the age provided.
	 *
	 * @param age - The age searching for.
	 *
	 * @return - A List of {@link TrainingSession} instances.
	 */
	@Query( "{ 'age' : { $gte : ?0 } }" )
	List<TrainingSession> findTrainingSessionsByAge( int age );


}

