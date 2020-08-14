package com.mabin.dav.photo.module;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.mabin.router.model.RouterPath;
import com.mabin.router.model.provider.IPhotoProvider;

@Route(path = RouterPath.ROUTER_PATH_TO_PHOTO_SERVICE, name = "美图")
public class PhotoService implements IPhotoProvider {
    @Override
    public Fragment photoInstance(Activity activity, Bundle bundle) {
        return (Fragment) ARouter.getInstance().build("/photo/fragment").navigation();
    }

    @Override
    public void init(Context context) {

    }
}
