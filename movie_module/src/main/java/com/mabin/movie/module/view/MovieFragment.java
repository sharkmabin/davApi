package com.mabin.movie.module.view;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.mabin.dav.common.model.base.BaseFragment;
import com.mabin.dav.common.model.utils.ResourceUtil;

@Route(path = "/movie/fragment")
public class MovieFragment extends BaseFragment {

    @Override
    protected void initView(View contentView) {

    }

    @Override
    protected int getContentLayoutId() {
        return ResourceUtil.getLayoutId("content_main");
    }
}
