package model;

public class reservation {
	private int resId; //주문번호
	private String itemName; //상품 제목
	private int itemPrice; //예약 상태
	private String payStatus; //결제 상태
	private String resStatus; //예약 상태
	
	public reservation(int resId, String itemName, int itemPrice, String payStatus, String resStatus) {
		super();
		this.resId = resId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.payStatus = payStatus;
		this.resStatus = resStatus;
	}


	public int getResId() {
		return resId;
	}

	public void setResId(int resId) {
		this.resId = resId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getResStatus() {
		return resStatus;
	}

	public void setResStatus(String resStatus) {
		this.resStatus = resStatus;
	}
	
	
}
