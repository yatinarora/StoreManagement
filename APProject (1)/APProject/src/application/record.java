package application;

import java.io.Serializable;

public class record implements Serializable{
	private String name;
	private int id;
	private int Quantity;
	private String expected_Arrival_date;
	record(String name,int id,int quantity,String expected_Arrival_date){
		this.name=name;
		this.id=id;
		this.Quantity=quantity;
		this.expected_Arrival_date=expected_Arrival_date;
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
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public String getExpected_Arrival_date() {
		return expected_Arrival_date;
	}
	public void setExpected_Arrival_date(String expected_Arrival_date) {
		this.expected_Arrival_date = expected_Arrival_date;
	}
}
