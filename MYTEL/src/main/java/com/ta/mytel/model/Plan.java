package com.ta.mytel.model;

public class Plan {
    private int PlanID;
    private String PlanName;
    private int Price;
    private String Description;

 
    public Plan() {}

    public Plan(int planID, String planName, int price, String description) {
        this.PlanID = planID;
        this.PlanName = planName;
        this.Price = price;
        this.Description = description;
    }

    public int getPlanID() {
        return PlanID;
    }

    public void setPlanID(int planID) {
        this.PlanID = planID;
    }

    public String getPlanName() {
        return PlanName;
    }

    public void setPlanName(String planName) {
        this.PlanName = planName;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        this.Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

   
    }
