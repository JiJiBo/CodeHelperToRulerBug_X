package com.rulerbug.firstlibrary_x.Utils;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.rulerbug.firstlibrary_x.Domain.BugOkHttpDataBean;
import com.rulerbug.firstlibrary_x.Domain.BugOkHttpDataList;
import com.rulerbug.firstlibrary_x.Domain.BugOkHttpFileBean;
import com.rulerbug.firstlibrary_x.Domain.BugOkHttpFileList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.rulerbug.firstlibrary_x.Utils.BugLogUtils.e;

public class BugNewOkHttpUtils {
    public static InputStream getInputStrem(String url) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().byteStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static File getFile(String url, String path) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            InputStream inputStream = response.body().byteStream();
            File file = new File(path);
            OutputStream outStream = new FileOutputStream(file);
            byte[] buffer = new byte[8 * 1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
            return file;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public static String getString(String url) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String postString(String url, RequestBody body) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void postString(String url, RequestBody body, Callback callbcak) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            client.newCall(request).enqueue(callbcak);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String postHttp(String url, RequestBody body) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void postHttp(String url, RequestBody body, Callback callbcak) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            client.newCall(request).enqueue(callbcak);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String postString(String url, HashMap<String, String> paramsMap) {
        try {
            FormBody.Builder builder = new FormBody.Builder();
            for (String key : paramsMap.keySet()) {
                builder.add(key, paramsMap.get(key));
            }
            RequestBody formBody = builder.build();
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void postFile(String url, MultipartBody body, Callback callbcak) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            client.newCall(request).enqueue(callbcak);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String postFile(String url, MultipartBody body) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MultipartBody getFileMultipartBody
            (List<BugOkHttpDataBean> dataList, List<BugOkHttpFileBean> fileList) {
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        for (BugOkHttpDataBean b : dataList) {
            builder.addFormDataPart(b.key, b.value);
        }
        for (BugOkHttpFileBean b : fileList) {
            RequestBody fileBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=utf-8"), b.f);
            builder.addFormDataPart(b.name, b.filename, fileBody);
        }
        return builder.build();
    }

    public static FormBody getRequestBody(List<BugOkHttpDataBean> dataList) {
        FormBody.Builder builder = new FormBody.Builder();
        for (BugOkHttpDataBean b : dataList) {
            builder.add(b.key, b.value);
        }
        return builder.build();
    }

    public static MultipartBody getFileMultipartBody(BugOkHttpDataList
                                                             dataList, BugOkHttpFileList fileList) {
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        for (BugOkHttpDataBean b : dataList.dataList) {
            builder.addFormDataPart(b.key, b.value);
        }
        for (BugOkHttpFileBean b : fileList.dataList) {
            RequestBody fileBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=utf-8"), b.f);
            builder.addFormDataPart(b.name, b.filename, fileBody);
        }
        return builder.build();
    }

    public static FormBody getRequestBody(BugOkHttpDataList dataList) {
        FormBody.Builder builder = new FormBody.Builder();
        for (BugOkHttpDataBean b : dataList.dataList) {
            builder.add(b.key, b.value);
        }
        return builder.build();
    }
}
