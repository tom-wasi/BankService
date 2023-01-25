package com.example.demo;

public class Transfer {
    int id;
    int userId;
    double amountSend;
    double newBalance;
    TransferStatus transferStatus;


    public Transfer(int id, int userId, double amountSend, double newBalance, TransferStatus transferStatus) {
        this.id = id;
        this.userId = userId;
        this.amountSend = amountSend;
        this.newBalance = newBalance;
        this.transferStatus = transferStatus;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getAmountSend() {
        return amountSend;
    }

    public void setAmountSend(double amountSend) {
        this.amountSend = amountSend;
    }

    public double getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(double newBalance) {
        this.newBalance = newBalance;
    }

    public TransferStatus getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(TransferStatus transferStatus) {
        this.transferStatus = transferStatus;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "id=" + id +
                ", userId=" + userId +
                ", amountSend=" + amountSend +
                ", newBalance=" + newBalance +
                ", transferStatus=" + transferStatus +
                '}';
    }
}
