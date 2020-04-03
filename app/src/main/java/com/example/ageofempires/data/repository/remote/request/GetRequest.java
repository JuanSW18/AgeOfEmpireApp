package com.example.ageofempires.data.repository.remote.request;

import com.example.ageofempires.data.models.CivilizationResponse;
import com.example.ageofempires.data.models.UnitsResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface GetRequest {

    @GET("civilizations")
    Single<CivilizationResponse> getCivilications();

    @GET("units")
    Single<UnitsResponse> getUnits();

    @GET("structures")
    Single<CivilizationResponse> getStructures();

    @GET("technologies")
    Single<CivilizationResponse> getTechnologies();

}
