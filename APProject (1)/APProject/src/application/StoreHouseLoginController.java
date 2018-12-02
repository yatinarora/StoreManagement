package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StoreHouseLoginController {

	@FXML private TextField tf1;
	@FXML private TextField tf2;
	
	public void exit(ActionEvent event)
	{
		System.exit(0);
	}
	
	
	public void openStorehouse(ActionEvent event) throws Exception {               
        try {
        	
        	String id1 = tf1.getText();
        	int id = Integer.parseInt(id1);
        	String password = tf2.getText();
        	boolean check=false;
        	warehouse_administrator w=null;
			ArrayList<warehouse> waa=system1.superstore.getWarehousees();
			for(warehouse temp:waa) {
				if(temp.check_credentials(id, password)) {
					check=true;
					w=temp.getWarehouseadministrator();
				}
			}
			System.out.println(check);
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
	public void update_product() {
		
	}
	
}
