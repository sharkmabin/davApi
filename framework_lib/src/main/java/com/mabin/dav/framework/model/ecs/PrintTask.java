package com.mabin.dav.framework.model.ecs;

import android.util.Log;

import com.mabin.dav.framework.model.bean.LogBean;

public class PrintTask extends BasePrint{

    public PrintTask(String filePath, int max_size) {
        super(filePath, max_size);
    }

    public void addTask(int level, String tag, String msg) {
        Log.println(level, tag, msg);
        super.addTask(level, tag, msg);
    }

    public void doTask(LogBean bean) {}

}
