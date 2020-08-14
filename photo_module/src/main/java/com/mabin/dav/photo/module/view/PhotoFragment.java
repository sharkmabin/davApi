package com.mabin.dav.photo.module.view;

import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.mabin.dav.common.model.base.BaseFragment;
import com.mabin.dav.common.model.utils.ResourceUtil;

@Route(path = "/photo/fragment")
public class PhotoFragment extends BaseFragment {
    @Override
    protected void initView(View contentView) {
        String title = getArguments().getString("title");
        TextView tv = contentView.findViewById(ResourceUtil.getId("contentFragmentTv"));
        tv.setText(title);
    }

    @Override
    protected int getContentLayoutId() {
        return ResourceUtil.getLayoutId("content_login");
    }
}
