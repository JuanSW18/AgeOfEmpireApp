package com.example.ageofempires.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Unit {

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
    @SerializedName("created_in")
    @Expose
    private String createdIn;
    @SerializedName("cost")
    @Expose
    private Cost cost;
    @SerializedName("build_time")
    @Expose
    private double buildTime;
    @SerializedName("reload_time")
    @Expose
    private double reloadTime;
    @SerializedName("attack_delay")
    @Expose
    private double attackDelay;
    @SerializedName("movement_rate")
    @Expose
    private double movementRate;
    @SerializedName("line_of_sight")
    @Expose
    private double lineOfSight;
    @SerializedName("hit_points")
    @Expose
    private double hitPoints;
    @SerializedName("range")
    @Expose
    private String range;
    @SerializedName("attack")
    @Expose
    private double attack;
    @SerializedName("armor")
    @Expose
    private String armor;
    @SerializedName("attack_bonus")
    @Expose
    private List<String> attackBonus = null;
    @SerializedName("armor_bonus")
    @Expose
    private List<String> armorBonus = null;
    @SerializedName("search_radius")
    @Expose
    private double searchRadius;
    @SerializedName("accuracy")
    @Expose
    private String accuracy;
    @SerializedName("blast_radius")
    @Expose
    private double blastRadius;

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

    public String getCreatedIn() {
        return createdIn;
    }

    public void setCreatedIn(String createdIn) {
        this.createdIn = createdIn;
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

    public void setBuildTime(int buildTime) {
        this.buildTime = buildTime;
    }

    public double getReloadTime() {
        return reloadTime;
    }

    public void setReloadTime(int reloadTime) {
        this.reloadTime = reloadTime;
    }

    public double getAttackDelay() {
        return attackDelay;
    }

    public void setAttackDelay(int attackDelay) {
        this.attackDelay = attackDelay;
    }

    public double getMovementRate() {
        return movementRate;
    }

    public void setMovementRate(int movementRate) {
        this.movementRate = movementRate;
    }

    public double getLineOfSight() {
        return lineOfSight;
    }

    public void setLineOfSight(int lineOfSight) {
        this.lineOfSight = lineOfSight;
    }

    public double getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public List<String> getAttackBonus() {
        return attackBonus;
    }

    public void setAttackBonus(List<String> attackBonus) {
        this.attackBonus = attackBonus;
    }

    public List<String> getArmorBonus() {
        return armorBonus;
    }

    public void setArmorBonus(List<String> armorBonus) {
        this.armorBonus = armorBonus;
    }

    public double getSearchRadius() {
        return searchRadius;
    }

    public void setSearchRadius(int searchRadius) {
        this.searchRadius = searchRadius;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public double getBlastRadius() {
        return blastRadius;
    }

    public void setBlastRadius(int blastRadius) {
        this.blastRadius = blastRadius;
    }

}
