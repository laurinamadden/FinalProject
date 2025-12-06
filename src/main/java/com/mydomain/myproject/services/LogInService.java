// Written by Laurina Madden
package com.mydomain.myproject.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mydomain.myproject.entities.LogIn;
import com.mydomain.myproject.entities.User;


public class LogInService {

    public ResponseEntity<?> loginUser(LogIn user) {
        return new ResponseEntity<>("Please try again.", HttpStatus.BAD_REQUEST);
    }

}



/*
// Class created and written by Laurina Madden

import java.util.HashMap;
import java.util.Map;


public class LogInService {
    

    // In-memory storage for registered users (username -> password)
    private Map<String, String> registeredUsers = new HashMap<>();

    // Register a new user
    public boolean register(String username, String password) {
        if (registeredUsers.containsKey(username)) {
            System.out.println("Username already exists.");
            return false;
        }
        registeredUsers.put(username, password);
        System.out.println("Registration successful.");
        return true;
    }

    // Log in a user
    public boolean login(String username, String password) {
        if (!registeredUsers.containsKey(username)) {
            System.out.println("Username not found.");
            return false;
        }
        if (registeredUsers.get(username).equals(password)) {
            System.out.println("Login successful.");
            return true;
        } else {
            System.out.println("Incorrect password.");
            return false;
        }
    }

    // For demonstration purposes
    public static void main(String[] args) {
        LogInService service = new LogInService();
        service.register("user1", "password123");
        service.login("user1", "password123"); // Should print "Login successful."
        service.login("user1", "wrongpassword"); // Should print "Incorrect password."
        service.login("user2", "password123"); // Should print "Username not found."
    }
}
/*
How it works:
register(): Adds a new user if the username isn’t already taken.
login(): Checks if the username exists and if the password matches.
main(): Demonstrates registration and login attempts.
If you want to learn more about Java or building authentication systems, Codecademy has some great resources. Would you like recommendations for Java courses or projects?
*/