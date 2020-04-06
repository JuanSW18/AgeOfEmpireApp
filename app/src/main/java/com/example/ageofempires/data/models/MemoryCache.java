package com.example.ageofempires.data.models;

import java.util.List;

public class MemoryCache {

    private List<Civilization> civilizationList;
    private List<Unit> unitList;
    private List<Structure> structureList;
    private List<Technology> technologyList;

    public MemoryCache() {
    }

    public List<Civilization> getCivilizationList() {
        return civilizationList;
    }

    public void setCivilizationList(List<Civilization> civilizationList) {
        this.civilizationList = civilizationList;
    }

    public List<Unit> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<Unit> unitList) {
        this.unitList = unitList;
    }

    public List<Structure> getStructureList() {
        return structureList;
    }

    public void setStructureList(List<Structure> structureList) {
        this.structureList = structureList;
    }

    public List<Technology> getTechnologyList() {
        return technologyList;
    }

    public void setTechnologyList(List<Technology> technologyList) {
        this.technologyList = technologyList;
    }
}
