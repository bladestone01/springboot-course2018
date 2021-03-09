package org.boot.course.bean;

import java.util.Date;

/**
 * 订单信息
 *   记录商品、人、金额和时间
 *   
 * @author chenjunfeng
 *
 */
public class OrderRecord {
	// 记录唯一标识ID
    private Long id;

    // 批次,一次购物
    private Long batchId;

    // 商品唯一标识ID
    private Long productItemId;

    // 商品价格
    private float price;

    // 购买数量
    private int count;

    // 购买者唯一标识
    private Long buyerId;

    // 购买时间
    private Date createdTime;

    // 记录更新时间
    private Date updatedTime;
    
    //构造方法
    public OrderRecord() {
    	
    }
    
    /**
     * 获取当前订单的金额
     * 
     * @return
     */
    public float getFee() {
    	return this.count * this.price;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBatchId() {
		return batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

	public Long getProductItemId() {
		return productItemId;
	}

	public void setProductItemId(Long productItemId) {
		this.productItemId = productItemId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
}
