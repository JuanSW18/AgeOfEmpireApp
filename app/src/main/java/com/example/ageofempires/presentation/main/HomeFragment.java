package com.example.ageofempires.presentation.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ageofempires.R;
import com.example.ageofempires.adapter.CivilizationAdapter;
import com.example.ageofempires.adapter.UnitAdapter;
import com.example.ageofempires.data.models.Civilization;
import com.example.ageofempires.data.models.CivilizationResponse;
import com.example.ageofempires.data.models.TestZipModel;
import com.example.ageofempires.data.models.Unit;
import com.example.ageofempires.data.models.UnitsResponse;
import com.example.ageofempires.data.repository.remote.Service;
import com.example.ageofempires.data.repository.remote.request.GetRequest;
import com.example.ageofempires.interfaces.FragmentCallback;

import java.util.List;

public class HomeFragment extends Fragment implements HomeContract.View{

    private FragmentCallback fragmentCallback;
    private HomePresenter presenter;
    private CivilizationAdapter civilizationAdapter;
    RecyclerView recyclerCivilization;
    RecyclerView recyclerUnit;

    public HomeFragment(FragmentCallback fragmentCallback) {
        this.fragmentCallback = fragmentCallback;
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if( presenter == null ){
            presenter = new HomePresenter();
            getPresenter().onViewAttach(HomeFragment.this);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerCivilization = view.findViewById(R.id.recyclerCivilization);
        recyclerUnit = view.findViewById(R.id.recyclerUnit);

//        getPresenter().getCivilizationList();
        getPresenter().getZipList();
        return view;
    }

    private HomeContract.Presenter getPresenter(){
        return presenter;
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

        UnitAdapter unitAdapter = new UnitAdapter(getContext(), list2);
        recyclerUnit.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerUnit.setAdapter(unitAdapter);
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
