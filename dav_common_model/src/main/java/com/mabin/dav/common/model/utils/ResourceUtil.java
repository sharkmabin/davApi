package com.mabin.dav.common.model.utils;

import android.content.Context;

import com.orhanobut.logger.Logger;

public class ResourceUtil {

    private static Context context = null;

    public ResourceUtil() {
        context = AppUtil.getContext();
    }

    public static int getId(String resourceName) {
        return getIdentifierByType(resourceName, "id");
    }

    public static int getLayoutId(String resourceName) {
        return getIdentifierByType(resourceName, "layout");
    }

    public static int getStringId(String resourceName) {
        return getIdentifierByType(resourceName, "string");
    }

    public static int getDrawableId(String resourceName) {
        return getIdentifierByType(resourceName, "drawable");
    }

    public static int getMipmapId(String resourceName) {
        return getIdentifierByType(resourceName, "mipmap");
    }

    public static int getColorId(String resourceName) {
        return getIdentifierByType(resourceName, "color");
    }

    public static int getDimenId(String resourceName) {
        return getIdentifierByType(resourceName, "dimen");
    }

    public static int getAttrId(String resourceName) {
        return getIdentifierByType(resourceName, "attr");
    }

    public static int getStyleId(String resourceName) {
        return getIdentifierByType(resourceName, "style");
    }

    public static int getAnimId(String resourceName) {
        return getIdentifierByType(resourceName, "anim");
    }

    public static int getArrayId(String resourceName) {
        return getIdentifierByType(resourceName, "array");
    }

    public static int getIntegerId(String resourceName) {
        return getIdentifierByType(resourceName, "integer");
    }

    public static int getBoolId(String resourceName) {
        return getIdentifierByType(resourceName, "bool");
    }

    private static int getIdentifierByType(String resourceName, String defType) {
        if (context == null) {
            context = AppUtil.getContext();
        }
        return context.getResources().getIdentifier(resourceName,
                defType,
                context.getPackageName());
    }
}
