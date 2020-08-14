package com.mabin.dav.common.model.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mabin.dav.common.model.connect.FragmentOperateCallBack;
import com.mabin.dav.common.model.connect.IDataLoadLitener;
import com.mabin.dav.common.model.connect.OnFragmentDismissCallBack;
import com.mabin.dav.common.model.manager.FragmentLifecycleManager;

import me.leefeng.promptlibrary.PromptDialog;

public abstract class BaseFragment extends Fragment implements IDataLoadLitener {

    private static final String STATE_SAVE_IS_HIDDEN_TAG = "show_or_hide";

    public PromptDialog promptDialog ;

    protected FragmentOperateCallBack fragmentOperateCallBack;

    protected Activity mContext ;

    protected abstract void initView(View contentView);
    protected abstract int getContentLayoutId();


    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {// 解决fragment 重叠问题
            boolean isSupportHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN_TAG);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            if (isSupportHidden) {
                ft.hide(this);
            } else {
                ft.show(this);
            }
            ft.commit();
        }

        promptDialog = new PromptDialog(getActivity()) ;
    }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState) {

        View baseView = inflater.inflate(getContentLayoutId(), container, false);

        initView(baseView);

        loadData();

        return baseView;
    }

    @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        fragmentOperateCallBack = (FragmentOperateCallBack) mContext;
    }

    @Override public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(STATE_SAVE_IS_HIDDEN_TAG, isHidden());// 解决fragment 重叠问题
    }

    /**
     * 解决getActivity为null的情况
     * @param context
     */

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity){
            mContext = (Activity) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null ;
    }

    // 关闭Fragment 并且 发送事件通知;
    public void finish(){

        fragmentOperateCallBack.closeAllFragment();

        OnFragmentDismissCallBack callBack = FragmentLifecycleManager.getInstance().getDismissCallBack(this.getClass());
        if (callBack != null){
            callBack.onDismiss();
        }
    }

  /*
  @Override public void onPause() {
    super.onPause();

    LogUtil.d(this.toString() + ":onPause");
  }

  @Override public void onResume() {
    super.onResume();

    LogUtil.d(this.toString() + ":onResume");
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    LogUtil.d(this.toString() + ":onDestroyView");
  }

  @Override public void onViewStateRestored(Bundle savedInstanceState) {
    super.onViewStateRestored(savedInstanceState);
    LogUtil.d(this.toString() + ":onViewStateRestored");
  }

  @Override public void onDestroy() {
    super.onDestroy();
    LogUtil.d(this.toString() + ":onDestroy");
  }
   */


}
