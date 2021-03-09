package org.boot.course;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CMDOptionListener implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Command Option:" + args);
		
		for (String param : args) {
			System.out.println("Incoming Param:" + param);
			
			String[] dataKey = param.split("=");
			
			System.out.println("key:" + dataKey[0] + ", val:" + dataKey[1]);
		}
	}

}
