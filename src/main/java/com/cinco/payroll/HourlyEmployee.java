package com.cinco.payroll;

public abstract class HourlyEmployee extends Employee {

	double Hourly, Hours;
	
	public HourlyEmployee(String id, String first, String last, String title, double hourly, double hours)
	{
		super(id,first,last,title);
		Hourly = hourly;
		Hours = hours;
	}

	public double getHourlyPayRate()
	{
		return Hourly;
	}
	
	public double getHoursWorked()
	{
		return Hours;
	}

	@Override
	public double getGrossPay() {
		return Hourly*Hours;
	}

	
}