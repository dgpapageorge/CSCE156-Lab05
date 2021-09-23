package com.cinco.payroll;

public class SalaryEmployee extends Employee{

	private double tax = .2;
	private double benefits = 100;
	double Salary;
	String Type = "Salary";
	
	public SalaryEmployee(String id, String first, String last, String title, double salary)
	{
		super(id,first,last,title);
		Salary = salary;
	}

	public String getType() {return Type;}
	
	@Override
	public double getNetPay() {
		return getGrossPay() - getTaxes() + benefits;
	}

	@Override
	public double getTaxes() {
		return getGrossPay() * tax;
	}

	@Override
	public double getGrossPay() {
		return Salary/52;
	}
	
}