package com.example.ageofempires.presentation.technology;

import com.example.ageofempires.data.models.TechnologyResponse;
import com.example.ageofempires.data.repository.remote.Service;
import com.example.ageofempires.data.repository.remote.request.GetRequest;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TechnologyPresenter implements TechnologyContract.Presenter {

    private TechnologyContract.View view;

    public TechnologyPresenter() {
    }

    public TechnologyContract.View getView() {
        return view;
    }

    @Override
    public void onViewDettach() {
        this.view = null;
    }

    @Override
    public void onViewAttach(TechnologyContract.View view) {
        this.view = view;
    }

    private boolean isAttached() {
        return getView() != null;
    }

    @Override
    public void getTechnologyList() {
        if( isAttached() ){
            getView().showLoadingDialog();
        }
        GetRequest getRequest = Service.getInstance(GetRequest.class);
        getRequest.getTechnologies()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleObserver<TechnologyResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(TechnologyResponse technologyResponse) {
                        if ( isAttached() ){
                            getView().setTechnologyList(technologyResponse.getTechnologies());
                            getView().hideLoadingDialog();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
