package com.example.david.medei.Main;

/**
 * Created by David on 5/28/2015.
 * business object Patient
 */
public class Patient {
    /**
     * first name
     * last name
     * email
     */
    private String firstName;
    private String lastName;
    private String email;

    public Patient(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
