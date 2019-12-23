package com.rulerbug.firstlibrary.Utils;

import static com.rulerbug.firstlibrary.Utils.BugApp.getContext;

public class pxUtils {
    public static int getDimension(int id) {
        return getContext().getResources().getDimensionPixelSize(id);
    }

    // 像素转换
    public static float px2dip(int px) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return px / density;
    }

    public static int dip2px(int dp) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5f);
    }

}
