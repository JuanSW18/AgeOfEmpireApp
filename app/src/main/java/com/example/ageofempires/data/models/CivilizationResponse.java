package com.example.ageofempires.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CivilizationResponse {

    @SerializedName("civilizations")
    @Expose
    private List<Civilization> civilizations = null;

    public List<Civilization> getCivilizations() {
        return civilizations;
    }

    public void setCivilizations(List<Civilization> civilizations) {
        this.civilizations = civilizations;
    }

}
