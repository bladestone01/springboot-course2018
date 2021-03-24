package org.boot.course.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.boot.course.bean.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class GameController {
   
	/**
	 * URL提取特定的参数
	 *   URL: /games/123?key1=val1&key2=val2
	 */
	@GetMapping("/games/{id}")
	@ResponseBody
	public String getGame(@PathVariable("id") Integer id,
			@RequestParam(value="key", required=false) String keyName) {
		String keyInfo = "";
		if (Objects.nonNull(keyName)) {
			keyInfo = ",key:" + keyName;
		}
		
		log.info("game info, id={},key:{}", id, keyName);
		return "Game Info:" + id + keyInfo; 
	}
	
	/**
	 * Form sumbit Request.
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	@PostMapping("/games")
	@ResponseBody
	public Map<String, String> login(@RequestParam("userName") String userName,
			@RequestParam("password") String password) {
		Map<String, String> resultMap = new HashMap<String, String>();
		 
		//用户登陆认证.
		resultMap.put("status", "ok");
		resultMap.put("user", userName);
		resultMap.put("pwd", password);
		
		log.info("ResultInfo:{}", resultMap);
		
		return resultMap;
	}
	
	/**
	 * Username/password in form submission.
	 *  结果以对象的形式接收form提交的数据。
	 *  
	 * @param userInfo
	 * @return
	 */
	@PostMapping("/games/form")
	@ResponseBody
	public Map<String, String> loginForm(UserInfo userInfo) {
		log.info("Incoming Params:{}", userInfo);
		
		Map<String, String> resultInfo = new HashMap<String, String>();
		resultInfo.put("name", userInfo.getName());
		resultInfo.put("password", userInfo.getPassword());
		
		return resultInfo;
	}
	
	
	@PostMapping("/games/json")
	@ResponseBody
	public Map<String, String> handleJson(@RequestBody UserInfo userInfo) {
		log.info("Incoming Params:{}", userInfo);
		
		Map<String, String> resultInfo = new HashMap<String, String>();
		
		resultInfo.put("status", "ok");
		resultInfo.put("name", userInfo.getName());
		resultInfo.put("age", String.valueOf(userInfo.getAge()));
		resultInfo.put("location", userInfo.getLocation());
		
		return resultInfo;
	}
}
