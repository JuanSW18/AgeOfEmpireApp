package com.example.ageofempires.presentation.civilization;

import android.util.Log;

import com.example.ageofempires.data.models.CivilizationResponse;
import com.example.ageofempires.data.models.MemoryCache;
import com.example.ageofempires.data.models.TestZipModel;
import com.example.ageofempires.data.models.UnitsResponse;
import com.example.ageofempires.data.repository.remote.Service;
import com.example.ageofempires.data.repository.remote.request.GetRequest;

import androidx.annotation.Nullable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;

public class CivilizationPresenter implements CivilizationContract.Presenter {

    private CivilizationContract.View view;

    public CivilizationPresenter() {
    }

    @Nullable
    private CivilizationContract.View getView() {
        return view;
    }

    @Override
    public void onViewDettach() {
        this.view = null;
    }

    @Override
    public void onViewAttach(CivilizationContract.View view) {
        this.view = view;
    }

    private boolean isAttached() {
        return getView() != null;
    }


    @Override
    public void getCivilizationList() {
        if( isAttached() ){
            getView().showLoadingDialog();
        }
        GetRequest getRequest = Service.getInstance(GetRequest.class);
        getRequest.getCivilications()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleObserver<CivilizationResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(CivilizationResponse civilizationResponse) {
                        if( isAttached() ){
                            Log.d("** CALLING_SERVICE **", "civilization");
                            MemoryCache.setCivilizationList(civilizationResponse.getCivilizations());
                            getView().setCivilizationList(civilizationResponse.getCivilizations());
                            getView().hideLoadingDialog();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    @Override
    public void getZipList() {
        if( isAttached() ){
            getView().showLoadingDialog();
        }
        GetRequest getRequest = Service.getInstance(GetRequest.class);

        Single<CivilizationResponse> civilizationSingle = getRequest.getCivilications();
        Single<UnitsResponse> unitsResponseSingle = getRequest.getUnits();

        Single.zip(civilizationSingle, unitsResponseSingle, new BiFunction<CivilizationResponse, UnitsResponse, TestZipModel>() {
            @Override
            public TestZipModel apply(CivilizationResponse civilizationResponse, UnitsResponse unitsResponse) throws Exception {
                TestZipModel testZip = new TestZipModel();
                testZip.setCivilizationResponse(civilizationResponse);
                testZip.setUnitsResponse(unitsResponse);
                return testZip;
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleObserver<TestZipModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(TestZipModel testZipModel) {
                        if( isAttached() ){
                            getView().setZipList(testZipModel.getCivilizationResponse().getCivilizations(), testZipModel.getUnitsResponse().getUnits());
                            Log.d("** END **", "SUCCESSFUL");
                            getView().hideLoadingDialog();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("** END **", "ERROR");
                        e.printStackTrace();
                    }
                });
    }
}
