package application;

import java.io.Serializable;
import java.util.*;
import java.lang.*;
import java.io.*;
public class system1 implements Serializable{
	public static Object out;
	public static super_store superstore;
	public static end_user enduser;
	public static void serialize()	throws	IOException	{	
		ObjectOutputStream out	=	null;	
		try	{	
					out	=	new	ObjectOutputStream	(	
											new FileOutputStream("out_customer.txt"));	
					out.writeObject(superstore);	
		}	finally	{	
					out.close();	
		}
}
public static void deserialize()throws	IOException,	ClassNotFoundException {	
					ObjectInputStream in=null;	
					try	{	
									in=	new	ObjectInputStream	(	
																new	FileInputStream("out_customer.txt"));	
							superstore=	(super_store)in.readObject();													
					}
					catch(IOException e) {
						System.out.println("You don't have any saved data");
					}
					
}
	
	public static void main(String[] args) throws IOException,ClassNotFoundException{
		// TODO Auto-generated method stub
		system1 s=new system1();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter 1 to reset");
		int t=sc.nextInt();
		if(t==1) {
			system1.superstore=new super_store("super",123,"123abc"); 
		}
		else {
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
		while((true)) {
			int f=sc.nextInt();
			if(f==1) {
				//Create Superuser credentials
				
				
				System.out.println("enter id");
				int id=sc.nextInt();
				System.out.println("enter password");
				String password=sc.next();
				if(system1.superstore.check_credentials(id, password)) {
					System.out.println("successful login");
				System.out.println("warehouses:");
				ArrayList<warehouse> ww=system1.superstore.getWarehousees();
				for(warehouse w:ww) {
					System.out.println(w.getName());
				}
				ArrayList<storehouse> ss=system1.superstore.getStorehouses();
				for(storehouse sss:ss) {
					System.out.println(sss.getName());
				}
				while(true) {
				int ff=sc.nextInt();
				if(ff==1) {
					String name;
					int houseid;
					String adminname;
					int adminId;
					String pass;
					System.out.println("enter name of the warehouse");
					name=sc.next();
					System.out.println("enetr warehouse id");
					houseid=sc.nextInt();
					System.out.println("enter admin name");
					adminname=sc.next();
					System.out.println("enetr admin id");
					adminId=sc.nextInt();
					System.out.println("enter password");
					pass=sc.next();
					system1.superstore.getSuperuser().create_warehouse(houseid, name, adminname, adminId, pass);
					
				}
				else if(ff==2) {
					int idhouse=sc.nextInt();
					system1.superstore.getSuperuser().delete_warehouse(idhouse);
				}
				else if(ff==3) {
					String name;
					int houseid;
					String adminname;
					int adminId;
					String pass;
					System.out.println("enter name of the storehouse");
					name=sc.next();
					System.out.println("enetr warehouse id");
					houseid=sc.nextInt();
					System.out.println("enter admin name");
					adminname=sc.next();
					System.out.println("enetr admin id");
					adminId=sc.nextInt();
					System.out.println("enter password");
					pass=sc.next();
					System.out.println("enter the warehouse to link");
					String warehouse=sc.next();
					system1.superstore.getSuperuser().create_storehouse(houseid, name, adminname, adminId, pass,warehouse);
				}
				else if(ff==4) {
					int idhouse=sc.nextInt();
					system1.superstore.getSuperuser().delete_storehouse(idhouse);
				}
				else if(ff==5) {
					//browse storehouse;
				}
				else if(ff==6) {
					//browse warehouse;
				}
				else {
					break;
				}}}
				else {
					System.out.println("unsuccessful login");
				}
			}
			else if(f==2) {
				//warehouse
				System.out.println("enter id");
				int id=sc.nextInt();
				System.out.println("enter password");
				String password=sc.next();
				warehouse_administrator w=null;
				ArrayList<warehouse> waa=system1.superstore.getWarehousees();
				for(warehouse temp:waa) {
					if(temp.check_credentials(id, password)) {
						w=temp.getWarehouseadministrator();
					}
				}
				if(w==null) {
					System.out.println("admin does not exists");
				}
				else {
					while(true) {
						System.out.println("select options");
						
						
						
						
						//1 for adding categories
						//2 for Delete category
						//3 for Add product
						//4 Delete product
						
						
						
						
						
						
						int ff=sc.nextInt();
						if(ff==1) {
						//for adding category;
						String root="root";
						ArrayList<String> cat=new ArrayList<String>();
						cat.add("root");
						while(true) {
							ArrayList<String> waaa=w.getWarehouse().getCategories().get(root);
							for(String str:waaa)
							{	System.out.println(str);
							}
							System.out.println("enter 1 to add category");
							System.out.println("enter 2 to go to next sub category");
							System.out.println("enter 3 to exit");
							int temp=sc.nextInt();
							int fl=0;
							if(temp==3) {
								break;
							}
							else if(temp==2) {
								System.out.println("select category");
								root=sc.next();
								cat.add(root);
							}
							else if(temp==1) {
								while(true) {
								System.out.println("enter category to add else enter exit");
								String tt=sc.next();
								if(tt.equals("exit")) {
									
									fl=1;
									break;
								}
								else
								{
								cat.add(tt);}
								}
							}
							if(fl==1) {
								break;
							}
							
						}
						w.addCategory(cat.toArray(new String[cat.size()]));
						}
						else if(ff==2){
							//delete 
							String root="root";
							ArrayList<String> cat=new ArrayList<String>();
							cat.add("root");
							while(true) {
								ArrayList<String> waaa=w.getWarehouse().getCategories().get(root);

								for(String str:waaa)
								{	System.out.println(str);
								}
								System.out.println("enter 1 to add subcategory");
								System.out.println("enter 2 to exit");
								int temp=sc.nextInt();
								if(temp==2) {
									break;
								}
								else {
								
									System.out.println("select category");
									root=sc.next();
									cat.add(root);
								}
							}
							w.deleteCategory(cat.toArray(new String[cat.size()]));
						}
						else if(ff==3) {
							//enter product;
							String root="root";
							ArrayList<String> cat=new ArrayList<String>();
							cat.add("root");
							while(true) {
								ArrayList<String> waaa=w.getWarehouse().getCategories().get(root);
								for(String str:waaa)
								{	if(w.getWarehouse().getMap2().containsKey(str))
								{break;}
								else {	
								System.out.println(str);}
								}
									System.out.println("select category");
									root=sc.next();
									cat.add(root);
									if(w.getWarehouse().getCategories().get(root).size()==0 ) {
										break;
								}
							}
							String name;
							int id1;int price;int stock;int D;int H;int K;
							System.out.println("enter product information");
							name=sc.next();
							id1=sc.nextInt();
							price=sc.nextInt();
							stock=sc.nextInt();
							D=sc.nextInt();
							H=sc.nextInt();
							K=sc.nextInt();
							cat.add(name);
							product p=new product(name,id1,price,stock,D,H,K);
							w.addProduct(cat.toArray(new String[cat.size()]), p);
						}
						else if(ff==4) {
							String root="root";
							ArrayList<String> cat=new ArrayList<String>();
							cat.add("root");
							while(true) {
								ArrayList<String> waaa=w.getWarehouse().getCategories().get(root);
								for(String str:waaa)
								{	if(w.getWarehouse().getMap2().containsKey(str))
								{break;}
								else {	
								System.out.println(str);}
								}
									System.out.println("select category");
									root=sc.next();
									cat.add(root);
									if(w.getWarehouse().getCategories().get(root).size()==0 ) {
										break;
								}
							}
							System.out.println("enter product to be deleted out of the following products");
							ArrayList<String> waaa=w.getWarehouse().getCategories().get(root);
							for(String str:waaa) {
								System.out.println(str);
							}
							cat.add(sc.next());
							w.deleteProduct(cat.toArray(new String[cat.size()]));
						}
						else if(ff==5) {
							//modifyproduct
							String root="root";
							ArrayList<String> cat=new ArrayList<String>();
							cat.add("root");
							while(true) {
								ArrayList<String> waaa=w.getWarehouse().getCategories().get(root);
								for(String str:waaa)
								{	if(w.getWarehouse().getMap2().containsKey(str))
								{break;}
								else {	
								System.out.println(str);}
								}
									System.out.println("select category");
									root=sc.next();
									cat.add(root);
									if(w.getWarehouse().getCategories().get(root).size()==0 ) {
										break;
								}
							}
							System.out.println("enter product to be modified out of the following products");
							for(String str:w.getWarehouse().getCategories().get(root)) {
								System.out.println(str);
							}
							String name;
							int id1;int price;int stock;int D;int H;int K;
							name=sc.next();
							System.out.println("enter product information");
							name=sc.next();
							id1=sc.nextInt();
							price=sc.nextInt();
							stock=sc.nextInt();
							D=sc.nextInt();
							H=sc.nextInt();
							K=sc.nextInt();
							w.modifyProduct(name, id1, price, stock, D, H, K);
						}
						else {
							break;
						}
					}
				}
			}
			else if(f==3) {
				System.out.println("enter id");
				int id=sc.nextInt();
				System.out.println("enter password");
				String password=sc.next();
				storehouse_administrator st=null;
				ArrayList<storehouse> sh=system1.superstore.getStorehouses();
				for(storehouse temp:sh) {
					if(temp.check_credentials(id, password)) {
						st=temp.getStorehouseadministrator();
					}
				}
				if(st==null) {
					System.out.println("admin does not exists");
				}
				else {
					while(true) {
						System.out.println("select options");
						int ff=sc.nextInt();
						if(ff==1) {
						//for adding category;
						String root="root";
						ArrayList<String> cat=new ArrayList<String>();
						cat.add("root");
						while(true) {
							ArrayList<String> shh=st.getStorehouse().getCategories().get(root);
							for(String str:shh)
							{	System.out.println(str);
							}
							System.out.println("enter 1 to add category");
							System.out.println("enter 2 to go to next sub category");
							System.out.println("enter 3 to exit");
							int temp=sc.nextInt();
							int fl=0;
							if(temp==3) {
								break;
							}
							else if(temp==2) {
								System.out.println("select category");
								root=sc.next();
								cat.add(root);
							}
							else if(temp==1) {
								while(true) {
								System.out.println("enter category to add else enter exit");
								String tt=sc.next();
								if(tt.equals("exit")) {
									fl=1;
									break;
								}
								else
								{
								cat.add(tt);}
								}
							}
							if(fl==1) {
								break;
							}
							
						}
						st.addCategory(cat.toArray(new String[cat.size()]));
						}
						else if(ff==2){
							String root="root";
							ArrayList<String> cat=new ArrayList<String>();
							cat.add("root");
							while(true) {
								ArrayList<String> shh=st.getStorehouse().getCategories().get(root);
								for(String str:shh)
								{	System.out.println(str);
								}
								System.out.println("enter 1 to add subcategory");
								System.out.println("enter 2 to exit");
								int temp=sc.nextInt();
								if(temp==2) {
									break;
								}
								else {
								
									System.out.println("select category");
									root=sc.next();
									cat.add(root);
								}
							}
							st.deleteCategory(cat.toArray(new String[cat.size()]));
						}
						else if(ff==3) {
							//enter product;
							String root="root";
							ArrayList<String> cat=new ArrayList<String>();
							cat.add("root");
							while(true) {
								ArrayList<String> shh=st.getStorehouse().getCategories().get(root);
								for(String str:shh)
								{	if(st.getStorehouse().getMap2().containsKey(str))
								{break;}
								else {	
								System.out.println(str);}
								}
									System.out.println("select category");
									root=sc.next();
									cat.add(root);
									if(st.getStorehouse().getCategories().get(root).size()==0 ) {
										break;
								}
							}
							String name;
							int id1;int price;int stock;int D;int H;int K;
							System.out.println("enter product information");
							name=sc.next();
							id1=sc.nextInt();
							price=sc.nextInt();
							stock=0;
							D=sc.nextInt();
							H=sc.nextInt();
							K=sc.nextInt();
							cat.add(name);
							product p=new product(name,id1,price,stock,D,H,K);
							st.select_product(cat.toArray(new String[cat.size()]), p);
						}
						else if(ff==4) {
							String root="root";
							ArrayList<String> cat=new ArrayList<String>();
							cat.add("root");
							while(true) {
								ArrayList<String> shh=st.getStorehouse().getCategories().get(root);
								for(String str:shh)
								{	if(st.getStorehouse().getMap2().containsKey(str))
								{break;}
								else {	
								System.out.println(str);}
								}
									System.out.println("select category");
									root=sc.next();
									cat.add(root);
									if(st.getStorehouse().getCategories().get(root).size()==0 ) {
										break;
								}
							}
							System.out.println("enter product to be deleted out of the following products");
							ArrayList<String> shh=st.getStorehouse().getCategories().get(root);
							for(String str:shh) {
								System.out.println(str);
							}
							cat.add(sc.next());
							st.deleteProduct(cat.toArray(new String[cat.size()]));
						}
						else if(ff==5) {
							//modifyproduct
							String root="root";
							ArrayList<String> cat=new ArrayList<String>();
							cat.add("root");
							while(true) {
								ArrayList<String> shh=st.getStorehouse().getCategories().get(root);
								for(String str:shh)
								{	if(st.getStorehouse().getMap2().containsKey(str))
								{break;}
								else {	
								System.out.println(str);}
								}
									System.out.println("select category");
									root=sc.next();
									cat.add(root);
									if(st.getStorehouse().getCategories().get(root).size()==0 ) {
										break;
								}
							}
							System.out.println("enter product to be modified out of the following products");
							ArrayList<String> shh=st.getStorehouse().getCategories().get(root);
							for(String str:shh) {
								System.out.println(str);
							}
							String name;
							int id1;int price;int stock;int D;int H;int K;
							name=sc.next();
							System.out.println("enter product information");
							name=sc.next();
							id1=sc.nextInt();
							price=sc.nextInt();
							D=sc.nextInt();
							H=sc.nextInt();
							K=sc.nextInt();
							st.modifyProduct(name, id1, price, D, H, K);
						}
						else {
							break;
						}
					}
				}
			}
			else if(f==4) {
				system1.enduser=new end_user(s);
				storehouse st=null;
				int flag=sc.nextInt();
				if(flag==1) {
					//select storehouse
					ArrayList<storehouse> shh=system1.superstore.getStorehouses();
					for(storehouse str:shh) {
						System.out.println(str.getName());
					}
					System.out.println("select storehouse");
					String temp=sc.next();
					
					for(storehouse str:shh) {
						if(str.getName()==temp) {
							st=str;
							break;
						}
					}
				}
				else if(flag==2) {
					String root="root";
					while(true) {
						ArrayList<String> shh=st.getCategories().get(root);
						for(String str:shh)
						{	if(st.getMap2().containsKey(str))
						{break;}
						else {	
						System.out.println(str);}
						}
							System.out.println("select category");
							root=sc.next();
							if(st.getCategories().get(root).size()==0 ) {
								break;
						}
					}
					System.out.println("enter product you want to buy");
					system1.enduser.cart.add(sc.next());
				}
				else if(flag==3) {
					Collection c=st.getMap2().keySet();
					ArrayList<String> temp=new ArrayList<>(c);
					Collections.sort(temp);
					for(String tt:temp) {
						System.out.println(tt);
					}
				}
				else if(flag==4) {
					system1.enduser.checkout();
				}
			}
			else {
				break;
			}
		}
		s.serialize();
		
	}

}
