package application;
import java.util.*;
import java.io.Serializable;
import java.lang.*;
import java.math.*;
public class super_store implements Serializable{
	private ArrayList<storehouse> storehouses=new ArrayList<storehouse>();
	private ArrayList<warehouse> warehousees=new ArrayList<warehouse>();
	private super_user superuser;
	
	super_store(String name,int id,String password){
		superuser=new super_user(this,name,id,password);
	}
	public boolean check_credentials(int id,String password) {
		if(this.getSuperuser().getId()==id && this.getSuperuser().getPassword().equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}
	public ArrayList<storehouse> getStorehouses() {
		return storehouses;
	}
	public void setStorehouses(ArrayList<storehouse> storehouses) {
		this.storehouses = storehouses;
	}
	public ArrayList<warehouse> getWarehousees() {
		return warehousees;
	}
	public void setWarehousees(ArrayList<warehouse> warehousees) {
		this.warehousees = warehousees;
	}
	public super_user getSuperuser() {
		return superuser;
	}
	public void setSuperuser(super_user superuser) {
		this.superuser = superuser;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	}

}
