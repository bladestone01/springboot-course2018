package org.boot.course.processor;

import java.util.Date;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.boot.course.bean.Buyer;
import org.boot.course.bean.OrderRecord;
import org.boot.course.bean.ProductItem;

/**
 * 订单处理逻辑
 * 
 * @author chenjunfeng
 *
 */
public class OrderProcessor {
	private Random rand = new Random();

	private Buyer buyer;

	private ProductItem productItem;

	public OrderProcessor() {

	}

	public OrderProcessor(Buyer buyer, ProductItem productItem) {
		this.buyer = buyer;
		this.productItem = productItem;
	}

	@PostConstruct
	public void init() {
		initBuyer(this.buyer);
		initProductItem(this.productItem);
	}

	private void initBuyer(Buyer buyer) {
		buyer.setId(1l);
		buyer.setAge(23);
		buyer.setLevel(1);
		buyer.setLocation("beijing");
		buyer.setName("jack");
	}

	private void initProductItem(ProductItem productItem) {
		productItem.setId(11l);
		productItem.setName("面包");
		productItem.setCategory("food");
		productItem.setCreatedTime(new Date());
		productItem.setPrice(12.0f);
		productItem.setVendor("奇怪面包店");
	}

//	/**
//	 * 创建订单记录
//	 * 
//	 * @param buyer
//	 * @param productItem
//	 * @param count
//	 * @param batchId
//	 */
//	public void process(Buyer buyer, ProductItem productItem, int count, Long batchId) {
//		OrderRecord orderRecord = new OrderRecord();
//
//		orderRecord.setId((long) rand.nextInt(10000));
//		orderRecord.setBatchId(batchId);
//		orderRecord.setBuyerId(buyer.getId());
//		orderRecord.setProductItemId(productItem.getId());
//		orderRecord.setCount(count);
//		orderRecord.setCreatedTime(new Date());
//		orderRecord.setPrice(productItem.getPrice());
//		orderRecord.setUpdatedTime(new Date());
//
//		// 更新用户的金额
//		float itemFee = orderRecord.getFee();
//		buyer.updateTotalFee(itemFee);
//
//		System.out.println(
//				"Order Record Info:" + ReflectionToStringBuilder.toString(orderRecord, ToStringStyle.MULTI_LINE_STYLE));
//		System.out.println("Buyer Info:" + ReflectionToStringBuilder.toString(buyer, ToStringStyle.MULTI_LINE_STYLE));
//	}
	
	public void process(int count, Long batchId) {
		OrderRecord orderRecord = new OrderRecord();

		orderRecord.setId((long) rand.nextInt(10000));
		orderRecord.setBatchId(batchId);
		orderRecord.setBuyerId(buyer.getId());
		orderRecord.setProductItemId(productItem.getId());
		orderRecord.setCount(count);
		orderRecord.setCreatedTime(new Date());
		orderRecord.setPrice(productItem.getPrice());
		orderRecord.setUpdatedTime(new Date());

		// 更新用户的金额
		float itemFee = orderRecord.getFee();
		buyer.updateTotalFee(itemFee);

		System.out.println(
				"Order Record Info:" + ReflectionToStringBuilder.toString(orderRecord, ToStringStyle.MULTI_LINE_STYLE));
		System.out.println("Buyer Info:" + ReflectionToStringBuilder.toString(buyer, ToStringStyle.MULTI_LINE_STYLE));
	}
}
