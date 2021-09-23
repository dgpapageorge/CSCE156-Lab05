package com.cinco.payroll;

public abstract class Employee implements Payable {

	private String ID,First,Last,Title;
	
	public Employee(String id, String first, String last, String title)
	{
		ID = id;
		First = first;
		Last = last;
		Title = title;
	}
	
	public String getID() { return ID;}
	public String getFirst() {return First;}
	public String getLast() {return Last;}
	public String getTitle() {return Title;}

	public abstract double getTaxes();
	public abstract double getGrossPay();
	public abstract String getType();
	
	public double getNetPay()
	{
		return getGrossPay()-getTaxes();
	}
}