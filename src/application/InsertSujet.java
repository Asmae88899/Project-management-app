package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InsertSujet {
	
	@FXML
    private JFXTextField nom;

    @FXML
    private JFXTextField document;
    @FXML
    private JFXTextArea description;
	@FXML
	Label idgroupl;
	
	
	
	@FXML
	private AnchorPane mainPane;
	
	
	
	public void insertData(ActionEvent e) throws IOException{
        String nomSujet = nom.getText();
        String DocSujet = document.getText();
        String DesSujet = description.getText();
        SujetModifiable pr=new SujetModifiable();
	
		
		pr.setNom_s(nomSujet); 
		pr.setDocument_s(DocSujet);
		pr.setDescription(DesSujet); 
	
		
		int status=DBSujetsModifiable.save(pr);

		
		
		/*	if(status>0) {
			
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("Data Insert");
			alert.setHeaderText("Information Dialog");
			alert.setContentText("Record saved successsfully!");
			
			alert.showAndWait();
			
			
			
			
		}else {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Data Insert");
			alert.setHeaderText("ERROR Dialog");
			alert.setContentText("Unable to save record");
			
			alert.showAndWait();
			
			}
*/


ObservableList<SujetModifiable>data=FXCollections.observableArrayList();

try {
	 
	 String sql= "SELECT `idsujet`, `nom`, `document`, `description` FROM `sujet` WHERE nom=?"; 
	 Connection con=AdminsDB.getConnection();
	 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
	 preparedStatement.setString(1,nom.getText());
	 
	 
     ResultSet rs=preparedStatement.executeQuery();
	 
	 while(rs.next()){
		 
		 
		 data.add(new SujetModifiable(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
		 
	 }
	 con.close();
}catch (SQLException e1) {
	e1.printStackTrace();
}

for (SujetModifiable gr1 : data )
{
	Global2.p=gr1.getIdsujet();
	
	
	
	
}
		
	}
	
	
/*	public void getGroupId(ActionEvent e) throws IOException, ParseException{
		
		String sid= nom.getText();
	
		
		Group re=DBGroup.getGroupId(sid);
				
		Global2.c=re.getIdgroup();
		System.out.print(Global2.c);
		datereunion.setText(re.getIdgroup());
	
		
		
		}
		*/
		
		
		public void view(ActionEvent e) throws IOException{
			
			
			
			FXMLLoader Loader= new FXMLLoader(getClass().getResource("GroupPanel.fxml"));
			Parent root = Loader.load();
			
			
			Scene scene = new Scene(root);
			Stage window= (Stage)((Node)e.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		
			
			
		}
	

	
	
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}