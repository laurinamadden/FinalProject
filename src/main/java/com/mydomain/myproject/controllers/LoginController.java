// Written by Laurina Madden

package com.mydomain.myproject.controllers;

//Imports other classes in this project
import com.mydomain.myproject.entities.User;
import com.mydomain.myproject.entities.LogIn;
import com.mydomain.myproject.services.UserService;
import com.mydomain.myproject.services.LogInService;


//Imports - Annotations
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
// ("/login") comes from logIn/index.html action="/login"
@RequestMapping("/login")
public class LoginController {
    
    // Controller should only have access to the service class who then talks to the repository class 
    // Instantiate an object: UserService added back this time due to logic client->Controller->Service->Repository->service->controller->client. Codecademy AI says it should follow "the separation of concerns principle"
    private final LogInService logInService;
    // Constructor 
    public LoginController(LogInService logInService) {
        this.logInService = logInService;
    }
    
    @PostMapping("/login")
    //public ResponseEntity<?> logIn(@RequestBody User user) {
    public ResponseEntity<?> logIn(@RequestBody LogIn user) {
        return logInService.loginUser(user); 
    }
    
}
