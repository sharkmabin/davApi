package com.mabin.dav.application;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.mabin.dav.framework.model.base.BaseApplication;

public class HomeApplication extends BaseApplication {

    private boolean isDebugARouter = true;

    @Override
    public void onCreate() {
        super.onCreate();
        if (isDebugARouter) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
}
