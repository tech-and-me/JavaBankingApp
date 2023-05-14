package com.wileyedge.bankaccount;

import com.wileyedge.customer.Customer;

public class BankAccount {
	private long accntNum;
	private long bsbCode;
	private String bankName;
	private double accntBal;
	private String accntOpeningDate;
	
	public BankAccount(long accntNum, long bsbCode, String accntName, double accntBal, String accntOpeningDate) {
		super();
		this.accntNum = accntNum;
		this.bsbCode = bsbCode;
		this.bankName = accntName;
		this.accntBal = accntBal;
		this.accntOpeningDate = accntOpeningDate;
	}

	public long getAccntNum() {
		return accntNum;
	}

	public void setAccntNum(long accntNum) {
		this.accntNum = accntNum;
	}

	public long getBsbCode() {
		return bsbCode;
	}

	public void setBsbCode(long bsbCode) {
		this.bsbCode = bsbCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String accntName) {
		this.bankName = accntName;
	}

	public double getAccntBal() {
		return accntBal;
	}

	public void setAccntBal(double accntBal) {
		this.accntBal = accntBal;
	}

	public String getAccntOpeningDate() {
		return accntOpeningDate;
	}

	public void setAccntOpeningDate(String accntOpeningDate) {
		this.accntOpeningDate = accntOpeningDate;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
