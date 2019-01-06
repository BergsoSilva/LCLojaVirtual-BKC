package com.silva.lacoscomfitaApp;

import com.silva.lacoscomfitaApp.config.property.LacosApiProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(LacosApiProperty.class)
public class LacoscomfitaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(LacoscomfitaAppApplication.class, args);
	}
}
