package org.boot.course.bean;

import java.util.Date;

/**
 * 用户购买的商品
 * 
 * @author chenjunfeng
 *
 */
public class ProductItem {
	 //商品唯一标识ID
    private Long id;

    //商品类别
    private String category;

    //商品名称
    private String name;

    //商品提供商
    private String vendor;

    //商品价格
    private float price;

    //商品上架时间
    private Date createdTime;
    
    public ProductItem() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
    
    
}
