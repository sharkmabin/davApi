package com.mabin.dav.common.model.net;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetClientManage {

  private static NetClientManage mNetClientManage;
  private OkHttpClient mOkHttpClient;

  private NetClientManage() {
    super();

    OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
    mOkHttpClient = httpBuilder.
        addInterceptor(new LoggingInterceptor())
        .readTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build();
  }

  public static NetClientManage getInstance() {
    if (mNetClientManage == null) {
      mNetClientManage = new NetClientManage();
    }
    return mNetClientManage;
  }

  public Retrofit getRetrofit(final String url) {

    return new Retrofit.Builder().baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .client(mOkHttpClient)
        .build();
  }



}
