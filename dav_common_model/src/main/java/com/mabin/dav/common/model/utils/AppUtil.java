package com.mabin.dav.common.model.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import com.mabin.dav.framework.model.base.BaseApplication;

public class AppUtil {

    public static Context getContext() {
        return BaseApplication.getInstance();
    }

    public static String getPackageName() {
        return BaseApplication.getInstance().getPackageName();
    }

    private static PackageInfo getPackageInfo() {
        PackageInfo packageInfo = null;
        PackageManager pm = getContext().getPackageManager();
        try {
            packageInfo = pm.getPackageInfo(getPackageName(), PackageManager.GET_CONFIGURATIONS);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
        return packageInfo;
    }

    public static long getAppVersion() {
        if (null == getPackageInfo()) {
            return 0;
        }
        return getPackageInfo().getLongVersionCode();
    }

    public static String getAppVersionName() {
        if (null == getPackageInfo()) {
            return "";
        }
        return getPackageInfo().versionName;
    }

    public static boolean isAppDebug() {
        if (!TextUtils.isEmpty(getPackageName())) {
            return false;
        }
        PackageManager pm = getContext().getPackageManager();
        try {
            ApplicationInfo ai = pm.getApplicationInfo(getPackageName(), 0);
            return ai != null && (ai.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }


}
