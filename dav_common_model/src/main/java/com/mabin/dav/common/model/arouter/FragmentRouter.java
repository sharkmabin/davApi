package com.mabin.dav.common.model.arouter;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.launcher.ARouter;

public class FragmentRouter {

    private static volatile FragmentRouter instance ;

    public static FragmentRouter getInstance() {
        if (instance == null) {
            instance = new FragmentRouter() ;
        }
        return instance ;
    }

    public IProvider getProvider(String routerPath) {
        return (IProvider) ARouter.getInstance().build(routerPath).navigation();
    }


}
