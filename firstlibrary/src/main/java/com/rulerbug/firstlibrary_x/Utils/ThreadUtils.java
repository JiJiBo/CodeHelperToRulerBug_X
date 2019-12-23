package com.rulerbug.firstlibrary_x.Utils;

import static com.rulerbug.firstlibrary_x.Utils.BugApp.getHandler;
import static com.rulerbug.firstlibrary_x.Utils.BugApp.getTheardId;

public class ThreadUtils {
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
}
