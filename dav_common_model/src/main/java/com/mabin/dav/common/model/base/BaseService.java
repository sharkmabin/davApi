package com.mabin.dav.common.model.base;

import com.mabin.dav.common.model.BuildConfig;
import com.mabin.dav.common.model.net.NetClientManage;

import retrofit2.Retrofit;

public abstract class BaseService {


    protected Retrofit retrofit2;

    private String host = "" ;

    public BaseService() {
        super();
        retrofit2 = NetClientManage.getInstance().getRetrofit("https://gitee.com/");
    }

    public void setHost(String host) {
        this.host = host ;
        retrofit2 = NetClientManage.getInstance().getRetrofit(host);
    }

}
