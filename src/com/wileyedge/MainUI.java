package com.wileyedge;

import java.util.Scanner;
import com.wileyedge.customer.Customer;
import com.wileyedge.customer.Customers;
import com.wileyedge.utilities.InputUtilities;


public class MainUI {
	public static void main(String[] args) {
		int initialCustomersListSize = 3;
		Customer customer = new Customer();
		Customers customers = new Customers(initialCustomersListSize);
		Scanner scanner = new Scanner(System.in);
		
		boolean readyToExit = false;
		
		while(!readyToExit) {
			System.out.println("-------------------------");
            System.out.println("Java Banking Application");
            System.out.println("-------------------------");
            System.out.println("1 - Create New Customer Data");
            System.out.println("2 - Assign a Bank Account to a Customer");
            System.out.println("3 - Display balance or interest earned of a Customer");
            System.out.println("4 - Sort Customer Data");
            System.out.println("5 - Persist Customer Data");
            System.out.println("6 - Show All Customers");
            System.out.println("7 - Search Customers by Name");
            System.out.println("8 - Exit");
            System.out.println("9 - Withdraw bank balance by customer ID");
            System.out.println("9 - Deposit to Customer Bank Account by customer ID");
            
            String option = scanner.nextLine();
            
            switch(option) {
            case "1": // Create New Customer Data
            	customer.CreateNewCustomerData(customers);
            	break;
            case "2":// Assign a Bank Account to a Customer
            	System.out.println("Enter customer id you want to assign bank account : ");
            	int customerId = scanner.nextInt();
            	scanner.nextLine();
            	customers.assignBankAccountForCustomer(customerId);
            	break;
            case "3": // Display balance or interest earned of a customer   -- TO BE COMPLETED
            	System.out.println("Display balance or interest earned of a customer ---Under development---Stay tune!");
            	break;
            case "4": // Sort customer data  -- TO BE COMPLETED
            	System.out.println("Sort customer data ---Under development---Stay tune!");
            	break;
            case "5": // Persist Customer Data -- TO BE COMPLETED
            	System.out.println("Persist Customer Data ---Under development---Stay tune!");
            	break;
            case "6": // Show all customers            
            	customers.displayCustomers();
            	break;
            case "7": // Search Customers by Name
            	System.out.println("Enter customer name you want to search : ");
            	String searchName = scanner.nextLine();
            	Customer[] matchingCustomers = customers.searchCustomersByName(searchName);
            	customers.displayCustomers(matchingCustomers);			
            	break;
            case "8": // Exit
            	System.out.println("Good Bye!");
            	scanner.close();
            	readyToExit = true;
            	break;
            case "9": // Withdraw
            	// Get customer Id as input
            	String promptGetId = "Enter customer Id for bank account withdrawal : ";
            	int min = 100;
            	int max = min + Customers.getCount();
            	int id = InputUtilities.getInputAsInteger(promptGetId, min, max);
            	
            	// Get amount to widthdraw
            	String promptGetAmount = "Enter Amount to withdrawal : ";
            	double minAmount = 1.00;
            	double maxAmount = 10000;
            	double amount = InputUtilities.getInputAsDouble(promptGetAmount, minAmount, maxAmount); 	
            	customers.withdrawal(id, amount);
            	break;
            case "10": // Deposit
            	System.out.println("-------Deposit----TO BE COMPLETED----");
            	break;
            default:
            		System.out.println("Option not valid - try again !");
            }
		}
		
	}

}
