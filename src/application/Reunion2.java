package application;

public class Reunion2 {
	private int idreunion2;
	private String date;
	private int idencadrant;
	private String group;
	private int idgroup;
	
	public Reunion2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reunion2(String date, String group, int idgroup, int idencadrant ) {
		super();
		this.date = date;
		this.group = group;
		this.idgroup=idgroup;
		this.idencadrant=idencadrant;
		
	}
	public Reunion2(int idreunion2,String date, String group, int idgroup, int idencadrant ) {
		super();
		this.idreunion2=idreunion2;
		this.date = date;
		this.group = group;
		this.idgroup=idgroup;
		this.idencadrant=idencadrant;
		
	}
	public Reunion2(String date, String group ) {
		super();
	
		this.date = date;
		this.group = group;
		
		
	}
	
	public int getIdgroup() {
		return idgroup;
	}
	public void setIdgroup(int idgroup) {
		this.idgroup = idgroup;
	}
	public int getIdreunion2() {
		return idreunion2;
	}
	public void setIdreunion2(int idreunion2) {
		this.idreunion2 = idreunion2;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getIdencadrant() {
		return idencadrant;
	}
	public void setIdencadrant(int idencadrant) {
		this.idencadrant = idencadrant;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
	
	

}
