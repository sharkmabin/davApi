package com.mabin.dav.module.main.main.views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.alibaba.android.arouter.launcher.ARouter;
import com.mabin.dav.common.model.base.BaseFragment;
import com.mabin.dav.common.model.connect.FragmentOperateCallBack;
import com.mabin.dav.common.model.utils.ResourceUtil;
import com.mabin.router.model.RouterPath;
import com.mabin.router.model.provider.IHomeProvider;
import com.mabin.router.model.provider.IMovieProvider;
import com.mabin.router.model.provider.IPhotoProvider;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, FragmentOperateCallBack {

    private BottomNavigationView bottomNavigationView = null;

    private BaseFragment
            homeFragment,
            movieFragment,
            photoFragment;

    private List<BaseFragment> mFragments = new ArrayList<>();

    private BaseFragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ResourceUtil.getLayoutId("main_activity"));

        bottomNavigationView = findViewById(ResourceUtil.getId("nav_view"));
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        try {
            IHomeProvider homeService = (IHomeProvider) ARouter.getInstance().build(RouterPath.ROUTER_PATH_TO_HOME_SERVICE).navigation();
            if (homeService != null) {
                homeFragment = (BaseFragment) homeService.homeInstance(MainActivity.this, null);
                Bundle bundle = new Bundle();
                bundle.putString("title", "home 1 module");
                homeFragment.setArguments(bundle);
                mFragments.add(homeFragment);
            }
            IMovieProvider movieService = (IMovieProvider) ARouter.getInstance().build(RouterPath.ROUTER_PATH_TO_MOVIE_SERVICE).navigation();
            if (movieService != null) {
                movieFragment = (BaseFragment) movieService.movieInstance(MainActivity.this, null);
                Bundle bundle = new Bundle();
                bundle.putString("title", "home 2 module");
                movieFragment.setArguments(bundle);
                mFragments.add(movieFragment);
            }
            IPhotoProvider photoService = (IPhotoProvider) ARouter.getInstance().build(RouterPath.ROUTER_PATH_TO_PHOTO_SERVICE).navigation();
            if (photoService != null) {
                photoFragment = (BaseFragment) photoService.photoInstance(MainActivity.this, null);
                Bundle bundle = new Bundle();
                bundle.putString("title", "photo 1 module");
                photoFragment.setArguments(bundle);
                mFragments.add(photoFragment);
            }
        } catch (Throwable e) {
            Logger.d(e.getMessage());
        }

        if (mFragments.size() > 0) {
            currentFragment = mFragments.get(0);
            addFragment((BaseFragment) mFragments.get(0));
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (mFragments.size() <= 0) {
            Logger.d("组件还没有加载呢");
            return true;
        }

        int index;
        int itemId = menuItem.getItemId();
        if (itemId == ResourceUtil.getId("tab_main")) {
            index = 0;
        } else if (itemId == ResourceUtil.getId("tab_movie")) {
            index = 1;
        } else if (itemId == ResourceUtil.getId("tab_photo")) {
            index = 2;
        } else if (itemId == ResourceUtil.getId("tab_reader")) {
            index = 3;
        } else if (itemId == ResourceUtil.getId("tab_user")) {
            index = 3;
        } else {
            index = 0;
        }

        replaceFragment(mFragments.get(index));

        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void addFragment(BaseFragment fragment) {
        Bundle args = fragment.getArguments();
        if (args == null) {
            args = new Bundle();
            fragment.setArguments(args);
        }
        Logger.d("========================" + args.getString("title"));
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(ResourceUtil.getId("layout_content"), fragment);
        transaction.commit();
    }

    @Override
    public void replaceFragment(BaseFragment fragment) {
        if (currentFragment != fragment) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (fragment.isAdded()) {
                transaction.hide(currentFragment).show(fragment).commit();
            } else {
                transaction.hide(currentFragment).add(ResourceUtil.getId("layout_content"), fragment).commit();
            }
            currentFragment = fragment;
        }
    }

    @Override
    public void closeAllFragment() {
        finish();
        overridePendingTransition(0, 0);
    }
}