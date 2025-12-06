/* 
Writen by Laurina Madden
While tryiing to make the log in feature work
Purpose of this class is to hold data and can have logic in it too 
and to provide the headings for a database 
This is the Entity Class for log in - 
06.12.2025 - but its bad practice so dont temp save log in details as my plan was to temp hold on to the plane details so they could be compared 
*/

// Package
package com.mydomain.myproject.entities;
// Imports
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "LogIn")
public class LogIn { //Auto created when I created the class 
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "USERNAME")
    private String loginUsername;

    @Column(name = "PASSWORD")
    private String loginPassword;

    public LogIn() {
        // required by JPA and Spring  to stay empty
        // for frameworks
    }

    public LogIn(String loginUsername, String loginPassword) { 
        this.loginUsername = loginUsername;
        this.loginPassword = loginPassword;
    }

    // Getters
    public String getLoginUsername() {
        return loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    // Setters
    public void setLoginUsername(String newLoginUsername){
        this.loginUsername = newLoginUsername;
    }

    public void setLoginPassword(String newLoginPassword){
        this.loginPassword = newLoginPassword;
    }

} //Auto created when I created the class 
