package com.CSCE247;

public class Users {
	private String username;
	private String password;
    private String firstname;
    private String lastname;
    private String creditcard;
    private Boolean employee;

	public Users(String username, String password, String firstname, String lastname, String creditcard, Boolean employee) {
		this.username = username;
		this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.creditcard = creditcard;
        this.employee = employee;
    }

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
    
    public Boolean getEmployee() {
		return employee;
	}

	public void setEmployee(Boolean employee) {
		this.employee = employee;
	}
	
}
