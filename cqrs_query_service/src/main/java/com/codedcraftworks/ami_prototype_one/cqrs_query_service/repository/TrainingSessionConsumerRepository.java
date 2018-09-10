package com.codedcraftworks.ami_prototype_one.cqrs_query_service.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.codedcraftworks.ami_prototype_one.cqrs_query_service.domain.TrainingSession;


public interface TrainingSessionConsumerRepository extends MongoRepository<TrainingSession, String> {


}

