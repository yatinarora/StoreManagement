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

import java.io.Serializable;
import java.lang.*;
import java.math.*;



public class SuperuserloginController {
	@FXML private TextField tf1;
	@FXML private TextField tf2;
	
	public void exit(ActionEvent event)
	{
		System.exit(0);
	}
	
	
	public void opensuperstore(ActionEvent event) throws Exception {               
        try {
        	
        	if(tf1.getText().equals("123")&&tf2.getText().equals("123abc"))
        	{FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SuperStore (1).fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.close();
                stage.setScene(new Scene(root1));  
                ((Node)(event.getSource())).getScene().getWindow().hide();
                stage.show();
                SuperstoreController ss=new SuperstoreController(); 
        	
        	}
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
