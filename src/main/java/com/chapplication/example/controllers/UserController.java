package com.chapplication.example.controllers;

import com.chapplication.example.objects.UserObject;
import com.chapplication.example.servicerepo.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/userObject/", method = RequestMethod.GET)
    public ResponseEntity<List<UserObject>> listAllUsers() {
        List<UserObject> users = userService.findAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<List<UserObject>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<UserObject>>(users, HttpStatus.OK);
    }

}
