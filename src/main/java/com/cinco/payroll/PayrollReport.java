package com.cinco.payroll;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This is the main driver program that parses the payroll
 * data file and produces a payroll report.
 *
 */
public class PayrollReport {

	public static List<Employee> parseDataFile() {
		List<Employee> result = new ArrayList<Employee>();
		File f = new File("data/employee.dat");
		try(Scanner s = new Scanner(f)) {
			while(s.hasNext()) {
				String line = s.nextLine();
				if(!line.trim().isEmpty()) {
					Employee e = null;
					String tokens[] = line.split(";");
					String id = tokens[1];
					String nameTokens[] = tokens[2].split(",");
					String lastName = nameTokens[0];
					String firstName = nameTokens[1];
					String title = tokens[3];
					int annualSalary = 0;
					double hourlyPayRate = 0.0, hoursWorked = 0;
					if(tokens.length == 6) {
						hourlyPayRate = Double.parseDouble(tokens[4]);
						hoursWorked = Double.parseDouble(tokens[5]);
					} else if(tokens.length == 5) {
						annualSalary = Integer.parseInt(tokens[4]);
					}
					
					if(tokens[0].equals("E")) {
						e = new SalaryEmployee(id,firstName,lastName,title,annualSalary);
					} else if(tokens[0].equals("S")) {
						e = new Staff(id,firstName,lastName,title,hourlyPayRate,hoursWorked);
					} else if(tokens[0].equals("T")) {
						e = new Temporary(id,firstName,lastName,title,hourlyPayRate,hoursWorked);
					}
					
					result.add(e);
				}
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}

		return result;
	}
	
	public static void main(String args[]) {

		//get the employees from the data file
		List<Employee> payroll = parseDataFile();

		StringBuilder sb = new StringBuilder();
		
		sb.append(String.format("%-8s %-20s %-10s %-30s %9s %9s %9s\n", 
				"ID", "Name", "Type", "Title", "Gross", "Taxes", "Net"));

		//for each employee
		for(Employee e : payroll) {
			//format their information
			sb.append(String.format("%-8s %-20s %-10s %-30s $%8.2f $%8.2f $%8.2f\n", 
					e.getID(),e.getFirst()+" "+e.getLast(),e.getType(),e.getTitle(),e.getGrossPay(),e.getTaxes(),e.getNetPay()));
		}
		
		System.out.println(sb);
	}
	
}
