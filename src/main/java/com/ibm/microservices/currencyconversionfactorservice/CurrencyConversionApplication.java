package com.ibm.microservices.currencyconversionfactorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@EnableDiscoveryClient
@SpringBootApplication
public class CurrencyConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSampler()
	{
		return Sampler.ALWAYS_SAMPLE;
	}

}
