package com.rulerbug.firstlibrary_x.Domain;

import java.util.ArrayList;
import java.util.List;

public class BugOkHttpDataList {
    public List<BugOkHttpDataBean> dataList = new ArrayList<>();

    public void add(String key, String value) {
        BugOkHttpDataBean b = new BugOkHttpDataBean(key, value);
        dataList.add(b);
    }

}
