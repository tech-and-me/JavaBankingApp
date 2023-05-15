package com.wileyedge.customer;

import java.io.Serializable;

import com.wileyedge.bankaccount.BankAccount;
import com.wileyedge.utilities.InputUtilities;

public class Customer implements Serializable {
	private int custId;
	private String custName;
	private int custAge;
	private int custMobNum;
	private String custPassportNum;
	private BankAccount bankAccount;
	
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
	
	public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setCustomerBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
	
	
	public Customer CreateNewCustomerData(Customers customers) {	
		String name;
		int age = 0;
		int mobNum = 0;
		String passportNum;
		
		// get customer name
		String promptGetCustomerInput = "Enter customer name :";
		int minNameLength = 2;
		int maxNameLenght = 20;
		name = InputUtilities.getInputAsString(promptGetCustomerInput, minNameLength, maxNameLenght);
		
		//Get customer age
		String promptGetAgeInput = "Enter customer age : ";
		int minAge = 18;
		int maxAge = 100;
		age = InputUtilities.getInputAsInteger(promptGetAgeInput, minAge, maxAge);
		
		//Get customer mobile phone number
		String promptGetMobInput = "Enter customer mobile number :";
		int minPhoneNum = 100000000;
		int maxPhoneNum = 500000000;
		mobNum = InputUtilities.getInputAsInteger(promptGetMobInput, minPhoneNum, maxPhoneNum);
		
		//Get customer passport number
		String promptGetPassportInput = "Enter customer passport number :";
		int minPassportNumLength = 5;
		int maxPassportNumLenght = 15;
		passportNum = InputUtilities.getInputAsString(promptGetPassportInput, minPassportNumLength, maxPassportNumLenght);

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
		String bankName = "N/A";
		String accountNumber = "N/A";
		double bankBalance = 0.00;
		if(this.bankAccount != null) {
			bankName = this.bankAccount.getBankName();
			accountNumber = String.valueOf(this.bankAccount.getAccntNum());
			bankBalance = this.bankAccount.getAccntBal();
		}
		return "ID: " + this.custId + " | " + "NAME: " + this.custName + " | " 
				+ "AGE: " + this.custAge 	+ " | " + "MOBILE: " + this.custMobNum + " | " + "Bank Name: " + bankName + " | " 
		+ "Bank Account Number: " + accountNumber + " | " + "Bank Balance: " + bankBalance;
	}
	
	
}
