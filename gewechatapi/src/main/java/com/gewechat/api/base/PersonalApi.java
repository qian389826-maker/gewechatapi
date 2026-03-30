package com.gewechat.api.base;

import com.alibaba.fastjson2.JSONObject;
import com.gewechat.util.HttpUtil;

/**
 * 个人模块 API
 * 仅供学习研究使用
 * 
 * 有任何帮助或疑问请联系：gewechatapi
 */
public class PersonalApi {

    /**
     * 获取个人资料
     *
     * @param appId 应用ID
     * @return 个人资料
     */
    public static JSONObject getProfile(String appId) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        return HttpUtil.postJSON("/personal/getProfile", param);
    }

    /**
     * 获取自己的二维码
     *
     * @param appId       应用ID
     * @param style       二维码样式
     * @return 二维码信息
     */
    public static JSONObject getQrCode(String appId, Integer style) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("style", style);
        return HttpUtil.postJSON("/personal/getQrCode", param);
    }

    /**
     * 修改头像
     *
     * @param appId   应用ID
     * @param headImg 头像图片URL
     * @return 修改结果
     */
    public static JSONObject modifyHeadImg(String appId, String headImg) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("headImg", headImg);
        return HttpUtil.postJSON("/personal/modifyHeadImg", param);
    }

    /**
     * 修改昵称
     *
     * @param appId    应用ID
     * @param nickName 昵称
     * @return 修改结果
     */
    public static JSONObject modifyNickName(String appId, String nickName) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("nickName", nickName);
        return HttpUtil.postJSON("/personal/modifyNickName", param);
    }

    /**
     * 修改签名
     *
     * @param appId     应用ID
     * @param signature 签名
     * @return 修改结果
     */
    public static JSONObject modifySignature(String appId, String signature) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("signature", signature);
        return HttpUtil.postJSON("/personal/modifySignature", param);
    }

    /**
     * 隐私设置 - 允许别人通过手机号找到我
     *
     * @param appId   应用ID
     * @param switchValue 开关值（0:关闭 1:开启）
     * @return 设置结果
     */
    public static JSONObject privacyFindByPhone(String appId, Integer switchValue) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("switch", switchValue);
        return HttpUtil.postJSON("/personal/privacyFindByPhone", param);
    }

    /**
     * 隐私设置 - 允许别人通过微信号找到我
     *
     * @param appId   应用ID
     * @param switchValue 开关值（0:关闭 1:开启）
     * @return 设置结果
     */
    public static JSONObject privacyFindByWxId(String appId, Integer switchValue) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("switch", switchValue);
        return HttpUtil.postJSON("/personal/privacyFindByWxId", param);
    }

    /**
     * 隐私设置 - 允许别人通过群聊添加我
     *
     * @param appId   应用ID
     * @param switchValue 开关值（0:关闭 1:开启）
     * @return 设置结果
     */
    public static JSONObject privacyAddByGroup(String appId, Integer switchValue) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("switch", switchValue);
        return HttpUtil.postJSON("/personal/privacyAddByGroup", param);
    }

    /**
     * 隐私设置 - 允许别人通过名片添加我
     *
     * @param appId   应用ID
     * @param switchValue 开关值（0:关闭 1:开启）
     * @return 设置结果
     */
    public static JSONObject privacyAddByCard(String appId, Integer switchValue) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("switch", switchValue);
        return HttpUtil.postJSON("/personal/privacyAddByCard", param);
    }
}
