package com.wileyedge.customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
	
	public void displayCustomers() {
	    displayCustomers(this.customers);
	}

	public void displayCustomers(Customer[] customers) {
	    System.out.println("==========Customers List==========");
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

}
