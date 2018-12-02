package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.ListView;;
public class SuperstoreController {
	@FXML private TextField warehousename;
	@FXML private TextField warehouseid;
	@FXML private TextField storehouseid;
	@FXML private TextField warehouseadminname;
	@FXML private TextField warehouseadminid;
	@FXML private TextField warehousepass;
	@FXML private TextField Storehousename;
	@FXML private TextField Storehouseadminname;
	@FXML private TextField Storehouseadminid;
	@FXML private TextField Storehousepass;
	@FXML private TextField Warehouselink;
	@FXML private TextField Deletestore;
	@FXML private TextField Deletewarehouse;
	@FXML private Label l1;
	@FXML private Label l11;
	@FXML public ListView<storehouse> ls;
	@FXML public ListView<warehouse> lw;

	
	public void exit(ActionEvent event)
	{
		System.exit(0);
	}
	
	public void Createwarehouse(){
		int houseid=Integer.parseInt(warehouseid.getText());
		String name=warehousename.getText();
		String adminname=warehouseadminname.getText();
		int adminId=Integer.parseInt(warehouseadminid.getText());;
		String pass=warehousepass.getText();
		
//		l1.setText(houseid+name+adminname+adminId+pass);
		system1.superstore.getSuperuser().create_warehouse(houseid, name, adminname, adminId, pass);
		
		warehouse_administrator w=null;
		ArrayList<warehouse> waa=system1.superstore.getWarehousees();
		boolean check = false;
		for(warehouse temp:waa) {
			if(temp.check_credentials(houseid, pass)) {
				check=true;
				w=temp.getWarehouseadministrator();
			}
		}
		if(check)
		{
			l1.setText("Warehouse added :)");
		}
		else
		{
			l1.setText("Warehouse not added :(");
		}
		warehouseid.setText("");
		warehousename.setText("");
		warehouseadminname.setText("");
		warehouseadminid.setText("");
		warehousepass.setText("");
		this.DisplayStorehouse();
		this.DisplayWarehouse();
	}
	public void CreateSuperstore()
	{
		int houseid=Integer.parseInt(storehouseid.getText());
		String name=Storehousename.getText();
		String adminname=Storehouseadminname.getText();
		int adminId=Integer.parseInt(Storehouseadminid.getText());;
		String pass=Storehousepass.getText();		
		String warehouse=Warehouselink.getText();
		system1.superstore.getSuperuser().create_storehouse(houseid, name, adminname, adminId, pass,warehouse);
		l11.setText("Warehouse added :)");
		storehouseid.setText("");
		Storehousename.setText("");
		Storehouseadminname.setText("");
		Storehousepass.setText("");
		Warehouselink.setText("");
		Storehouseadminid.setText("");
		this.DisplayStorehouse();
		this.DisplayWarehouse();
	}
	public void deletesuperstore()
	{
		int idhouse=Integer.parseInt(Deletestore.getText());
		system1.superstore.getSuperuser().delete_storehouse(idhouse);
		Deletestore.setText("");
		this.DisplayStorehouse();
		this.DisplayWarehouse();
	}
	public void deleteWarehouse()
	{
		int idhouse=Integer.parseInt(Deletewarehouse.getText());
		system1.superstore.getSuperuser().delete_warehouse(idhouse);
		Deletewarehouse.getText();
		this.DisplayStorehouse();
		this.DisplayWarehouse();
	}
	public void DisplayStorehouse()
	{
		ls.getItems().clear();
		ls.getItems().addAll(system1.superstore.getStorehouses());
	}
	public void DisplayWarehouse()
	{
		lw.getItems().clear();
		lw.getItems().addAll(system1.superstore.getWarehousees());
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
