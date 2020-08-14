package com.mabin.dav.common.model.net;

public class ResponseMod<T> {

    public int code ;
    public String msg ;
    public T data ;

    private ResponseMod(){
        super();
    }

    public ResponseMod(int code,String msg,T data) {
        this.code = code ;
        this.msg = msg ;
        this.data = data ;
    }

}
