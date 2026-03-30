package com.gewechat.api.base;

import com.alibaba.fastjson2.JSONObject;
import com.gewechat.util.HttpUtil;

/**
 * 登录模块 API
 * 仅供学习研究使用
 * 
 * 有任何帮助或疑问请联系：gewechatapi
 */
public class LoginApi {

    /**
     * 获取 Token
     * 将获取到的 Token 设置到 HttpUtil 中
     *
     * @return Token信息
     */
    public static JSONObject getToken() {
        JSONObject result = HttpUtil.postJSON("/tools/getTokenId", new JSONObject());
        if (result.getIntValue("code") == 0) {
            String token = result.getJSONObject("data").getString("token");
            HttpUtil.setToken(token);
        }
        return result;
    }

    /**
     * 设置消息回调地址
     *
     * @param token       Token
     * @param callbackUrl 回调URL
     * @return 设置结果
     */
    public static JSONObject setCallback(String token, String callbackUrl) {
        JSONObject param = new JSONObject();
        param.put("token", token);
        param.put("callbackUrl", callbackUrl);
        return HttpUtil.postJSON("/tools/setCallback", param);
    }

    /**
     * 获取登录二维码
     *
     * @param appId 设备ID，首次登录传空字符串
     * @return 二维码信息
     */
    public static JSONObject getQr(String appId) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        return HttpUtil.postJSON("/login/getLoginQrCode", param);
    }

    /**
     * 检查登录状态 / 确认登录
     *
     * @param appId      设备ID
     * @param uuid       获取二维码时返回的UUID
     * @param captchCode 验证码（跨省登录可能需要）
     * @return 登录结果
     */
    public static JSONObject checkQr(String appId, String uuid, String captchCode) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("uuid", uuid);
        param.put("captchCode", captchCode);
        return HttpUtil.postJSON("/login/checkLogin", param);
    }

    /**
     * 检查微信是否在线
     *
     * @param appId 设备ID
     * @return 在线状态
     */
    public static JSONObject checkOnline(String appId) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        return HttpUtil.postJSON("/login/checkOnline", param);
    }

    /**
     * 退出微信登录
     *
     * @param appId 设备ID
     * @return 退出结果
     */
    public static JSONObject logout(String appId) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        return HttpUtil.postJSON("/login/logout", param);
    }

    /**
     * 弹框登录（备用登录方式）
     *
     * @param appId 设备ID
     * @return 登录结果
     */
    public static JSONObject dialogLogin(String appId) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        return HttpUtil.postJSON("/login/dialogLogin", param);
    }

    /**
     * 断线重连
     *
     * @param appId 设备ID
     * @return 重连结果
     */
    public static JSONObject reconnection(String appId) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        return HttpUtil.postJSON("/login/reconnection", param);
    }
}
