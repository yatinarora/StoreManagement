package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class storehouse implements Serializable{
	private storehouse_administrator storehouseadministrator;
	private String name;
	private int id;
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return this.getName();
	}
	public void setId(int id) {
		this.id = id;
	}
	public HashMap<String, ArrayList<String>> getCategories() {
		return categories;
	}
	public void setCategories(HashMap<String, ArrayList<String>> categories) {
		this.categories = categories;
	}
	private warehouse Warehouse;
	private HashMap<String,ArrayList<String>> categories=new HashMap<>();
	private HashMap<String,product> map2=new HashMap<>();
	private HashMap<product,String[]> product_path=new HashMap<>();
	storehouse(int id,String name){
		this.getCategories().put("root", new ArrayList<String>());
		this.name=name;
		this.id=id;
	}
	public void deletecategory(String[] path) {
		if(this.search(path)) {
			this.help_delete(path[path.length-1]);
			if(path.length-2>=0)
			this.getcategories().get(path[path.length-2]).remove(path[path.length-1]);
		}
		else {
			System.out.println("the given category does not exists ");
		}
	}
	public void help_delete(String temp) {
		if(this.getcategories().containsKey(temp)){
		for(String i:this.getcategories().get(temp)) {
			help_delete(i);
		}
		this.getcategories().remove(temp);
		if(this.map2.containsKey(temp)) {
			this.getProduct_path().remove(this.getMap2().get(temp));
			this.getMap2().remove(temp);
		}
		}
	}
	public void modify(String name,int id,int price,int D,int H,int K){
		if(this.getMap2().containsKey(name)) {
		product p=search_product(name);
		p.setPrice(price);
		p.setD(D);
		p.setH(H);
		p.setK(K);
		p.calc_EOQ();
		}
		else {
			System.out.println("product does not exist");
		}
	}
	public boolean search(String[] path) {
		int length=path.length;
		int counter=0;
		if(!this.categories.containsKey(path[0])) {
			return false;
		}
		while(counter<=length-2) {
			if(this.getcategories().containsKey(path[counter])) {
				if(this.getcategories().get(path[counter]).contains(path[counter+1])) {
					counter++;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		return true;
	}
	public product search_product(String p) {
		if(this.getMap2().containsKey(p)) {
			return this.getMap2().get(p); 
		}
		else {
		System.out.println("product does not exists");
		return null;
		}
	}
	public void insert(String[] path , product pro){
		if(!search(path)) {
			if(pro!=null) {
				getMap2().put(path[path.length-1], pro);
				this.product_path.put(pro, path);
				
			}
			int length=path.length;
			String p=path[length-1];
			int counter=0;
			while(counter<=length-2) {
				if(getcategories().containsKey(path[counter])) {
					if(getcategories().get(path[counter]).contains(path[counter+1])) {
						counter++;
					}
					else {
						getcategories().get(path[counter]).add((String)path[counter+1]);
						counter++;
					}
				}
				else {
					getcategories().put(path[counter],new ArrayList<String>());
				}
			}
			getcategories().put(path[length-1], new ArrayList<String>());
		}
		else {
			System.out.println("Category/product already exists");
		}
	}
	public void ask_products() {
		ArrayList<record> records=new ArrayList<record>();
		for(product p:this.map2.values()) {
			if(p.getStock()==0) {
				records.add(new record(p.getName(),p.getId(),p.getEOQ(),"xyz"));
			}
		}
		boolean[] arr=this.getWarehouse().manageRequest(records);
		for(int i=0;i<records.size();i++) {
			if(arr[i]==true) {
				this.map2.get(records.get(i).getName()).setStock(this.map2.get(records.get(i).getName()).getStock()+records.get(i).getQuantity());

			}
			else {
				System.out.println(records.get(i).getName()+" is not available");
			}
		}
	}
	public boolean check_credentials(int id,String password) {
		if(this.getStorehouseadministrator().getId()==id && this.getStorehouseadministrator().getPassword().equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}
	public HashMap<String, ArrayList<String>> getcategories() {
		return categories;
	}
	public void setcategories(HashMap<String, ArrayList<String>> categories) {
		this.categories = categories;
	}
	public HashMap<String, product> getMap2() {
		return map2;
	}
	public void setMap2(HashMap<String, product> map2) {
		this.map2 = map2;
	}
	public HashMap<product, String[]> getProduct_path() {
		return product_path;
	}
	public void setProduct_path(HashMap<product, String[]> product_path) {
		this.product_path = product_path;}
	public storehouse_administrator getStorehouseadministrator() {
		return storehouseadministrator;
	}
	public void setStorehouseadministrator(storehouse_administrator storehouseadministrator) {
		this.storehouseadministrator = storehouseadministrator;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public warehouse getWarehouse() {
		return Warehouse;
	}
	public void setWarehouse(warehouse warehouse) {
		Warehouse = warehouse;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
