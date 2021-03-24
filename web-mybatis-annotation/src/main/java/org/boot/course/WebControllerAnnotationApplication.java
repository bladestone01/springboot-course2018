package org.boot.course;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan("org.boot.course.dao.mapper")
@SpringBootApplication
public class WebControllerAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebControllerAnnotationApplication.class, args);
	}

}
