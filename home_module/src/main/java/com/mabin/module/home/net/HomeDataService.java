package com.mabin.module.home.net;

import com.mabin.dav.common.model.BuildConfig;
import com.mabin.dav.common.model.base.BaseService;
import com.mabin.dav.common.model.net.DCallback;
import com.mabin.dav.common.model.net.ResponseMod;
import com.mabin.module.home.data.HostData;
import com.mabin.module.home.data.MovieData;
import com.orhanobut.logger.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeDataService extends BaseService {

    private HApiService mApiService;

    public HomeDataService() {
        super();
        mApiService = retrofit2.create(HApiService.class);
    }

    private static volatile HomeDataService homeDataService;

    public static HomeDataService getInstance() {
        if (homeDataService == null) {
            synchronized (HomeDataService.class) {
                if (homeDataService == null) {
                    homeDataService = new HomeDataService();
                }
            }
        }
        return homeDataService;
    }

    public void queryHostUrl(DCallback<HostData> dCallback) {
        Call<HostData> call = mApiService.profileHost(BuildConfig.API_JSON);
        call.enqueue(new Callback<HostData>() {
            @Override
            public void onResponse(Call<HostData> call, Response<HostData> response) {
                HostData data = response.body();
                if (data == null) {
                    Logger.d("data == null");
                    return;
                } else {
                    setHost(data.getHost());
                }
                dCallback.onSuccess(new ResponseMod<>(0, "Success", data));

            }

            @Override
            public void onFailure(Call<HostData> call, Throwable t) {
                dCallback.onFail(new ResponseMod<>(404, "" + t.getMessage(), null));
            }
        });
    }

    public void indexVedio(String vedioUrl, DCallback<MovieData> dCallback) {
        Call<MovieData> movieDataCall = mApiService.indexMovie(vedioUrl);
        movieDataCall.enqueue(new Callback<MovieData>() {
            @Override
            public void onResponse(Call<MovieData> call, Response<MovieData> response) {
                if (response.body() == null) {
                    dCallback.onFail(new ResponseMod<>(404, "response body = null", null));
                    return;
                }

                if (response.body().getCode() == 200) {
                    dCallback.onSuccess(new ResponseMod<>(0, "Success", response.body()));
                    return;
                }

                dCallback.onFail(new ResponseMod<>(response.body().getCode(), "" + response.message(), null));
            }

            @Override
            public void onFailure(Call<MovieData> call, Throwable t) {
                dCallback.onFail(new ResponseMod<>(404, "" + t.getMessage(), null));
            }
        });
    }
}
