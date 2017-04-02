package com.example.controllers;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.Collection;

/**
 * Created by Eric on 1/23/2017.
 */

@Controller
@RestController
//@RequestMapping("/users")
public class GreetingController{

//    @RequestMapping("/greeting/{name}")
//    public String greeting(@RequestParam(value="name", required=false,
//            defaultValue="World") String name, Model model){
//
//        model.addAttribute("name", name);
//        return "greeting";
//    }

    @RequestMapping("/greeting/{name}")
    public String greeting(@RequestParam(value="name", required=false,
            defaultValue="World") String name, Model model){

        model.addAttribute("name", name);
        return "greeting";
    }



    @Autowired
    private UserService userService;


    @GetMapping("/users")
    //@RequestMapping(method = RequestMethod.GET)
    public Collection<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/login/{id}", method = RequestMethod.GET)
    public User getUserById (@PathVariable("id") int id){

        return userService.getUserById(id);
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public void deleteUserById (@PathVariable("id") int id){

        userService.removeUserById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@RequestBody User user){

        userService.updateUser(user);
    }

//    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void insertUser(@RequestBody User user){
//        userService.insertUser(user);
//    }


}
