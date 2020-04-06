package com.example.ageofempires.presentation.structure;

import com.example.ageofempires.data.models.StructureResponse;
import com.example.ageofempires.data.repository.remote.Service;
import com.example.ageofempires.data.repository.remote.request.GetRequest;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class StructurePresenter implements StructureContract.Presenter {

    private StructureContract.View view;

    public StructurePresenter() {
    }

    public StructureContract.View getView() {
        return view;
    }

    @Override
    public void onViewDettach() {
        this.view = null;
    }

    @Override
    public void onViewAttach(StructureContract.View view) {
        this.view = view;
    }

    private boolean isAttached() {
        return getView() != null;
    }

    @Override
    public void getStructureList() {
        if( isAttached() ){
            getView().showLoadingDialog();
        }
        GetRequest getRequest = Service.getInstance(GetRequest.class);
        getRequest.getStructures()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleObserver<StructureResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(StructureResponse structureResponse) {
                        if( isAttached() ){
                            getView().setStructureList(structureResponse.getStructures());
                            getView().hideLoadingDialog();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

}
