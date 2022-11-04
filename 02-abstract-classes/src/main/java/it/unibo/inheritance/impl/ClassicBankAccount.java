package it.unibo.inheritance.impl;
import it.unibo.inheritance.api.AccountHolder;

public class ClassicBankAccount extends AbstractBankAccount {
    private static final double MANAGEMENT_FEE = 5;
    
    public ClassicBankAccount(final AccountHolder accountHolder, final double balance) {
        super(accountHolder, balance);
    }

    public void chargeManagementFees(final int id) {
        if (checkUser(id)) {
            setBalance(getBalance() - SimpleBankAccount.MANAGEMENT_FEE);
            resetTransactions();
        }
    }

    public boolean isWithDrawAllowed(double parameter){ 
        return true;
    }

    public double computeFee(){
        return MANAGEMENT_FEE;
    } 
}
