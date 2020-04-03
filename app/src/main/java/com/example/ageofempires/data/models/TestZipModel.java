package com.example.ageofempires.data.models;

import io.reactivex.functions.BiFunction;

public class TestZipModel {

    private CivilizationResponse civilizationResponse;
    private UnitsResponse unitsResponse;

    public TestZipModel() {
    }

    public CivilizationResponse getCivilizationResponse() {
        return civilizationResponse;
    }

    public void setCivilizationResponse(CivilizationResponse civilizationResponse) {
        this.civilizationResponse = civilizationResponse;
    }

    public UnitsResponse getUnitsResponse() {
        return unitsResponse;
    }

    public void setUnitsResponse(UnitsResponse unitsResponse) {
        this.unitsResponse = unitsResponse;
    }
}
