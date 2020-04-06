package com.example.ageofempires.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TechnologyResponse {

    @SerializedName("technologies")
    @Expose
    private List<Technology> technologies = null;

    public List<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;
    }

}
