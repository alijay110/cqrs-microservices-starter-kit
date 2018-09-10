package com.codedcraftworks.ami_prototype_one.cqrs_query_service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.boot.CommandLineRunner;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * This is the QUERY service part of the CQRS pattern being used
 * in the Micoservices prototype/learning app.
 *
 * @author Richard McCarthy
 */

@SpringBootApplication
//@EnableAutoConfiguration
@EnableDiscoveryClient
public class App implements CommandLineRunner {

	public static void main( String[] args ) {
		SpringApplication.run( App.class, args );
	}

	@Override
	public void run( String[] args ) throws Exception {

		System.out.println( "****** ======> CQRS QUERY SERVICE IN THE HOUSE! <====== ******" );

	}

}


