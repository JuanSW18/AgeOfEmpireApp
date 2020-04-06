package com.example.ageofempires.presentation.unit;

import com.example.ageofempires.data.models.Unit;

import java.util.List;

public class UnitContract {

    interface Presenter{
        void onViewDettach();
        void onViewAttach(UnitContract.View view);
        void getUnitList();
    }

    interface View{
        void setUnitList(List<Unit> list);
        void showLoadingDialog();
        void hideLoadingDialog();
    }
}
