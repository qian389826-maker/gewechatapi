package com.gewechat.api.base;

import com.alibaba.fastjson2.JSONObject;
import com.gewechat.util.HttpUtil;

/**
 * 联系人模块 API
 * 仅供学习研究使用
 * 
 * 有任何帮助或疑问请联系：gewechatapi
 */
public class ContactApi {

    /**
     * 获取通讯录列表
     *
     * @param appId 应用ID
     * @return 通讯录列表
     */
    public static JSONObject getContactList(String appId) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        return HttpUtil.postJSON("/contact/getContactList", param);
    }

    /**
     * 获取联系人详细信息
     *
     * @param appId  应用ID
     * @param wxid   联系人微信ID
     * @return 联系人信息
     */
    public static JSONObject getContact(String appId, String wxid) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("wxid", wxid);
        return HttpUtil.postJSON("/contact/getContact", param);
    }

    /**
     * 搜索好友
     *
     * @param appId       应用ID
     * @param wxid        微信ID/手机号/QQ号
     * @return 搜索结果
     */
    public static JSONObject searchContact(String appId, String wxid) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("wxid", wxid);
        return HttpUtil.postJSON("/contact/searchContact", param);
    }

    /**
     * 添加好友
     *
     * @param appId          应用ID
     * @param wxid           对方微信ID
     * @param message        验证消息
     * @param scene          添加来源
     * @return 添加结果
     */
    public static JSONObject addContact(String appId, String wxid, String message, Integer scene) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("wxid", wxid);
        param.put("message", message);
        param.put("scene", scene);
        return HttpUtil.postJSON("/contact/addContact", param);
    }

    /**
     * 删除好友
     *
     * @param appId 应用ID
     * @param wxid  好友微信ID
     * @return 删除结果
     */
    public static JSONObject deleteContact(String appId, String wxid) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("wxid", wxid);
        return HttpUtil.postJSON("/contact/deleteContact", param);
    }

    /**
     * 设置好友备注
     *
     * @param appId  应用ID
     * @param wxid   好友微信ID
     * @param remark 备注名
     * @return 设置结果
     */
    public static JSONObject setContactRemark(String appId, String wxid, String remark) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("wxid", wxid);
        param.put("remark", remark);
        return HttpUtil.postJSON("/contact/setContactRemark", param);
    }

    /**
     * 设置好友仅聊天
     *
     * @param appId     应用ID
     * @param wxid      好友微信ID
     * @param onlyChat  是否仅聊天（0:否 1:是）
     * @return 设置结果
     */
    public static JSONObject setContactOnlyChat(String appId, String wxid, Integer onlyChat) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("wxid", wxid);
        param.put("onlyChat", onlyChat);
        return HttpUtil.postJSON("/contact/setContactOnlyChat", param);
    }

    /**
     * 获取好友申请列表
     *
     * @param appId 应用ID
     * @return 申请列表
     */
    public static JSONObject getFriendRequestList(String appId) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        return HttpUtil.postJSON("/contact/getFriendRequestList", param);
    }

    /**
     * 同意添加好友
     *
     * @param appId   应用ID
     * @param wxid    对方微信ID
     * @param scene   场景值
     * @param ticket  票据
     * @return 操作结果
     */
    public static JSONObject acceptFriendRequest(String appId, String wxid, Integer scene, String ticket) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("wxid", wxid);
        param.put("scene", scene);
        param.put("ticket", ticket);
        return HttpUtil.postJSON("/contact/acceptFriendRequest", param);
    }
}
