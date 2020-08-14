package debug;

import android.app.Application;

import com.mabin.dav.framework.model.base.BaseApplication;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import org.xutils.x;

public class MovieApplication extends BaseApplication {

    public static MovieApplication loginApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        loginApplication = this;
        init();
    }

    public void init() {
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return true;
            }
        });
        x.Ext.init(loginApplication);
        x.Ext.setDebug(false);
    }

}
