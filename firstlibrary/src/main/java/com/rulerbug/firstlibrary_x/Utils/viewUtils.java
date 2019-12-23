package com.rulerbug.firstlibrary_x.Utils;

import android.view.View;

import static com.rulerbug.firstlibrary_x.Utils.BugApp.getContext;

public class viewUtils {

    // 加载布局
    public static View inflate(int id) {
        return View.inflate(getContext(), id, null);
    }
}
