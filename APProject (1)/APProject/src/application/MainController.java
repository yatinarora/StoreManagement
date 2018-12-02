package application;

import java.util.ArrayList;

import javafx.event.*;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.*;

public class MainController {
	@FXML
	public Button closeButton;
	public void exit(ActionEvent event) throws Exception
	{
		system1.serialize();
		System.exit(0);
	}
	
	public void reset(ActionEvent event) throws Exception {
		system1.superstore=new super_store("super",123,"123abc"); 
		system1.serialize();
	}
	public void no_reset(ActionEvent event) throws Exception {
		system1.deserialize();
		ArrayList<warehouse> wa=system1.superstore.getWarehousees();
		for(warehouse w:wa) {
			w.setWarehouses(system1.superstore.getWarehousees());
		}
		ArrayList<storehouse> sa=system1.superstore.getStorehouses();
		for(storehouse st:sa) {
				for(warehouse w:wa) {
					if(w.getId()==st.getWarehouse().getId()) {
						st.setWarehouse(w);
					}
				}
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
                System.out.println("warehouses:");
				ArrayList<warehouse> ww=system1.superstore.getWarehousees();
				for(warehouse w:ww) {
					System.out.println(w.getName());
				}
     
        } catch(Exception e) {
           e.printStackTrace();
          }
	}
	@FXML private Button b1;
	public void openSuperuserlogin(ActionEvent event) throws Exception {               
        try {
        
        
    
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SuperUser_LoginPage.fxml"));
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
	public void openWarehouselogin(ActionEvent event) throws Exception {               
        try {
        
        	
    
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WarehouseAdmin_LoginPage.fxml"));
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
	public void openSTorehouselogin(ActionEvent event) throws Exception {               
        try {
        
        	
    
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StoreAdmin_LoginPage.fxml"));
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
	public void openEnduserlogin(ActionEvent event) throws Exception {               
        try {
        
        	
    
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EndUser.fxml"));
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
	
	public void opensuperstore(ActionEvent event) throws Exception {               
        try {
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SuperStore (1).fxml"));
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
	public void openWarehouse(ActionEvent event) throws Exception {               
        try {
        
        	
    
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WareHouse.fxml"));
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
	public void openStoreHouse(ActionEvent event) throws Exception {               
        try {
        
        	
    
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StoreHouse.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
             
                stage.setScene(new Scene(root1));  
                ((Node)(event.getSource())).getScene().getWindow().hide();
                stage.show();
     
        } catch(Exception e) {
           e.printStackTrace();
          }
	}
	
	
	public void openAddProduct(ActionEvent event) throws Exception {               
        try {
        
        	
    
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProduct.fxml"));
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
	public void openupdateproduct(ActionEvent event) throws Exception {               
        try {
        
        	
    
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateProduct.fxml"));    
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
	public void openWarehousesearch(ActionEvent event) throws Exception {               
        try {
        
        	
    
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("warehouse_search.fxml"));
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
	public void openWarehouseInventory(ActionEvent event) throws Exception {               
        try {
        
        	
    
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("warehouse_inventory.fxml"));
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
	public void openStoreHouseInventory(ActionEvent event) throws Exception {               
        try {
        
        	
    
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("storehouse_inventory.fxml"));
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
	
	public void opencart(ActionEvent event) throws Exception {               
        try {
        
        	
    
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cart.fxml"));
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
	public void openMANAGE(ActionEvent event) throws Exception {               
        try {
        
        	
    
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ManageCategory.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
             
                stage.setScene(new Scene(root1));  
                ((Node)(event.getSource())).getScene().getWindow().hide();
                stage.show();
     
        } catch(Exception e) {
           e.printStackTrace();
          }
	}
	public void openDeleteProduct(ActionEvent event) throws Exception {               
        try {
        
        	
    
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DeleteProduct.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
             
                stage.setScene(new Scene(root1));  
                ((Node)(event.getSource())).getScene().getWindow().hide();
                stage.show();
     
        } catch(Exception e) {
           e.printStackTrace();
          }
	}
	
}
