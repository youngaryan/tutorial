package com.javagram.javagram;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {
    @NotBlank(message = "First name must not be blank.")
    @Size(min = 3, message = "First Name Must be Longer than 3 charachters.")
    private String firstName;

    @NotBlank(message = "Last name must not be blank.")
    @Size(min = 3, message = "Last Name Must be Longer than 3 charachters.")
    private String lastName;

    @NotBlank(message = "Username must not be blank.")
    @Size(min = 6, message = "Username Must be Longer than 6 charachters.")
    @Username(message = "Cannot contain special characters or uppercase characters ")
    private String userName;

    @Email(message = "Email is not in a correct form.")
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @Age(message = "You must be oler than 18.")
    private Date dateOfBirth;

    public User(String firstName, String lastName, String userName, String email, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public User() {
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
}
