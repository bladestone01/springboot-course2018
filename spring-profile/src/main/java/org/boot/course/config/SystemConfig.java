package org.boot.course.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class SystemConfig {
	@Value("${sys.config.myname}")
	private String myName;
	
	@Value("${sys.config.number}")
    private int number;
	
	
	//setter/getter
}
