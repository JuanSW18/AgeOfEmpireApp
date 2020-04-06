package com.example.ageofempires.presentation.civilization;

import com.example.ageofempires.data.models.Civilization;
import com.example.ageofempires.data.models.Unit;

import java.util.List;

public class CivilizationContract {

    interface Presenter{
        void onViewDettach();
        void onViewAttach(CivilizationContract.View view);
        void getCivilizationList();
        void getZipList();
    }

    interface View{
        void setCivilizationList(List<Civilization> list);
        void setZipList(List<Civilization> list1, List<Unit> list2);
        void showLoadingDialog();
        void hideLoadingDialog();
    }

}
