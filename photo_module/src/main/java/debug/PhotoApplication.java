package debug;

import com.mabin.dav.framework.model.base.BaseApplication;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import org.xutils.x;

public class PhotoApplication extends BaseApplication {

    public PhotoApplication photoApplication ;

    @Override
    public void onCreate() {
        super.onCreate();
        photoApplication = this ;
        init();
    }

    public void init(){
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return true;
            }
        });
        x.Ext.init(photoApplication);
        // 设置是否输出debug
        x.Ext.setDebug(false);
    }
}
