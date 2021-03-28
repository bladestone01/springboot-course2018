package org.boot.course;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.boot.course.dao.mapper")
public class MybatisXmlEduApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisXmlEduApplication.class, args);
	}

}
