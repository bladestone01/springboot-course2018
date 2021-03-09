package org.boot.course;

import org.boot.course.config.AppConfig;
import org.boot.course.processor.OrderProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

 
public class SpringAppBuyerAnnotationApplication {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		OrderProcessor orderProcessor = context.getBean("orderProcessor", OrderProcessor.class);
		orderProcessor.process(2, 2l);
	}

}
