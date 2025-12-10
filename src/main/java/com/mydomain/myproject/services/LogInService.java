// Written by Laurina Madden
package com.mydomain.myproject.services;

// Other classes it has access to 
import com.mydomain.myproject.entities.LogIn;
//import com.mydomain.myproject.entities.User;
import com.mydomain.myproject.repositories.UserRepository;

// Imports
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
public class LogInService {

    

    //Declares field to hold the repository 
    private final UserRepository userRepository;

    //The constructor 
    public LogInService (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    
    // Declares and initialises new BCrypt encoder for a password - 16 is the strength of encoding
    //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);

    
    public ResponseEntity<?> loginUser(LogIn user) {
        
        System.out.println("Inside ResponseEntity<?>");
        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);

        // Does username exist
        if(userRepository.existsByUsername(user.getLoginUsername())){
        //if(userRepository.existsByUsername(loginUsername())){
            System.out.println("Inside log in else ifs");
            // Get user object by username
            userRepository.findByUsername(user.getLoginUsername());

            // Declares and initialises storedPassword so it can be used below in if statement
            //String storedPassword = userRepository.findByUsername(user.getLoginUsername()).getPassword();
            System.out.println("One step away from log in");
            // Does the stored password match the log in password?
            // example code: encoder.matches(loginPassword, stored_hash)
            //if(encoder.matches(user.getLoginUsername(), storedPassword)){
                // If here the log in should be confirmed 
                System.out.println("Log in successful");
            //}
            //else{
            //    return new ResponseEntity<>("Please try again.", HttpStatus.BAD_REQUEST);
            //}
        }
        else{
            // Username not found
            return new ResponseEntity<>("Please try again.", HttpStatus.BAD_REQUEST);
        }
        
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