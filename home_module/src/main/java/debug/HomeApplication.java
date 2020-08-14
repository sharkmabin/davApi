package debug;

import android.app.Application;

import com.mabin.dav.framework.model.base.BaseApplication;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import org.xutils.x;

public class HomeApplication extends BaseApplication {
    public static HomeApplication loginApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        loginApplication = this;
        init();
    }

    public void init(){
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return true;
            }
        });
        x.Ext.init(loginApplication);
        // 设置是否输出debug
        x.Ext.setDebug(false);
    }
}
