package com.rulerbug.firstlibrary_x.Base;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.rulerbug.firstlibrary_x.Utils.BugActivityUtils;

public class BugBaseActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new BugActivityUtils().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        new BugActivityUtils().finishActivity(this);
    }
}
