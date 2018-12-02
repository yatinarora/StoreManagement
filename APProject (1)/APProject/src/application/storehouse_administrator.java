package application;

import java.io.Serializable;

public class storehouse_administrator implements Serializable{
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
	public storehouse getStorehouse() {
		return storehouse;
	}
	public void setStorehouse(storehouse storehouse) {
		this.storehouse = storehouse;
	}
	private  String name;
	private int id;
	private String password;
	private storehouse storehouse;
	storehouse_administrator(storehouse h,String name,int id,String password){
		this.storehouse=h;
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
	public void addCategory(String[] path) {
		if(storehouse.getWarehouse().search(path)==true) {
			storehouse.insert(path,null);
		}
		else {
			System.out.println("category does not exist in the warehouse");
		}
	}
	public void select_product(String[] path,product pro) {
		if(storehouse.getWarehouse().search(path)) {
			
		storehouse.insert(path, pro);}
		else {
			System.out.println("product does not exist in the warehouse");
		}
	}
	public void deleteProduct(String[] path) {
		storehouse.deletecategory(path);
	}
	public void deleteCategory(String[] path) {
		storehouse.deletecategory(path);
	}
	public void modifyProduct(String name,int id,int price,int D,int H,int K) {
		storehouse.modify(name, id, price, D, H, K);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
