package com.codedcraftworks.ami_prototype_one.core;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import org.springframework.boot.CommandLineRunner;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * Prototype/learning app to set up a basic Microservices architecture 
 * using CQRS, a Message Broker and two databases and two
 * application microservices - Training Session and Fatigue Detector
 *
 * @author Richard McCarthy
 */

// @ComponentScan(basePackages= {"com.codedcraftworks.ami, com.fireduptech.ami"})

@SpringBootApplication
public class amiPrototypeOneApp implements CommandLineRunner
{

    public static void main( String[] args )
    {
    	SpringApplication.run( amiPrototypeOneApp.class, args );
    }


    @Override
    public void run( String[] args ) throws Exception {

    	System.out.println( "AMI Prototype One is operational..." );

    }


}
