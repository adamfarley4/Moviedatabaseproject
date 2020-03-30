package com.CSCE247;

public class Users {
    private String firstname;
    private String lastname;
    private String creditcard;

    public Users(String firstname, String lastname, String creditcard) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.creditcard = creditcard;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCreditcard() {
        return creditcard;
    }

    public void setCreditcard(String creditcard) {
        this.creditcard = creditcard;
    }
}
