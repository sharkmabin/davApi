package com.mabin.router.model.provider;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.template.IProvider;

public interface IReaderProvider extends IProvider {

    Fragment readerInstance(Activity activity, Bundle bundle);

}
