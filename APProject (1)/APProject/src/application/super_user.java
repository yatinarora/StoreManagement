package application;

import java.io.Serializable;
import java.lang.*;
import java.util.*;
public class super_user implements Serializable{
	private String name;
	private int id;
	private String password;
	private super_store superstore;
	super_user(super_store superstore,String name,int id,String password){
		this.superstore=superstore;
		this.name=name;
		this.id=id;
		this.password=password;
	}
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
	public super_store getSuperstore() {
		return superstore;
	}
	public void setSuperstore(super_store superstore) {
		this.superstore = superstore;
	}
	public void create_warehouse(int houseid,String house_name,String admin_name,int admin_id,String password ) {
		warehouse h=new warehouse(houseid,house_name,superstore.getWarehousees());
		this.assign_warehouse_administrator(h, this.create_warehouse_administrator(h,admin_name, admin_id, password));
		superstore.getWarehousees().add(h);
	}
	public void create_storehouse(int houseid,String house_name,String admin_name,int admin_id,String password ,String warehouse) {
		storehouse h=new storehouse(houseid,house_name);
		this.assign_storehouse_administrator(h, this.create_storehouse_administrator(h,admin_name, admin_id, password));
		superstore.getStorehouses().add(h);
		ArrayList<warehouse> temp=this.superstore.getWarehousees();
		for(warehouse w:temp) {
			if(w.getName().equals(warehouse)) {
				this.link(h, w);
			}
		}
		
	}
	public void delete_warehouse(int id) {
		ArrayList<warehouse> temp=this.superstore.getWarehousees();
		for(warehouse tmp:temp) {
				if(tmp.getId()==id) {
					this.superstore.getWarehousees().remove(this.superstore.getWarehousees().indexOf(tmp));
					break;
				}
		}
	}
	public void delete_storehouse(int id) {
		ArrayList<storehouse> temp=this.superstore.getStorehouses();
		for(storehouse tmp:temp) {
				if(tmp.getId()==id) {
					this.superstore.getStorehouses().remove(this.superstore.getStorehouses().indexOf(tmp));
				}
		}
	}
	public warehouse_administrator create_warehouse_administrator(warehouse h,String name,int id,String password) {
		return new warehouse_administrator(h,name,id,password);
	}
	public storehouse_administrator create_storehouse_administrator(storehouse h,String name,int id,String password) {
		return new storehouse_administrator(h,name,id,password);
	}
	public void link(storehouse s,warehouse w) {
		s.setWarehouse(w);
		w.getStores().add(s);
	}
	public void assign_warehouse_administrator(warehouse h,warehouse_administrator a) {
		h.setWarehouseadministrator(a);
	}
	public void assign_storehouse_administrator(storehouse h,storehouse_administrator a) {
		h.setStorehouseadministrator(a);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
