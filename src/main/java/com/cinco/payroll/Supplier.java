package com.cinco.payroll;

public class Supplier implements Payable{

	String Name;
	Double Due;
	
	public Supplier(String n, double d)
	{
		Name = n;
		Due = d;
	}

	@Override
	public double getNetPay() {
		return Due;
	}

	@Override
	public double getGrossPay() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTaxes() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
