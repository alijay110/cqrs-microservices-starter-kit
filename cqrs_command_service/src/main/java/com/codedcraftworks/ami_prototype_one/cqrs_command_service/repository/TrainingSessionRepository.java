package com.codedcraftworks.ami_prototype_one.cqrs_command_service.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.codedcraftworks.ami_prototype_one.cqrs_command_service.domain.TrainingSession;
import com.codedcraftworks.ami_prototype_one.cqrs_command_service.domain.AthleteBioDetails;


public interface TrainingSessionRepository extends JpaRepository<TrainingSession, String> {}
