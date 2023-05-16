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
