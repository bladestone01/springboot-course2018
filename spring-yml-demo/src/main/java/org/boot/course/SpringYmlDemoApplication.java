package org.boot.course;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
public class SpringYmlDemoApplication {
    @Value("${spring.messages.basename")
    private String baseNames;
    
	public static void main(String[] args) {
		SpringApplication.run(SpringYmlDemoApplication.class, args);
	}

	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		
		messageSource.setBasename(baseNames);
		
		return messageSource;
	}
}
