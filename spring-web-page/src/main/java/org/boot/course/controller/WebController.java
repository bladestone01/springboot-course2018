package org.boot.course.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.boot.course.bean.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

/**
 *  展示Restful 接口使用 @Controller的用法 
 *
 */
@Controller
@Slf4j
public class WebController {
    private Map<Long, Order> dataMap = new HashMap<Long, Order>();
    private Random rand = new Random();
	
    
    /**
     * 查询操作
     * 
     * @return
     */
	@RequestMapping(value="/orders", method=RequestMethod.GET)
	//@ResponseBody
	public List<Order> getOrders() {
		
		List<Order> orders = dataMap.values().stream().collect(Collectors.toList());
		
		log.info("Query Orders:{}", orders);
		
		return orders;
	}
	
	
	/**
	 * 新建订单操作
	 * 
	 * @param name
	 * @param number
	 * @return
	 */
	@PostMapping("/orders")
	@ResponseBody
	public Order createOrder(@RequestParam(name="name", required=true, defaultValue="Alice1") String name, @RequestParam("number") Integer number) {
		Long id = rand.nextLong();
		Order order = Order.builder().id(id).name(name).count(number).build();
		
		dataMap.put(id, order);
		
		log.info("Created Order:{}", order);
		
		return order;
	}
	
	/**
	 * 更新数据
	 */
	@PutMapping("/orders/{id}")
	@ResponseBody
	public Order updateOrder(@PathVariable("id") Long id, @RequestParam("name") String name, @RequestParam("number") Integer number) {
		Order order = dataMap.containsKey(id) ? dataMap.get(id) : new Order();
		
		order.setCount(number);
		order.setName(name);
		order.setId(id);
		
		if (!dataMap.containsKey(id)) {
			dataMap.put(id, order);
		}
		
		log.info("Update Order:{}", order);
		
		return order;
	}
	
	/**
	 * 删除动作
	 */
	@DeleteMapping("/orders/{id}")
	@ResponseBody
	public void deleteOrder(@PathVariable("id") Long id) {
		Order order = dataMap.get(id);
		
		dataMap.remove(id);
		
		log.info("Delete Order:{}", order);
	}
}
