package com.example.ageofempires.data.repository.remote;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {

    private static final String BASE_URL = "https://age-of-empires-2-api.herokuapp.com/api/v1/";
    private static Retrofit retrofit = null;

    private static Retrofit getServiceInstance(){

        if( retrofit == null ){
            /*HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);*/
            OkHttpClient client = new OkHttpClient.Builder().build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build();
        }

        return retrofit;
    }

    public static <S> S getInstance(Class<S> serviceClass){
        return getServiceInstance().create(serviceClass);
    }

}
