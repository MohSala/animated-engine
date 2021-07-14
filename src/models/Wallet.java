package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Wallet implements Serializable {
    private double amount;
    private Customer customer;
    private List<Transaction> transactions;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions.addAll(transactions);
    }

    public Wallet(double amount, Customer customer) {
        this.amount = amount;
        this.customer = customer;
        this.transactions = new ArrayList<>();
    }
}
