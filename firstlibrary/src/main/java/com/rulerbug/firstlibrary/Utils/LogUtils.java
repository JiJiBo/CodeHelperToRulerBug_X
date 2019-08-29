package com.rulerbug.firstlibrary.Utils;

import android.util.Log;

import java.util.logging.Level;

public class LogUtils {
    public static final int v = 10;
    public static final int d = 11;
    public static final int i = 12;
    public static final int w = 13;
    public static final int e = 14;
    public static final int NULL = 20;


    public static int level = v;

    public static void v(String msg) {
        if (level <= v) {
            Log.e("一条v级message", msg);
        }
    }

    public static void setLevel(int level) {
        LogUtils.level = level;
    }

    public static void d(String msg) {
        if (level <= d) {
            Log.e("一条d级message", msg);
        }
    }

    public static void i(String msg) {
        if (level <= i) {
            Log.e("一条i级message", msg);
        }
    }

    public static void w(String msg) {
        if (level <= w) {
            Log.e("一条v级message", msg);
        }
    }

    public static void e(String msg) {
        if (level <= e) {
            Log.e("一条e级message", msg);
        }
    }
}
