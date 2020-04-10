package com.rulerbug.firstlibrary_x.Domain;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BugOkHttpFileList {
    public List<BugOkHttpFileBean> dataList = new ArrayList<>();

    public void add(String name, String filename, File f) {
        BugOkHttpFileBean b = new BugOkHttpFileBean(name, filename, f);
        dataList.add(b);
    }

}
