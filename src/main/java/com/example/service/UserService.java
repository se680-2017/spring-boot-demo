package com.example.service;


import com.example.dao.UserDao;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Eric on 3/17/2017.
 */

@Service
public class UserService{

    @Autowired
    private UserDao userDao;

    public Collection<User> getAllUsers(){

        return userDao.getAllUsers();
    }

    public User getUserById(int id){

        return userDao.getUserById(id);
    }

    public void removeUserById(int id){

        userDao.removeUserById(id);
    }
    public void updateUser(User user){

        userDao.updateUser(user);
    }

    public void insertUser(User user){

        userDao.insertUser(user);
    }
}
