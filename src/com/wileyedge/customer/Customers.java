package com.wileyedge.customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.wileyedge.bankaccount.BankAccount;
import com.wileyedge.utilities.InputUtilities;


public class Customers {
	private Customer[] customers;
	private static int count = 0;
	
	public Customers() {
		super();
	}

	public Customers(int initialNumOfCustomers) {
		super();
		this.customers = new Customer[initialNumOfCustomers];
	}
	
	public void addCustomer(Customer customer) {
        // Creating new array double the size
		if(customers.length == count) {
        	Customer newCustomersList[] = new Customer[2 * count];
    
        	//copy all items of original customer list to new customer list
    		for(int i=0; i<customers.length;i++) {
    			newCustomersList[i] = customers[i];
    		}	
    		//Assigning new customers list to original customers list
    		customers = newCustomersList;
        }		
		// adding new item to the the array
		customers[count++] = customer;
		System.out.println("Custmer with Id of " + customer.getCustId() + "has been added to the list successfully.");
		
    }

	public Customer[] getCustomers() {
		return customers;
	}

	public void setCustomers(Customer[] customers) {
		this.customers = customers;
	}

	public static int getCount() {
		return count;
	}
	

    public boolean customerHasNoBankAccount(Customer customer) {
    	return customer.getBankAccount() == null;
    }
    
    
    public void getBankAccountDetails(int customerId) {    	
    	//Get customer account number
    	String promptGetAccntNum = "Enter account number :";
    	long minAccNum = 100000;
    	long maxAccNum = 1000000000;
    	long accountNum = InputUtilities.getInputAsLong(promptGetAccntNum, minAccNum, maxAccNum);
    	
    	//Get customer account BSB Code
    	String promptGetBsbCode = "Enter BSB Code :";
    	long minBsbNum = 100000;
    	long maxBsbNum = 900000;
    	long bsb = InputUtilities.getInputAsLong(promptGetBsbCode, minBsbNum, maxBsbNum);
    	
    	//Get customer bank name
    	String promptGetBankName = "Enter bank name :";
    	int minBankName = 3;
    	int maxBankName = 20;
    	String bankName = InputUtilities.getInputAsString(promptGetBankName, minBankName, maxBankName);
    	
    	//Get customer account number
    	String promptGetBankBal = "Enter bank balance : ";
    	double minAccBal = 0.00;
    	double maxAccBal = 900000000.00;
    	double bankBal = InputUtilities.getInputAsDouble(promptGetBankBal, minAccBal, maxAccBal);
    	
    	//Get Opening Date
    	String promptGetOpeningDate = "Enter opening date DD/MM/YYYY : ";
    	String openingDate = InputUtilities.getInputAsDate(promptGetOpeningDate);

    	//Get customer object from customer id
    	Customer customer = getCustomerById(customerId);
    	
    	//Invoke method to create bank account
    	this.assignBankAccountForCustomer(customer,accountNum,bsb,bankName,bankBal,openingDate);
    		
    }
    
    public void assignBankAccountForCustomer(int customerId) {
    	Customer customer = getCustomerById(customerId);
    	if( customer == null) {
    		System.out.println("Invalid customer ID.");
            return;
    	}else if(!customerHasNoBankAccount(customer)) {
    		System.out.println("This customer already has a bank account linked.");
            return;
    	}
  	
    	getBankAccountDetails(customerId);
    }
    
    public void assignBankAccountForCustomer(Customer customer,long accntNum, long bsbCode, String accntName, double accntBal, String accntOpeningDate) {
        BankAccount bankAccount = new BankAccount(accntNum, bsbCode, accntName, accntBal, accntOpeningDate);
        customer.setCustomerBankAccount(bankAccount);
        System.out.println("Bank account created successfully!");
    }
    
    public void withdrawal(int customerId, double amount) {
        Customer customer = getCustomerById(customerId);
        if (customer == null) {
            System.out.println("Customer with ID " + customerId + " not found.");
            return;
        }
        BankAccount account = customer.getBankAccount();
        account.withdraw(amount);
    }

	public void displayCustomers() {
	    displayCustomers(this.customers);
	}

	public void displayCustomers(Customer[] customers) {
	    System.out.println("\n==========Customers List==========");
	    if(customers.length == 0) {
	    	System.out.println("No customers to display");
	    }else {
	    	for(Customer cust: customers) {
		        if(cust != null) {
		            System.out.println(cust);
		        }
		    }
	    }
	}
	
	public Customer[] searchCustomersByName(String name) {
	    Customer[] matchingCustomers = new Customer[count];
	    int matchingCount = 0;
	    for (int i = 0; i < count; i++) {
	        if (customers[i].getCustName().equalsIgnoreCase(name)) {
	            matchingCustomers[matchingCount++] = customers[i];
	        }
	    }
	    matchingCustomers = Arrays.copyOfRange(matchingCustomers, 0, matchingCount);	    
	    
	    return matchingCustomers;
	}
	
	public Customer getCustomerById(int customerId) {
	    for (Customer customer : customers) {
	        if (customer != null && customer.getCustId() == customerId) {
	            return customer;
	        }
	    }
	    return null;
	}
	
}
