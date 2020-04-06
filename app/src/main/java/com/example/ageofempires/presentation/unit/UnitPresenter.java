package com.example.ageofempires.presentation.unit;

import android.util.Log;

import com.example.ageofempires.data.models.MemoryCache;
import com.example.ageofempires.data.models.UnitsResponse;
import com.example.ageofempires.data.repository.remote.Service;
import com.example.ageofempires.data.repository.remote.request.GetRequest;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UnitPresenter implements UnitContract.Presenter {

    private UnitContract.View view;

    public UnitPresenter() {
    }

    public UnitContract.View getView() {
        return view;
    }

    @Override
    public void onViewDettach() {
        this.view = null;
    }

    @Override
    public void onViewAttach(UnitContract.View view) {
        this.view = view;
    }

    private boolean isAttached() {
        return getView() != null;
    }

    @Override
    public void getUnitList() {
        if( isAttached() ){
            getView().showLoadingDialog();
        }
        GetRequest getRequest = Service.getInstance(GetRequest.class);
        getRequest.getUnits()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleObserver<UnitsResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(UnitsResponse unitsResponse) {
                        if( isAttached() ){
                            Log.d("** CALLING_SERVICE **", "unit");
                            getView().setUnitList(unitsResponse.getUnits());
                            MemoryCache.setUnitList(unitsResponse.getUnits());
                            getView().hideLoadingDialog();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
