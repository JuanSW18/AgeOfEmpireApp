package com.example.ageofempires.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Structure {

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
    @SerializedName("cost")
    @Expose
    private Cost cost;
    @SerializedName("build_time")
    @Expose
    private double buildTime;
    @SerializedName("hit_points")
    @Expose
    private double hitPoints;
    @SerializedName("line_of_sight")
    @Expose
    private double lineOfSight;
    @SerializedName("armor")
    @Expose
    private String armor;
    @SerializedName("range")
    @Expose
    private String range;
    @SerializedName("reload_time")
    @Expose
    private double reloadTime;
    @SerializedName("attack")
    @Expose
    private double attack;
    @SerializedName("special")
    @Expose
    private List<String> special = null;

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

    public double getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(double hitPoints) {
        this.hitPoints = hitPoints;
    }

    public double getLineOfSight() {
        return lineOfSight;
    }

    public void setLineOfSight(double lineOfSight) {
        this.lineOfSight = lineOfSight;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public double getReloadTime() {
        return reloadTime;
    }

    public void setReloadTime(double reloadTime) {
        this.reloadTime = reloadTime;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public List<String> getSpecial() {
        return special;
    }

    public void setSpecial(List<String> special) {
        this.special = special;
    }

}
