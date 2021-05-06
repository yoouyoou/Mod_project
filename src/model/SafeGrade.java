package model;

public class SafeGrade {
	private String nationId;
	private String nation;
	private String disease;
	private String naturalAccident;
	private String terror;
	private String war;
	
	public SafeGrade(String nationId, String nation, String disease, String naturalAccident, String terror,
			String war) {
		super();
		this.nationId = nationId;
		this.nation = nation;
		this.disease = disease;
		this.naturalAccident = naturalAccident;
		this.terror = terror;
		this.war = war;
	}

	public String getNationId() {
		return nationId;
	}

	public void setNationId(String nationId) {
		this.nationId = nationId;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getNaturalAccident() {
		return naturalAccident;
	}

	public void setNaturalAccident(String naturalAccident) {
		this.naturalAccident = naturalAccident;
	}

	public String getTerror() {
		return terror;
	}

	public void setTerror(String terror) {
		this.terror = terror;
	}

	public String getWar() {
		return war;
	}

	public void setWar(String war) {
		this.war = war;
	}
	
}
