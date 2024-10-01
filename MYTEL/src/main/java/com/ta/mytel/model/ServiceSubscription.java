package com.ta.mytel.model;

import java.sql.Date;

public class ServiceSubscription {
    private int ServiceID;
    private int CustomerID;
    private int PlanID;
    private Date StartDate;
    private Date EndDate;
    private String Status;
    private int InvoiceID;
    private Date InvoiceDate;
    private int Amount;
    private boolean Paid;
    
    public ServiceSubscription() {}

    public ServiceSubscription(int serviceID, int customerID, int planID, Date startDate, Date endDate, String status,
                               int invoiceID, Date invoiceDate, int amount, boolean paid) {
        this.ServiceID = serviceID;
        this.CustomerID = customerID;
        this.PlanID = planID;
        this.StartDate = startDate;
        this.EndDate = endDate;
        this.Status = status;
        this.InvoiceID = invoiceID;
        this.InvoiceDate = invoiceDate;
        this.Amount = amount;
        this.Paid = paid;
    }

  
    public int getServiceID() {
        return ServiceID;
    }

    public void setServiceID(int serviceID) {
        this.ServiceID = serviceID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        this.CustomerID = customerID;
    }

    public int getPlanID() {
        return PlanID;
    }

    public void setPlanID(int planID) {
        this.PlanID = planID;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        this.StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        this.EndDate = endDate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    // Getters and Setters for Invoice Details
    public int getInvoiceID() {
        return InvoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.InvoiceID = invoiceID;
    }

    public Date getInvoiceDate() {
        return InvoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.InvoiceDate = invoiceDate;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        this.Amount = amount;
    }

    public boolean isPaid() {
        return Paid;
    }

    public void setPaid(boolean paid) {
        this.Paid = paid;
    }
}
