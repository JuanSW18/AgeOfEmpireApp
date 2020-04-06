package com.example.ageofempires.presentation.civilization;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ageofempires.R;
import com.example.ageofempires.adapter.CivilizationAdapter;
import com.example.ageofempires.data.models.Civilization;
import com.example.ageofempires.data.models.Unit;
import com.example.ageofempires.interfaces.FragmentCallback;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CivilizationFragment extends Fragment implements CivilizationContract.View{

    private FragmentCallback fragmentCallback;
    private CivilizationPresenter presenter;
    private CivilizationAdapter civilizationAdapter;
    RecyclerView recyclerCivilization;

    public CivilizationFragment(FragmentCallback fragmentCallback) {
        this.fragmentCallback = fragmentCallback;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if( presenter == null ){
            presenter = new CivilizationPresenter();
            getPresenter().onViewAttach(CivilizationFragment.this);
        }
    }

    private CivilizationContract.Presenter getPresenter(){
        return presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_civlization, container, false);

        recyclerCivilization = view.findViewById(R.id.recyclerCivilization);
//        recyclerUnit = view.findViewById(R.id.recyclerUnit);

        getPresenter().getCivilizationList();
//        getPresenter().getZipList();
        return view;
    }

    @Override
    public void setCivilizationList(List<Civilization> list) {
        CivilizationAdapter civilizationAdapter = new CivilizationAdapter(getContext(), list);
        recyclerCivilization.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerCivilization.setAdapter(civilizationAdapter);
    }

    @Override
    public void setZipList(List<Civilization> list1, List<Unit> list2) {
        CivilizationAdapter civilizationAdapter = new CivilizationAdapter(getContext(), list1);
        recyclerCivilization.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerCivilization.setAdapter(civilizationAdapter);

//        UnitAdapter unitAdapter = new UnitAdapter(getContext(), list2);
//        recyclerUnit.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerUnit.setAdapter(unitAdapter);
    }

    @Override
    public void showLoadingDialog() {
        fragmentCallback.showLoadingDialog();
    }

    @Override
    public void hideLoadingDialog() {
        fragmentCallback.hideLoadingDialog();
    }

}
