package com.wileyedge.customer;

import java.util.Scanner;

public class Customer {
	private int custId;
	private String custName;
	private int custAge;
	private int custMobNum;
	private String custPassportNum;
	
	private static int lastCustId = 100;
	
	public Customer() {
		super();
	}

	public Customer(String custName, int custAge, int custMobNum, String custPassportNum) {
		super();
		this.custId = lastCustId;
		this.custName = custName;
		this.custAge = custAge;
		this.custMobNum = custMobNum;
		this.custPassportNum = custPassportNum;
		
		lastCustId++;
	}
	
	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public int getCustAge() {
		return custAge;
	}

	public void setCustAge(int custAge) {
		this.custAge = custAge;
	}

	public int getCustMobNum() {
		return custMobNum;
	}

	public void setCustMobNum(int custMobNum) {
		this.custMobNum = custMobNum;
	}

	public String getCustPassportNum() {
		return custPassportNum;
	}

	public void setCustPassportNum(String custPassportNum) {
		this.custPassportNum = custPassportNum;
	}

	public static int getLastCustId() {
		return lastCustId;
	}

	public static void setLastCustId(int lastCustId) {
		Customer.lastCustId = lastCustId;
	}
	
	
	public Customer CreateNewCustomerData(Scanner scanner, Customers customers) {	
		// get customer details from user input	
		System.out.println("Enter customer name :");
		String name = scanner.nextLine();
		System.out.println("Enter customer age :");
		int age = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter customer mobile number :");
		int mobNum = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter customer passport number :");
		String passportNum = scanner.nextLine();

		// Create customer object
		Customer customer = new Customer(name,age,mobNum,passportNum);
		
		// Add customer to customer List
		customers.addCustomer(customer);
		
		// Display customer details added
		System.out.println("Successfully added -- see details below :");
		System.out.println(customer);
		
		// return customer object
		return customer;
	}
	
	
	
	
	
	

	@Override
	public String toString() {
		return "ID: " + this.custId + " | " + "NAME: " + this.custName + " | " 
				+ "AGE: " + this.custAge 	+ " | " + "MOBILE: " + this.custMobNum;
	}
	
	
}
