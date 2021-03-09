package org.boot.course.controller;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.boot.course.config.SystemConfig;
import org.boot.course.config.SystemConfigV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    private SystemConfig systemConfig;
    
    @Autowired
    private SystemConfigV2 systemConfigV2;
    
    
	@GetMapping("/config")
	public String getConfig() {
		
		return ReflectionToStringBuilder.toString(systemConfig, ToStringStyle.JSON_STYLE);
	}
	
	@GetMapping("/config2")
	public String getConfig2() {
		
		return ReflectionToStringBuilder.toString(systemConfigV2, ToStringStyle.JSON_STYLE);
	}
}
