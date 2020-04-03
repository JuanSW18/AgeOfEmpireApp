package com.example.ageofempires.presentation.main;

import com.example.ageofempires.data.models.Civilization;
import com.example.ageofempires.data.models.CivilizationResponse;
import com.example.ageofempires.data.models.Unit;
import com.example.ageofempires.data.models.UnitsResponse;

import java.util.List;

public class HomeContract {

    interface Presenter{
        void onViewDettach();
        void onViewAttach(HomeContract.View view);
        void getCivilizationList();
        void getZipList();
    }

    interface View{
        void setCivilizationList(List<Civilization> list);
        void setZipList(List<Civilization> list1, List<Unit> list2);
    }

}