package com.codedcraftworks.ami_prototype_one.cqrs_command_service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;



import org.springframework.boot.CommandLineRunner;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Prototype/learning app to set up a basic Microservices architecture 
 * using CQRS, a Message Broker and two databases and two
 * application microservices - Training Session and Fatigue Detector
 *
 * @author Richard McCarthy
 */

// @ComponentScan(basePackages= {"com.codedcraftworks.ami, com.fireduptech.ami"})

@SpringBootApplication
//@EnableAutoConfiguration
@EnableDiscoveryClient
public class App implements CommandLineRunner
{

    public static void main( String[] args )
    {
    	SpringApplication.run( App.class, args );
    }


    @Override
    public void run( String[] args ) throws Exception {

    	System.out.println( "******======> THE APP CLASS FROM THE COMMAND SERVICE IS IN THE HOUSE! ******<==========" );

    }


}
