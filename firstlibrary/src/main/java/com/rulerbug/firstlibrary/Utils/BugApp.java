package com.rulerbug.firstlibrary.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Handler;
import android.view.View;

import java.util.Stack;


public class BugApp {
    private static Context mc;
    private static int myTid;
    private static Handler mHandler;
    private static Stack<Activity> activityStack;

    public static void init(Context cx, Handler handler, int tid) {
        mc = cx;
        mHandler = handler;
        myTid = tid;
    }

    public static Handler getmHandler() {
        return mHandler;
    }

    public static int getMyTid() {
        return myTid;
    }

    public static Context getMc() {
        return mc;
    }


    // 3个基本操作
    public static Context getContext() {
        return getMc();
    }

    public static int getTheardId() {
        return getMyTid();
    }

    public static Handler getHandler() {
        return getmHandler();
    }

    // 其他操作
    public static String[] getStringArray(int id) {
        return getContext().getResources().getStringArray(id);
    }


    public static int getDimension(int id) {
        return getContext().getResources().getDimensionPixelSize(id);
    }

    public static ColorStateList getColorStateListById(int id) {
        return getContext().getResources().getColorStateList(id);
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

    // 加载布局
    public static View inflate(int id) {
        return View.inflate(getContext(), id, null);
    }

    public static boolean isRunOnUIThread() {
        int mTid = android.os.Process.myTid();
        if (mTid == getTheardId()) {
            return true;
        }
        return false;
    }

    public static void RunOnUIThread(Runnable r) {
        if (isRunOnUIThread()) {
            r.run();
        } else {
            getHandler().post(r);
        }
    }

    /**
     * add Activity 添加Activity到栈
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    /**
     * get current Activity 获取当前Activity（栈中最后一个压入的）
     */
    public Activity currentActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * 结束当前Activity（栈中最后一个压入的）
     */
    public void finishActivity() {
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 退出应用程序
     */
    public void AppExit() {
        try {
            finishAllActivity();
        } catch (Exception e) {
        }
    }
}
