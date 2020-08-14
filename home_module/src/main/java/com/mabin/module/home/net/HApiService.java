package com.mabin.module.home.net;

import com.mabin.module.home.data.HostData;
import com.mabin.module.home.data.MovieData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface HApiService {

    @GET
    Call<HostData> profileHost(@Url String url);

    @GET
    Call<MovieData> indexMovie(@Url String url);
}
