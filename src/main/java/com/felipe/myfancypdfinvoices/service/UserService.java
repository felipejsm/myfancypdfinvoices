package com.felipe.myfancypdfinvoices.service;

import com.felipe.myfancypdfinvoices.model.User;

import java.util.UUID;

public class UserService {

    public User findById(String id) {
        String randomName = UUID.randomUUID().toString();
        return new User(id, randomName);
    }
}
