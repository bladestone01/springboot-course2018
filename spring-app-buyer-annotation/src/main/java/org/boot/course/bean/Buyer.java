package org.boot.course.bean;

/**
 * 购买者
 * 
 * @author chenjunfeng
 *
 */
public class Buyer {
	// 用户ID
	private Long id;

	// 用户名称
	private String name;

	// 年龄
	private int age;

	// 性别
	private int sex;

	// 住址
	private String location;

	// 是否为会员
	private boolean isPlus;

	// 会员级别
	private int level;

	// 消费累计金额
	private float totalFee;

	public Buyer() {

	}

	/**
	 * 计算用户消费总金额
	 * 
	 * @param newFee
	 * @return
	 */
	public float updateTotalFee(float newFee) {
		this.totalFee = this.totalFee + newFee;

		return totalFee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isPlus() {
		return isPlus;
	}

	public void setPlus(boolean isPlus) {
		this.isPlus = isPlus;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public float getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(float totalFee) {
		this.totalFee = totalFee;
	}

}
