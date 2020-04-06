package com.example.ageofempires.data.models;

import java.util.List;

public class MemoryCache {

    private static List<Civilization> civilizationList;
    private static List<Unit> unitList;
    private static List<Structure> structureList;
    private static List<Technology> technologyList;

    public MemoryCache() {
    }

    public static List<Civilization> getCivilizationList() {
        return civilizationList;
    }

    public static List<Unit> getUnitList() {
        return unitList;
    }

    public static List<Structure> getStructureList() {
        return structureList;
    }

    public static List<Technology> getTechnologyList() {
        return technologyList;
    }

    public static void setCivilizationList(List<Civilization> civilizationList) {
        MemoryCache.civilizationList = civilizationList;
    }

    public static void setUnitList(List<Unit> unitList) {
        MemoryCache.unitList = unitList;
    }

    public static void setStructureList(List<Structure> structureList) {
        MemoryCache.structureList = structureList;
    }

    public static void setTechnologyList(List<Technology> technologyList) {
        MemoryCache.technologyList = technologyList;
    }
}
