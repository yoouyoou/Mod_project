package model;

import java.util.Date;

public class guide {
	private String guideId;
	private String guidePwd;
	private String name;
	private String tel;
	private int peride;
	
	public guide(String guideId, String guidePwd, String name, String tel, int peride) {
		super();
		this.guideId = guideId;
		this.guidePwd = guidePwd;
		this.name = name;
		this.tel = tel;
		this.peride = peride;
	}

	public String getGuideId() {
		return guideId;
	}

	public void setGuideId(String guideId) {
		this.guideId = guideId;
	}

	public String getGuidePwd() {
		return guidePwd;
	}

	public void setGuidePwd(String guidePwd) {
		this.guidePwd = guidePwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getPeride() {
		return peride;
	}

	public void setPeride(int peride) {
		this.peride = peride;
	}
	
	//비밀번호 검사
	public boolean matchPassword(String password) {
		if(password == null)
			return false;
		return this.guidePwd.equals(password);
	}

}
