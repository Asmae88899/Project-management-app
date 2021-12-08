package application;

import javafx.beans.property.SimpleStringProperty;

public class Task {
	private int idgroup;
	private SimpleStringProperty task1;
	private SimpleStringProperty task2;
	private SimpleStringProperty task3;
	private SimpleStringProperty task4;
	private SimpleStringProperty task5;
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Task(int idgroup, String task1, String task2, String task3,
			String task4, String task5) {
		super();
		this.idgroup = idgroup;
		this.task1 = new SimpleStringProperty(task1);
		this.task2 = new SimpleStringProperty(task2);
		this.task3 = new SimpleStringProperty(task3);
		this.task4 = new SimpleStringProperty(task4);
		this.task5 = new SimpleStringProperty(task5);
	}
	public Task(String task1, String task2, String task3,
			String task4, String task5) {
		super();
		
		this.task1 = new SimpleStringProperty(task1);
		this.task2 = new SimpleStringProperty(task2);
		this.task3 = new SimpleStringProperty(task3);
		this.task4 = new SimpleStringProperty(task4);
		this.task5 = new SimpleStringProperty(task5);
	}
	
	
	public int getIdgroup() {
		return idgroup;
	}
	public void setIdgroup(int idgroup) {
		this.idgroup = idgroup;
	}
	public String getTask1() {
		return task1.get();
	}
	public void setTask1(String task1) {
		this.task1 =new SimpleStringProperty(task1);
	}
	public String getTask2() {
		return task2.get();
	}
	public void setTask2(String task2) {
		this.task2 =new SimpleStringProperty(task2);
	}
	public String getTask3() {
		return task3.get();
	}
	public void setTask3(String task3) {
		this.task3 =new SimpleStringProperty(task3);
	}
	public String getTask4() {
		return task4.get();
	}
	public void setTask4(String task4) {
		this.task4 =new SimpleStringProperty(task4);
	}
	public String getTask5() {
		return task5.get();
	}
	public void setTask5(String task5) {
		this.task5 =new SimpleStringProperty(task5);
	}
	
	

}
