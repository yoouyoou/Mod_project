package model;

import java.util.Date;

public class schedule {
	private int scheId;
	private String name;
	private Date time;
	private String location;
	private String description;
	private int itemId;
	
	
	
	public schedule(int scheId, String name, Date time, String location, String description, int itemId) {
		super();
		this.scheId = scheId;
		this.name = name;
		this.time = time;
		this.location = location;
		this.description = description;
		this.itemId = itemId;
	}

	public int getScheId() {
		return scheId;
	}

	public void setScheId(int scheId) {
		this.scheId = scheId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getItemId() {
		return itemId;
	}

	public void setitemId(int itemId) {
		this.itemId = itemId;
	}
	
	
	
}
