package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EndUserController implements Initializable {
	@FXML private TextField storehousename;
	@FXML private TextField productname;
	@FXML ListView<String> list;
	ObservableList<String> items = FXCollections.observableArrayList();
	ArrayList<String> s = new ArrayList<String>();
	public void addtolist()
	{
			list.setItems(items);
			s.add("electronics:");
			s.add("clothes");
			s.add("furniture");
			for(String x:s)
			{
				
				items.add(x);
			}				
	}
	@Override 
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//		list.setItems(items);
//		s.add("electronics:");
//		s.add("clothes");
//		s.add("furniture");
//		for(String x:s)
//		{
//			
//			items.add(x);
//		}
    }    
	public void exit(ActionEvent event)
	{
		System.exit(0);
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
