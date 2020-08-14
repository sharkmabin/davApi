package com.mabin.module.home;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.mabin.router.model.RouterPath;
import com.mabin.router.model.provider.IHomeProvider;

@Route(path = RouterPath.ROUTER_PATH_TO_HOME_SERVICE, name = "首页")
public class HomeService implements IHomeProvider {

    @Override
    public Fragment homeInstance(Activity activity, Bundle bundle) {
        return (Fragment) ARouter.getInstance().build("/home/fragment").navigation();
    }

    @Override
    public void init(Context context) {

    }
}
