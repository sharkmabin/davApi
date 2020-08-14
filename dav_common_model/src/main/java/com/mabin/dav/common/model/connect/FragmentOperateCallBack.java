package com.mabin.dav.common.model.connect ;


import com.mabin.dav.common.model.base.BaseFragment;

public interface FragmentOperateCallBack {

  void addFragment(BaseFragment fragment);

  void replaceFragment(BaseFragment fragment);

  void closeAllFragment();

}
