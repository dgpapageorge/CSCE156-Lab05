package com.cinco.payroll;

public interface Payable {

	public abstract double getNetPay();
	public abstract double getGrossPay();
	public abstract double getTaxes();
}
