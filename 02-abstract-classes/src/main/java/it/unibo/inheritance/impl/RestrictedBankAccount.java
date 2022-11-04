package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.AccountHolder;

public class RestrictedBankAccount extends AbstractBankAccount {
    
    private static final double TRANSACTION_FEE = 0.1;
    private static final double MANAGEMENT_FEE = 0;

    public RestrictedBankAccount(final AccountHolder accountHolder, final double balance) {
        super(accountHolder, balance);
    }

    public void chargeManagementFees(final int usrID) {
        final double feeAmount = MANAGEMENT_FEE + getTransactionsCount() * TRANSACTION_FEE;
        if (checkUser(usrID) && this.isWithDrawAllowed(feeAmount)) {
            setBalance(getBalance() - feeAmount);
            resetTransactions();
        }
    }

    public boolean isWithDrawAllowed(double parameter){ 
        return this.getBalance() >= parameter;
    }

    public double computeFee(){
        return MANAGEMENT_FEE;
    } 
}
