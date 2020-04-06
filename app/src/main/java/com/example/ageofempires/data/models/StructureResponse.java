package com.example.ageofempires.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StructureResponse {

    @SerializedName("structures")
    @Expose
    private List<Structure> structures = null;

    public List<Structure> getStructures() {
        return structures;
    }

    public void setStructures(List<Structure> structures) {
        this.structures = structures;
    }

}
