package com.mydomain.myproject.controllers;

//Imports other classes in this project
import com.mydomain.myproject.entities.User;
import com.mydomain.myproject.entities.LogIn;

//Imports - Annotations
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
// ("/login") comes from 
@RequestMapping("/login")
public class LoginController {
    
}
