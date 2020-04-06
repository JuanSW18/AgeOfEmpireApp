package com.example.ageofempires.presentation.technology;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ageofempires.R;
import com.example.ageofempires.adapter.TechnologyAdapter;
import com.example.ageofempires.data.models.MemoryCache;
import com.example.ageofempires.data.models.Technology;
import com.example.ageofempires.interfaces.FragmentCallback;

import java.util.List;


public class TechnologyFragment extends Fragment implements TechnologyContract.View {

    private TechnologyContract.Presenter presenter;
    private FragmentCallback fragmentCallback;
    private TechnologyAdapter technologyAdapter;
    private RecyclerView technologyRecycler;

    public TechnologyFragment(FragmentCallback fragmentCallback) {
        this.fragmentCallback = fragmentCallback;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if( presenter == null ){
            presenter = new TechnologyPresenter();
            getPresenter().onViewAttach(TechnologyFragment.this);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_technology, container, false);

        technologyRecycler = view.findViewById(R.id.recyclerTechnology);

        if( MemoryCache.getTechnologyList() == null ){
            getPresenter().getTechnologyList();
        }else {
            Log.d("MEMORY_CACHE", "using technology list");
            setTechnologyList(MemoryCache.getTechnologyList());
        }

        return view;
    }

    public TechnologyContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void setTechnologyList(List<Technology> list) {
        technologyAdapter = new TechnologyAdapter(getContext(), list);
        technologyRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        technologyRecycler.setAdapter(technologyAdapter);
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
