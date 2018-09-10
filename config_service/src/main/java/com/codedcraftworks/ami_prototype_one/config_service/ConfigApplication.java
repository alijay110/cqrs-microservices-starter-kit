package com.codedcraftworks.ami_prototype_one.config_service;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.cloud.config.server.EnableConfigServer;


@SpringBootApplication
@EnableConfigServer
public class ConfigApplication {
	
	public static void main( String[] args )  throws Exception {
		new SpringApplicationBuilder( ConfigApplication.class ).run( args );
	}

}

