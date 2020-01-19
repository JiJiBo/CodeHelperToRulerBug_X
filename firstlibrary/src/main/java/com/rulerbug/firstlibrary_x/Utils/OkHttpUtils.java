package com.rulerbug.firstlibrary_x.Utils;

import java.io.InputStream;
import java.util.HashMap;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtils {
    public static InputStream getInputStrem(String url) {
        try {
            OkHttpClient client = new OkHttpClient();
            //2. 创建请求的Request 对象
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            //3. 在Okhttp中创建Call 对象，将request和Client进行绑定
            //4. 执行Call对象（call 是interface 实际执行的是RealCall）中的`execute`方法

            Response response = client.newCall(request).execute();
            return response.body().byteStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getString(String url) {
        try {
            OkHttpClient client = new OkHttpClient();
            //2. 创建请求的Request 对象
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            //3. 在Okhttp中创建Call 对象，将request和Client进行绑定
            //4. 执行Call对象（call 是interface 实际执行的是RealCall）中的`execute`方法

            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String postString(String url, RequestBody body) {
//        val jsonStr = OkHttpUtils.postString(
//                HttpUrlArgument.POST_EAR_TAG_INFO,
//                FormBody.Builder().add("", "").build()
//        )
        try {
            OkHttpClient client = new OkHttpClient();
            //2. 创建请求的Request 对象
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();

            //3. 在Okhttp中创建Call 对象，将request和Client进行绑定
            //4. 执行Call对象（call 是interface 实际执行的是RealCall）中的`execute`方法

            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String postHttp(String url, RequestBody body) {
//        val jsonStr = OkHttpUtils.postString(
//                HttpUrlArgument.POST_EAR_TAG_INFO,
//                FormBody.Builder().add("", "").build()
//        )
        try {
            OkHttpClient client = new OkHttpClient();
            //2. 创建请求的Request 对象
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();

            //3. 在Okhttp中创建Call 对象，将request和Client进行绑定
            //4. 执行Call对象（call 是interface 实际执行的是RealCall）中的`execute`方法

            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String postString(String url, HashMap<String, String> paramsMap) {
        try {
            FormBody.Builder builder = new FormBody.Builder();
            for (String key : paramsMap.keySet()) {
                //追加表单信息
                builder.add(key, paramsMap.get(key));
            }
            RequestBody formBody = builder.build();
            OkHttpClient client = new OkHttpClient();
            //2. 创建请求的Request 对象
            Request request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();

            //3. 在Okhttp中创建Call 对象，将request和Client进行绑定
            //4. 执行Call对象（call 是interface 实际执行的是RealCall）中的`execute`方法

            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void postHttp(String url, RequestBody body, Callback callbcak) {
//        val jsonStr = OkHttpUtils.postString(
//                HttpUrlArgument.POST_EAR_TAG_INFO,
//                FormBody.Builder().add("", "").build()
//        )
        try {
            OkHttpClient client = new OkHttpClient();
            //2. 创建请求的Request 对象
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();

            //3. 在Okhttp中创建Call 对象，将request和Client进行绑定
            //4. 执行Call对象（call 是interface 实际执行的是RealCall）中的`execute`方法

            client.newCall(request).enqueue(callbcak);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
