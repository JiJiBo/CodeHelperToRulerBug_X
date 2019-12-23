package com.rulerbug.firstlibrary_x.Utils;

import android.os.Environment;

public class DirUtils {


    public static String getStorePath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    /**
     * 获取cache路径
     */
    public static String getDiskCachePath() {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            return BugApp.getContext().getExternalCacheDir().getPath();
        } else {
            return BugApp.getContext().getCacheDir().getPath();
        }
    }
}