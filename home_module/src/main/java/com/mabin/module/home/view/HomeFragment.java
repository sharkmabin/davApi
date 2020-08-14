package com.mabin.module.home.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.mabin.dav.common.model.base.BaseFragment;
import com.mabin.dav.common.model.net.DCallback;
import com.mabin.dav.common.model.net.ResponseMod;
import com.mabin.dav.common.model.utils.ResourceUtil;
import com.mabin.module.home.adapter.HomeRecyAdapter;
import com.mabin.module.home.data.HostData;
import com.mabin.module.home.data.MovieData;
import com.mabin.module.home.net.HomeDataService;
import com.main.home.R;
import com.orhanobut.logger.Logger;

@Route(path = "/home/fragment")
public class HomeFragment extends BaseFragment {

    private RecyclerView home_recycler;
    private LinearLayoutManager mLinearLayoutManager;

    private HostData hostData;

    private HomeRecyAdapter mAdapter ;

    @Override
    protected void initView(View contentView) {

        home_recycler = contentView.findViewById(R.id.home_recycler);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        home_recycler.setLayoutManager(mLinearLayoutManager);


    }

    @Override
    protected int getContentLayoutId() {
        return ResourceUtil.getLayoutId("content_home_layout");
    }

    @Override
    public void loadData() {
        DCallback<HostData> dCallback = new DCallback<HostData>() {
            @Override
            public void onSuccess(ResponseMod<HostData> mod) {
                hostData = mod.data;

                Logger.d("mod.data:" + mod.data.toString());

                loadHomeMovieData() ;
            }

            @Override
            public void onFail(ResponseMod<HostData> mod) {
                promptDialog.dismissImmediately();
            }
        };
        promptDialog.showLoading("正在获取配置");
        HomeDataService.getInstance().queryHostUrl(dCallback);
    }

    private void loadHomeMovieData() {
        HomeDataService.getInstance().indexVedio(hostData.getHost() + hostData.getHome_vedio_path(), new DCallback<MovieData>() {
            @Override
            public void onSuccess(ResponseMod<MovieData> mod) {

                Logger.d(mod.data.getData().getItems().get(0).getImg());
                promptDialog.dismissImmediately();

                mAdapter = new HomeRecyAdapter(mod.data,hostData.getType4()) ;
                home_recycler.setAdapter(mAdapter);
            }

            @Override
            public void onFail(ResponseMod<MovieData> mod) {
                Logger.d("failed.");
                promptDialog.dismissImmediately();
            }
        });
    }
}
