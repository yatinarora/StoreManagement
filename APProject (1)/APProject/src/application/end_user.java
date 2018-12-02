package application;
import java.util.*;
import java.io.*;
import java.lang.*;
public class end_user implements Serializable{
	private system1 system;
	ArrayList<String> cart=new ArrayList<>(); 
	end_user(system1 s){
		this.system=s;
	}
	private storehouse store;
	public void assign_store(storehouse h) {
		this.store=h;
	}
	public void partial_search(String temp) {
		for(product p:store.getMap2().values()) {
			if(p.getName().contains(temp)) {
				System.out.println(p.getName());
			}
		}
	}
	public void add_to_cart(String p) {
		cart.add(p);
	}
	public void checkout() {
		cart=new ArrayList<String>();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}

}
