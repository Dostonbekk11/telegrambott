package org.example.Servis;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class  User {
    private String username;
    private double balance;
    private double receivedAmount;
    private int offerCount;

    public User(String username, double balance) {
        this.username = username;
        this.balance = balance;
        this.receivedAmount = 0;
        this.offerCount = 0;
    }


    public void increaseBalance(double amount) {
        this.balance += amount;
    }

    public void decreaseBalance(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
        } else {
            System.out.println("Balans yetarli emas!");
        }
    }

    public void increaseReceivedAmount(double amount) {
        this.receivedAmount += amount;
    }

    public void increaseOfferCount() {
        this.offerCount++;
    }


    public double getAmount() {
        return 0;
    }
}
