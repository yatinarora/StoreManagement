package application;
import java.util.*;
import java.io.Serializable;
import java.lang.*;
import java.math.*;
public class product implements Serializable{
	private String name;
	private int id;
	private int price;
	private int stock;
	private int D;
	private int H;
	private int K;
	private int EOQ;
	product(String name,int id,int price,int stock,int D,int H,int K){
		this.name=name;
		this.id=id;
		this.price=price;
		this.stock=stock;
		this.D=D;
		this.H=H;
		this.K=K;
		this.calc_EOQ();
	}
	public int getEOQ() {
		return EOQ;
	}
	public void setEOQ(int eOQ) {
		EOQ = eOQ;
	}
	public void calc_EOQ(){
		this.EOQ=(int)Math.sqrt(2*D*K/H);
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public boolean equals(Object o) {
		if(o!=null && o.getClass()==product.class) {
			product p=(product)o;
			if(o.equals(this.id)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getD() {
		return D;
	}
	public void setD(int d) {
		D = d;
	}
	public int getH() {
		return H;
	}
	public void setH(int h) {
		H = h;
	}
	public int getK() {
		return K;
	}
	public void setK(int k) {
		K = k;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
