package com.example.ageofempires.presentation.structure;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ageofempires.R;
import com.example.ageofempires.adapter.StructureAdapter;
import com.example.ageofempires.data.models.Structure;
import com.example.ageofempires.interfaces.FragmentCallback;

import java.util.List;

public class StructureFragment extends Fragment implements StructureContract.View {

    private StructureContract.Presenter presenter;
    private FragmentCallback fragmentCallback;
    private RecyclerView structureRecycler;
    private StructureAdapter structureAdapter;

    public StructureFragment(FragmentCallback fragmentCallback) {
        this.fragmentCallback = fragmentCallback;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ( presenter == null ){
            presenter = new StructurePresenter();
            getPresenter().onViewAttach(StructureFragment.this);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_structure, container, false);

        structureRecycler = view.findViewById(R.id.recyclerStructure);

        getPresenter().getStructureList();

        return view;
    }

    public StructureContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void setStructureList(List<Structure> list) {
        structureAdapter = new StructureAdapter(getContext(), list);
        structureRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        structureRecycler.setAdapter(structureAdapter);
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
