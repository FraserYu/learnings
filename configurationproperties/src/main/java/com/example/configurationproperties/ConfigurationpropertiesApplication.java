package com.example.configurationproperties;

import com.example.configurationproperties.properties.MailModuleProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@Slf4j
@EnableConfigurationProperties(MailModuleProperties.class)
public class ConfigurationpropertiesApplication {


	public static void main(String[] args) {
		SpringApplication.run(ConfigurationpropertiesApplication.class, args);
	}

}
