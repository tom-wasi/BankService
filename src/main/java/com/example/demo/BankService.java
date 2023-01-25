package com.example.demo;

import ch.qos.logback.core.net.server.Client;
import org.springframework.stereotype.Component;

@Component
public class BankService {

    private UserStorage userStorage;

    private TransferStorage transferStorage;

    public BankService(UserStorage userStorage, TransferStorage transferStorage) {
        this.userStorage = userStorage;
        this.transferStorage = transferStorage;
    }

    public User findUserById(int id) {
        for (User user : userStorage.getUserList()) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User registerNewUser(int id, double balance) {
        if (id <= 0 || balance < 0) {
            System.out.println("Wrong attributes");
            return null;
        }

        if (findUserById(id) != null) {
            System.out.println("User with this id already exists you dumbass");
            return null;
        }
        User user = new User(id, balance);
        userStorage.getUserList().add(user);
        return user;
    }

    public Transfer transferRequest(int userId, double amount) {
        if (userId <= 0 || amount < 0) {
            System.out.println("Wrong attributes");
            return null;
        }

        if (findUserById(userId) == null) {
            System.out.println("No user in storage");
            return null;
        }
        TransferStatus checkEnum = TransferStatus.ACCEPTED;
        if (findUserById(userId).getBalance() < amount) {
            System.out.println("No cash on user");
            checkEnum = TransferStatus.DENIED;
        }

        User user = findUserById(userId);
        amount *= -1;
        Transfer transfer = new Transfer(10, userId, amount, user.getBalance() + amount, checkEnum);
        user.setBalance(user.getBalance() + amount);
        transferStorage.getTransferList().add(transfer);
        return transfer;
    }

    public Transfer putMoneyOnAccount(int userId, double amount) {
        if (userId <= 0 || amount < 0) {
            System.out.println("Wrong attributes");
            return null;
        }

        if (findUserById(userId) == null) {
            System.out.println("No user in storage");
            return null;
        }
        TransferStatus checkEnum = TransferStatus.ACCEPTED;

        User user = findUserById(userId);
        Transfer transfer = new Transfer(19, userId, amount, user.getBalance() + amount, checkEnum);
        user.setBalance(user.getBalance() + amount);
        transferStorage.getTransferList().add(transfer);
        return transfer;
    }

    public String readUserCredentials(int userId) {
        if (userId <= 0) {
            System.out.println("Wrong attributes");
            return null;
        }
        if (findUserById(userId) == null) {
            System.out.println("No user in storage");
            return null;
        }
        User user = findUserById(userId);
        return user.toString();
    }

}
