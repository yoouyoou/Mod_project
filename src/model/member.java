package model;

public class member {
	private String userId;
	private String password;
	private String name;
	private String email;
	private String tel;
	private String birth;
	private String passport;
	
	public member() {}

	public member(String userId, String password, String name, String email, String tel, String birth,
			String passport) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.birth = birth;
		this.passport = passport;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	};
	
	//비밀번호 검사
	public boolean matchPassword(String password) {
		if(password == null)
			return false;
		return this.password.equals(password);
	}
	
}
