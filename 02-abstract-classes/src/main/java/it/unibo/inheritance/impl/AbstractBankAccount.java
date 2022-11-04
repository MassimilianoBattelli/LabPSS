package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.BankAccount;
import it.unibo.inheritance.api.AccountHolder;

public abstract class AbstractBankAccount implements BankAccount {

    protected static final double ATM_TRANSACTION_FEE = 1;

    private final AccountHolder holder;
    private double balance;
    private int transactions;

    AbstractBankAccount(final AccountHolder holder) {
        this(holder, 0);
        this.resetTransactions();
    }

    AbstractBankAccount(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
        this.resetTransactions();
    }

    public void deposit(final int id, final double amount) {
        this.transactionOp(id, amount);
    }

    public void depositFromATM(final int id, final double amount) {
        this.deposit(id, amount - SimpleBankAccount.ATM_TRANSACTION_FEE);
    }

    public AccountHolder getAccountHolder() {
        return this.holder;
    }

    public double getBalance() {
        return this.balance;
    }

    protected void setBalance(final double balance) {
        this.balance = balance;
    }

    public int getTransactionsCount() {
        return this.transactions;
    }

    public void withdrawFromATM(final int id, final double amount) {
        this.withdraw(id, amount + SimpleBankAccount.ATM_TRANSACTION_FEE);
    }

    protected boolean checkUser(final int id) {
        return this.getAccountHolder().getUserID() == id;
    }

    protected void incrementTransactions() {
        this.transactions++;
    }

    protected void resetTransactions() {
        this.transactions = 0;
    }

    protected void transactionOp(final int id, final double amount) {
        if (checkUser(id)) {
            this.balance += amount;
            this.incrementTransactions();
        }
    }

    @Override
    public final void withdraw(int id, double amount) {
        if (isWithDrawAllowed(amount)) {
            setBalance(getBalance() - amount);
        }
    }

    protected abstract boolean isWithDrawAllowed(double parameter);

    protected abstract double computeFee();
}
