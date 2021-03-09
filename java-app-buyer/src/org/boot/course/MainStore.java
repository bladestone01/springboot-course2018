package org.boot.course;

import java.util.Date;

import org.boot.course.bean.Buyer;
import org.boot.course.bean.ProductItem;
import org.boot.course.processor.OrderProcessor;

public class MainStore {

	public static void main(String[] args) {
		Buyer buyer = new Buyer();
		buyer.setId(1l);
		buyer.setAge(23);
		buyer.setLevel(1);
		buyer.setLocation("beijing");
		buyer.setName("jack");
		
		//初始化商品信息
        ProductItem productItem = new ProductItem();
        productItem.setId(11l);
        productItem.setName("面包");
        productItem.setCategory("food");
        productItem.setCreatedTime(new Date());
        productItem.setPrice(12.0f);
        productItem.setVendor("奇怪面包店");
		
        
        //创建订单处理器
        OrderProcessor orderProcessor = new OrderProcessor();
        
        //jack 买了2个面包，batchId： 2
        orderProcessor.process(buyer, productItem, 2, 2l);
	}

}
