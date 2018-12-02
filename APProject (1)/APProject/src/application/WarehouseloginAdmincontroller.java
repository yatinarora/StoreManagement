
package application;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import java.io.Serializable;
import java.lang.*;
import java.math.*;

public class WarehouseloginAdmincontroller {
	
	@FXML private TextField tf1;
	@FXML private TextField tf2;
	 static warehouse_administrator w=null;
	
	public void exit(ActionEvent event)
	{
		System.exit(0);
	}
	
	
	public void openWarehouse(ActionEvent event) throws Exception {               
        try {
        	
        	String id1 = tf1.getText();
        	int id = Integer.parseInt(id1);
        	String password = tf2.getText();
        	boolean check=false;
			ArrayList<warehouse> waa=system1.superstore.getWarehousees();
			for(warehouse temp:waa) {
				if(temp.check_credentials(id, password)) {
					check=true;
					w=temp.getWarehouseadministrator();
				}
			}			System.out.println(check);
        	if(check)
        	{
        
        		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WareHouse.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.close();
                stage.setScene(new Scene(root1));  
                ((Node)(event.getSource())).getScene().getWindow().hide();
                stage.show();}
        	else
        	{
        		
        		tf2.setStyle("-fx-border-color: #ff0000");
        	}
        	}
        
        catch(Exception e) {
           e.printStackTrace();
          
        }
	}
	public void openMainmenu(ActionEvent event) throws Exception {               
        try {
        	
        	
        	
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.close();
                stage.setScene(new Scene(root1));  
                ((Node)(event.getSource())).getScene().getWindow().hide();
                stage.show();
     
        } catch(Exception e) {
           e.printStackTrace();
          }
	}
	
	
}
