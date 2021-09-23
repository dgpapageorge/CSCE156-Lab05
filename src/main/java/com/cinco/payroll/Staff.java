package com.cinco.payroll;

public class Staff extends HourlyEmployee {

	
	private double tax = .15;
	String Type = "Staff";
	
	public Staff(String id, String first, String last, String title, double hourly, double hours)
	{
		super(id,first,last,title,hourly,hours);
	}
	public String getType() {return Type;}
	public double getTaxes() {return getGrossPay()*tax;}
}