package com.wileyedge.bankaccount;

import com.wileyedge.customer.Customer;

public class BankAccount {
	private long accntNum;
	private long bsbCode;
	private String accntName;
	private double accntBal;
	private String accntOpeningDate;
	private Customer customer;
	
	
	public BankAccount(long accntNum, long bsbCode, String accntName, double accntBal, String accntOpeningDate,
			Customer customer) {
		super();
		this.accntNum = accntNum;
		this.bsbCode = bsbCode;
		this.accntName = accntName;
		this.accntBal = accntBal;
		this.accntOpeningDate = accntOpeningDate;
		this.customer = customer;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
