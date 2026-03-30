package com.gewechat.util;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * HTTP请求工具类
 * 仅供学习研究使用
 * 
 * 有任何帮助或疑问请联系：gewechatapi
 */
public class HttpUtil {

    private static final String BASE_URL = "http://127.0.0.1:2531/v2/api";
    private static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");
    
    private static String token = "";
    private static final OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build();

    /**
     * 设置Token
     */
    public static void setToken(String token) {
        HttpUtil.token = token;
    }

    /**
     * 获取Token
     */
    public static String getToken() {
        return token;
    }

    /**
     * 设置基础URL
     */
    public static void setBaseUrl(String baseUrl) {
        // 可以通过此方法修改服务器地址
    }

    /**
     * 发送POST请求（JSON格式）
     *
     * @param apiPath API路径
     * @param param   请求参数
     * @return 响应结果
     */
    public static JSONObject postJSON(String apiPath, JSONObject param) {
        String url = BASE_URL + apiPath;
        
        RequestBody body = RequestBody.create(JSON_MEDIA_TYPE, param.toJSONString());
        
        Request.Builder requestBuilder = new Request.Builder()
                .url(url)
                .post(body);
        
        // 添加Token到Header
        if (token != null && !token.isEmpty()) {
            requestBuilder.addHeader("X-GEWE-TOKEN", token);
        }
        
        Request request = requestBuilder.build();
        
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String responseBody = response.body().string();
                return JSON.parseObject(responseBody);
            } else {
                JSONObject error = new JSONObject();
                error.put("code", -1);
                error.put("msg", "请求失败: " + response.code());
                return error;
            }
        } catch (IOException e) {
            JSONObject error = new JSONObject();
            error.put("code", -1);
            error.put("msg", "网络错误: " + e.getMessage());
            return error;
        }
    }

    /**
     * 发送GET请求
     *
     * @param apiPath API路径
     * @return 响应结果
     */
    public static JSONObject get(String apiPath) {
        String url = BASE_URL + apiPath;
        
        Request.Builder requestBuilder = new Request.Builder()
                .url(url)
                .get();
        
        // 添加Token到Header
        if (token != null && !token.isEmpty()) {
            requestBuilder.addHeader("X-GEWE-TOKEN", token);
        }
        
        Request request = requestBuilder.build();
        
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String responseBody = response.body().string();
                return JSON.parseObject(responseBody);
            } else {
                JSONObject error = new JSONObject();
                error.put("code", -1);
                error.put("msg", "请求失败: " + response.code());
                return error;
            }
        } catch (IOException e) {
            JSONObject error = new JSONObject();
            error.put("code", -1);
            error.put("msg", "网络错误: " + e.getMessage());
            return error;
        }
    }

    /**
     * 下载文件
     *
     * @param fileUrl 文件URL
     * @return 文件字节数组
     */
    public static byte[] downloadFile(String fileUrl) {
        String url = "http://127.0.0.1:2532" + fileUrl;
        
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                return response.body().bytes();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
