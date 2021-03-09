package org.boot.course.config;

import org.boot.course.bean.Buyer;
import org.boot.course.bean.ProductItem;
import org.boot.course.processor.OrderProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public Buyer buyer() {
		return new Buyer();
	}
	
	@Bean
	public ProductItem productItem() {
		return new ProductItem();
	}
	
	@Bean
	public OrderProcessor orderProcessor(Buyer buyer, ProductItem productItem) {
		
		return new OrderProcessor(buyer, productItem);
	}
}
