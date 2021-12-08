package application;

public class Soutenance {
	
	private int idsoutenance;
	private int numsalle;
	private String datesou;
	public Soutenance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Soutenance(int idsoutenance, int numsalle, String datesou) {
		super();
		this.idsoutenance = idsoutenance;
		this.numsalle = numsalle;
		this.datesou = datesou;
	}
	public int getIdsoutenance() {
		return idsoutenance;
	}
	public void setIdsoutenance(int idsoutenance) {
		this.idsoutenance = idsoutenance;
	}
	public int getNumsalle() {
		return numsalle;
	}
	public void setNumsalle(int numsalle) {
		this.numsalle = numsalle;
	}
	public String getDatesou() {
		return datesou;
	}
	public void setDatesou(String datesou) {
		this.datesou = datesou;
	}
	
	

}
