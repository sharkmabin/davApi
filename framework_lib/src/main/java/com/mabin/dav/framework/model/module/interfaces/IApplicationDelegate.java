package com.mabin.dav.framework.model.module.interfaces;

import android.content.res.Configuration;

import java.util.Map;

public interface IApplicationDelegate {


    void onCreate();

    void enterBackground();

    void enterForeground();

    void receiveRemoteNotification(Map<String, String> var1);

    void onTerminate();

    void onConfigurationChanged(Configuration var1);

    void onLowMemory();

    void onTrimMemory(int var1);

}
