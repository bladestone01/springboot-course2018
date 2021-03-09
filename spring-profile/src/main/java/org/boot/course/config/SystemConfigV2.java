package org.boot.course.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Data
@Configuration
@PropertySource(value="config/systemconfig.properties")
public class SystemConfigV2 {
	@Value("${sys.config.myname}")
	private String myName;
	
	@Value("${sys.config.number}")
    private int number;
	
	
	//setter/getter
}
