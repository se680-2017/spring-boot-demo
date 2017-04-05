package com.example.controllers;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

/**
 * Created by Eric on 1/23/2017.
 */

@Controller

//@RestController
public class UserController{

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Collection<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUserById (@PathVariable("id") int id){
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public void deleteUserById (@PathVariable("id") int id){
        userService.removeUserById(id);
    }

    @RequestMapping(value = "/users/update", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @RequestMapping(value = "/users/insert",method = RequestMethod.POST)
    public void insertUser(@RequestBody User user){
        userService.insertUser(user);
    }


    @GetMapping("/collection")
    public String getAllUsersMv(Model model){
        Collection<User> userCollection = userService.getAllUsers();

        model.addAttribute("userCollection", userCollection);
        return "users";
    }


}
