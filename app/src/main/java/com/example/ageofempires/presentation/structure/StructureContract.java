package com.example.ageofempires.presentation.structure;

import com.example.ageofempires.data.models.Structure;

import java.util.List;

public class StructureContract{

    interface Presenter{
        void onViewDettach();
        void onViewAttach(StructureContract.View view);
        void getStructureList();
    }

    interface View{
        void setStructureList(List<Structure> list);
        void showLoadingDialog();
        void hideLoadingDialog();
    }

}
