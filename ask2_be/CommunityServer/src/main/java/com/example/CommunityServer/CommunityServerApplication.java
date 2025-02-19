package com.example.CommunityServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CommunityServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommunityServerApplication.class, args);
	}

}
