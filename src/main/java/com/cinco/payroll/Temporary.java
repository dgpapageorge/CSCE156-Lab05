package com.cinco.payroll;

public class Temporary extends HourlyEmployee {

	double tax = 0;
	String Type = "Temporary";
	public Temporary(String id, String first, String last, String title, double hourly, double hours)
	{
		super(id,first,last,title,hourly,hours);
	}

	public String getType() {return Type;}
	public double getTaxes() {return tax;}

	
}
