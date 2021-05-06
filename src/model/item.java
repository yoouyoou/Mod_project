package model;

import java.util.Date;

public class item {
	private int itemId;
	private String name;
	private int price;
	private Date departTime;
	private Date arrTime;
	private String guideId;
	private String category;
	
	public item(int itemId, String name, int price, Date departTime, Date arrTime, String guideId, String category) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.price = price;
		this.departTime = departTime;
		this.arrTime = arrTime;
		this.guideId = guideId;
		this.category = category;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getDepartTime() {
		return departTime;
	}

	public void setDepartTime(Date departTime) {
		this.departTime = departTime;
	}

	public Date getArrTime() {
		return arrTime;
	}

	public void setArrTime(Date arrTime) {
		this.arrTime = arrTime;
	}

	public String getGuideId() {
		return guideId;
	}

	public void setGuideId(String guideId) {
		this.guideId = guideId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	
}
