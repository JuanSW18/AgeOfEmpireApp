package com.example.ageofempires.presentation.technology;

import com.example.ageofempires.data.models.Technology;

import java.util.List;

public class TechnologyContract {

    interface Presenter{
        void onViewDettach();
        void onViewAttach(TechnologyContract.View view);
        void getTechnologyList();
    }

    interface View{
        void setTechnologyList(List<Technology> list);
        void showLoadingDialog();
        void hideLoadingDialog();
    }

}
