package application;
import java.util.*;
import java.io.Serializable;
import java.lang.*;
public class warehouse implements Serializable{
		private warehouse_administrator warehouseadministrator;
		private String name;
		private int id;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		@Override
		public String toString() {
			return this.getName();
		}
		public HashMap<String, ArrayList<String>> getCategories() {
			return categories;
		}
		public void setCategories(HashMap<String, ArrayList<String>> categories) {
			this.categories = categories;
		}
		private HashMap<String,ArrayList<String>> categories=new HashMap<>();
		private HashMap<String,product> map2=new HashMap<>();
		private HashMap<product,String[]> product_path=new HashMap<>();
		private ArrayList<storehouse> stores=new ArrayList<storehouse>();
		ArrayList<warehouse> warehouses;
		warehouse(int id,String name,ArrayList<warehouse> warehouses) {
			this.getCategories().put("root", new ArrayList<String>());
			this.id=id;
			this.name=name;
			this.warehouses=warehouses;
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
		public void modify(String name,int id,int price,int stock,int D,int H,int K){
			if(this.getMap2().containsKey(name)) {
			product p=search_product(name);
			p.setPrice(price);
			p.setD(D);
			p.setH(H);
			p.setK(K);
			p.setStock(stock);
			p.calc_EOQ();
			}
			else {
				System.out.println("product does not exist");
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
		public boolean[] manageRequest(ArrayList<record> records) {
			boolean[] deliver_items=new boolean[records.size()];
			for(int i=0;i<records.size();i++) {
				if(map2.get(records.get(i).getName()).getStock()>=records.get(i).getQuantity()) {
					map2.get(records.get(i).getName()).setStock(map2.get(records.get(i).getName()).getStock()-records.get(i).getQuantity());
					deliver_items[i]=true;
				}
				else {
					deliver_items[i]=this.find_in_other_warehouses(records.get(i));
				}
			}
			return deliver_items;
		}
		public boolean find_in_other_warehouses(record r) {
			int max=Integer.MAX_VALUE;
			int index=-1;
			for(int i=0;i<this.warehouses.size();i++) {
				if(warehouses.get(i).getName()!=this.getName()){
				if(warehouses.get(i).getMap2().get(r.getName()).getStock()>max){
					max=warehouses.get(i).getMap2().get(r.getName()).getStock();
					index=i;
				}}
			}
			if(max>=r.getQuantity()) {
				warehouses.get(index).getMap2().get(r.getName()).setStock(warehouses.get(index).getMap2().get(r.getName()).getStock()-r.getQuantity());
				return true;
			}
			else {
				return false;
			}
		}
		public boolean check_credentials(int id,String password) {
			if(this.getWarehouseadministrator().getId()==id && this.getWarehouseadministrator().getPassword().equals(password)) {
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
		public warehouse_administrator getWarehouseadministrator() {
			return warehouseadministrator;
		}
		public void setWarehouseadministrator(warehouse_administrator warehouseadministrator) {
			this.warehouseadministrator = warehouseadministrator;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public ArrayList<storehouse> getStores() {
			return stores;
		}
		public void setStores(ArrayList<storehouse> stores) {
			this.stores = stores;
		}
		public ArrayList<warehouse> getWarehouses() {
			return warehouses;
		}
		public void setWarehouses(ArrayList<warehouse> warehouses) {
			this.warehouses = warehouses;
		}
		
}
