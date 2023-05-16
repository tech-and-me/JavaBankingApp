package com.wileyedge.bankaccount;

public class SavingAccount extends BankAccount {
	private boolean isSalaryAccount;
	private double interestEarned;
	public static final float MIN_BALANCE = 100;
	public static final double INTEREST_RATE = 0.04;
	
	public SavingAccount(long accntNum, long bsbCode, String accntName, double accntBal, String accntOpeningDate) {
	    super(accntNum, bsbCode, accntName, accntBal, accntOpeningDate);
	    this.interestEarned = 0.0;
	}
	
	public boolean isSalaryAccount() {
        return isSalaryAccount;
    }

    public void setSalaryAccount(boolean isSalaryAccount) {
        this.isSalaryAccount = isSalaryAccount;
    }
    
    public double getInterestEarned() {
		return interestEarned;
	}
    
	public void setInterestEarned(double interestEarned) {
		this.interestEarned = interestEarned;
	}
	
	public SavingAccount(BankAccount b) {
		super(b.getAccntNum(), b.getBsbCode(), b.getBankName(), b.getAccntBal(), b.getAccntOpeningDate());
	}

	@Override
	public double CalculateInterest() {
		return this.getAccntBal() * INTEREST_RATE;		
	}
}
