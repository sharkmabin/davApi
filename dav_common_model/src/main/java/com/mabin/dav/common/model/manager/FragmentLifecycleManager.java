package com.mabin.dav.common.model.manager;

import com.mabin.dav.common.model.base.BaseFragment;
import com.mabin.dav.common.model.connect.OnFragmentDismissCallBack;

import java.util.HashMap;


//Fragment 生命周期管理类， 用于配置监听Fragmen关闭事件
public class FragmentLifecycleManager {

  private static volatile  FragmentLifecycleManager instance;

  private HashMap<String, OnFragmentDismissCallBack> callBackHashMap;

  public static FragmentLifecycleManager getInstance() {

    if (instance == null){
      synchronized(FragmentLifecycleManager.class) {
        if (instance == null){
          instance = new FragmentLifecycleManager();
        }
      }
    }
    return instance;
  }

  private FragmentLifecycleManager(){
    callBackHashMap = new HashMap<>();

  }

  public OnFragmentDismissCallBack getDismissCallBack(Class<? extends BaseFragment> fragmentClass) {
    return callBackHashMap.get(fragmentClass.getName());
  }

  public void setDismissCallBack(Class<? extends BaseFragment> fragmentClass ,OnFragmentDismissCallBack onFragmentDismissCallBack){
    if (onFragmentDismissCallBack == null){
      return;
    }
    callBackHashMap.put(fragmentClass.getName(),onFragmentDismissCallBack);
  }

  public void clearCallBack(){
    callBackHashMap.clear();
  }
}
