package com.example.ageofempires.presentation.unit;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ageofempires.R;
import com.example.ageofempires.adapter.UnitAdapter;
import com.example.ageofempires.data.models.MemoryCache;
import com.example.ageofempires.data.models.Unit;
import com.example.ageofempires.interfaces.FragmentCallback;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class UnitFragment extends Fragment implements UnitContract.View {

    private FragmentCallback fragmentCallback;
    private UnitPresenter presenter;
    private UnitAdapter unitAdapter;
    RecyclerView recyclerUnit;

    public UnitFragment(FragmentCallback fragmentCallback) {
        this.fragmentCallback = fragmentCallback;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if( presenter == null ){
            presenter = new UnitPresenter();
            getPresenter().onViewAttach(UnitFragment.this);
        }
    }

    private UnitContract.Presenter getPresenter(){
        return presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_unit, container, false);

        recyclerUnit = view.findViewById(R.id.recyclerUnit);

        if( MemoryCache.getUnitList() == null ){
            getPresenter().getUnitList();
        }else {
            Log.d("MEMORY_CACHE", "using unit list");
            setUnitList(MemoryCache.getUnitList());
        }

        return view;
    }

    @Override
    public void setUnitList(List<Unit> list) {
        unitAdapter = new UnitAdapter(getContext(), list);
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
