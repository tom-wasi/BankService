package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserStorage {
    private List<User> userList= new ArrayList<>();

    public UserStorage() {
        userList.add(new User(1, 10000));
        userList.add(new User(2, 10000));
        userList.add(new User(3, 10000));
    }

    public List<User> getUserList() {
        return userList;
    }

}
