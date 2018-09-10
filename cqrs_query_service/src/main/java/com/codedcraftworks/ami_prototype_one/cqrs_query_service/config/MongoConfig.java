package com.codedcraftworks.ami_prototype_one.cqrs_query_service.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

import org.springframework.data.mongodb.config.MongoConfigurationSupport;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;



@Configuration
@EnableMongoRepositories( basePackages = "com.codedcraftworks.ami_prototype_one.cqrs_query_service.repository" )
public class MongoConfig extends AbstractMongoConfiguration {


	@Override
	protected String getDatabaseName() {
		return "ami_prototype_read";
	}

	@Override
	public MongoClient mongoClient() {
		return new MongoClient( "127.0.0.1", 27017 );
	}

	@Override
	public String getMappingBasePackage() {
		return "com.codedcraftworks.ami_prototype_one.cqrs_query_service.domain";
	}


}