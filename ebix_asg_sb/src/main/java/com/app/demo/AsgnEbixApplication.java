package com.app.demo;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
//(exclude = {DataSourceAutoConfiguration.class })
@SpringBootConfiguration
@EnableAutoConfiguration
public class AsgnEbixApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsgnEbixApplication.class, args);
	}
	@Bean
    public  ModelMapper mapper() {
        ModelMapper  modelMapper= new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
        
    }

}

