package com.example.ageofempires.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Technology {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("expansion")
    @Expose
    private String expansion;
    @SerializedName("age")
    @Expose
    private String age;
    @SerializedName("develops_in")
    @Expose
    private String developsIn;
    @SerializedName("cost")
    @Expose
    private Cost cost;
    @SerializedName("build_time")
    @Expose
    private double buildTime;
    @SerializedName("applies_to")
    @Expose
    private List<String> appliesTo = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpansion() {
        return expansion;
    }

    public void setExpansion(String expansion) {
        this.expansion = expansion;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDevelopsIn() {
        return developsIn;
    }

    public void setDevelopsIn(String developsIn) {
        this.developsIn = developsIn;
    }

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    public double getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(double buildTime) {
        this.buildTime = buildTime;
    }

    public List<String> getAppliesTo() {
        return appliesTo;
    }

    public void setAppliesTo(List<String> appliesTo) {
        this.appliesTo = appliesTo;
    }


}
