package application;

import java.io.Serializable;

public class warehouse_administrator implements Serializable{
		public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public warehouse getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(warehouse warehouse) {
		this.warehouse = warehouse;
	}
		private  String name;
		private int id;
		private String password;
		private warehouse warehouse;
		warehouse_administrator(warehouse warehouse,String name,int id,String password){
			this.warehouse=warehouse;
			this.name=name;
			this.id=id;
			this.password=password;
		}
		public boolean check_credentials(int id,String p) {
			if(this.id==id && this.password.equals(p)) {
				return true;
			}
			else {
				return false;
			}
		}
		public void addProduct(String[] path ,product p) {
			warehouse.insert(path,p);
		}
		public void modifyProduct(String name,int id,int price,int stock,int D,int H,int K) {
			warehouse.modify(name, id, price, stock, D, H, K);
		}
		public void deleteProduct(String[] path) {
			warehouse.deletecategory(path);
		}
		public void deleteCategory(String[] path) {
			warehouse.deletecategory(path);
		}
		public void addCategory(String[] path) {
			warehouse.insert(path, null);
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
