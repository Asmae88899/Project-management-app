package application;

import javafx.beans.property.SimpleStringProperty;

public class GroupAffichage {
    private SimpleStringProperty group;

	public GroupAffichage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GroupAffichage(String group) {
		super();
		this.group = new SimpleStringProperty(group);
	}

	public String getGroup() {
		return group.get();
	}

	public void setGroup(String group) {
		this.group = new SimpleStringProperty(group);
	}
    
    
    
    

}
