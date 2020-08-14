package com.mabin.dav.common.model.net;

public interface DCallback<T> {
    void onSuccess(ResponseMod<T> mod);

    void onFail(ResponseMod<T> mod);

}
