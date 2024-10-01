package com.ta.mytel.model;

public class Customer {
    private int CustomerID;
    private String Name;
    private String Email;
    private String PhoneNumber;
    private String City;

 
    public Customer() {}

    public Customer(int customerID, String name, String email, String phoneNumber, String city) {
        this.CustomerID = customerID;
        this.Name = name;
        this.Email = email;
        this.PhoneNumber = phoneNumber;
        this.City = city;
    }


    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        this.CustomerID = customerID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        this.City = city;
    }
}
