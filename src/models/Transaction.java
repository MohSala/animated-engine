package models;

import java.time.LocalDateTime;

public class Transaction {
    private Wallet sender;
    private Wallet receiver;
    private LocalDateTime transactionDate;
    private double amount;
    private int receiverTag;
    private Status status;

    public Wallet getSender() {
        return sender;
    }

    public void setSender(Wallet sender) {
        this.sender = sender;
    }

    public Wallet getReceiver() {
        return receiver;
    }

    public void setReceiver(Wallet receiver) {
        this.receiver = receiver;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getReceiverTag() {
        return receiverTag;
    }

    public void setReceiverTag(int receiverTag) {
        this.receiverTag = receiverTag;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Transaction(double amount, Wallet sender, Wallet receiver,
                       LocalDateTime transactionDate,
                       int receiverTag, Status status
    ) {
        this.sender = sender;
        this.receiver = receiver;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.receiverTag = receiverTag;
        this.status = status;
    }
}
