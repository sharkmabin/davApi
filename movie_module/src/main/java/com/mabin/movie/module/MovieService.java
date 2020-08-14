package com.mabin.movie.module;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.mabin.router.model.RouterPath;
import com.mabin.router.model.provider.IMovieProvider;

@Route(path = RouterPath.ROUTER_PATH_TO_MOVIE_SERVICE, name = "视频")
public class MovieService implements IMovieProvider {
    @Override
    public Fragment movieInstance(Activity activity, Bundle bundle) {
        return (Fragment) ARouter.getInstance().build("/movie/fragment").navigation();
    }

    @Override
    public void init(Context context) {

    }
}
