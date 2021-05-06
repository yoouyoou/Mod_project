package model;

public class Nation {
	private String nationId;
	private String name;
	private String continent;

	public Nation() { }  //기본 생성자

	public Nation(String nationId, String name, String continent) {
		this.nationId = nationId;
		this.name = name;
		this.continent = continent;
	}

	public void update(Nation updateNation) {
		this.name = updateNation.name;
		this.continent = updateNation.continent;
	}

	public String getNationId() {
		return nationId;
	}

	public void setNationId(String nationId) {
		this.nationId = nationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	//public static NationManager getInstance() {
	//	// TODO Auto-generated method stub
	//	return null;
	//}
}
