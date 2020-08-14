package com.mabin.movie.module;

import android.content.res.Configuration;

import com.mabin.annotations.EFModuleAnnotation;
import com.mabin.dav.framework.model.DLogger;
import com.mabin.dav.framework.model.module.interfaces.IApplicationDelegate;

import java.util.Map;

@EFModuleAnnotation(moduleName = "movie",delegateName = "com.mabin.movie.module.MovieApplicationDelegate")
public class MovieApplicationDelegate implements IApplicationDelegate {


    private static final String TAG = "MovieApplicationDelegate";

    @Override
    public void onCreate() {
        DLogger.d(TAG, "*------------------onCreate()---------------->");
    }

    @Override
    public void enterBackground() {
        DLogger.d(TAG, "*------------------enterBackground()---------------->");
    }

    @Override
    public void enterForeground() {
        DLogger.d(TAG, "*------------------enterForeground()---------------->");
    }

    @Override
    public void receiveRemoteNotification(Map<String, String> message) {
        DLogger.d(TAG, "receiveRemoteNotification msg = " + message);
    }

    @Override
    public void onTerminate() {
        DLogger.d(TAG, "*------------------onTerminate()---------------->");
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
        DLogger.d(TAG, "*------------------onConfigurationChanged()---------------->");
    }

    @Override
    public void onLowMemory() {
        DLogger.d(TAG, "*------------------onLowMemory()---------------->");
    }

    @Override
    public void onTrimMemory(int var1) {
        DLogger.d(TAG, "*------------------onTrimMemory()---------------->");
    }


}
