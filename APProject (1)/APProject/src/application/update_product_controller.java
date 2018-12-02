package application;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class update_product_controller {
	private warehouse_administrator w=WarehouseloginAdmincontroller.w;
	@FXML
	private ListView<String> listcat; 
	@FXML
	private TextField f1;
	@FXML
	private TextField f2;
	@FXML
	private ListView<String> listproduct; 
	@FXML
	private TextField id;
	@FXML
	private TextField price;
	@FXML
	private TextField H;
	@FXML
	private TextField D;
	@FXML
	private TextField K;
	@FXML
	private TextField stock;
	@FXML
	private TextField name;
	private String root="root";
	private ArrayList<String> cat=new ArrayList<String>();
	public void browse() {
		cat.add("root");
		ArrayList<String> waaa=w.getWarehouse().getCategories().get(root);
		for(String str:waaa)
		{	if(w.getWarehouse().getMap2().containsKey(str))
		{f2.setText("select and modify product");
		listcat.getItems().clear();
		for(String str1:waaa) {
			this.listproduct.getItems().add(str1);
		}
		break;
		
		}
		else {	
		this.listcat.getItems().add(str);}
		}
	}
	public void write_categories() {
		this.listcat.getItems().clear();
		ArrayList<String> waaa=w.getWarehouse().getCategories().get(root);
		for(String str:waaa)
		{	if(w.getWarehouse().getMap2().containsKey(str))
		{f2.setText("select and modify product");
			listcat.getItems().clear();
			for(String str1:waaa) {
				this.listproduct.getItems().add(str1);
			}
			break;
		}
		else {	
		this.listcat.getItems().add(str);}
		}
	}
	public void updateroot() {
		root=f1.getText();
		cat.add(root);
		f1.setText("");
		write_categories();
	}
	public void update_product() {
		w.modifyProduct(name.getText(), Integer.parseInt(id.getText()), Integer.parseInt(price.getText()), Integer.parseInt(stock.getText()),Integer.parseInt(D.getText()), Integer.parseInt(H.getText()),Integer.parseInt(K.getText()));
	}

}

