package com.gewechat.api.base;

import com.alibaba.fastjson2.JSONObject;
import com.gewechat.util.HttpUtil;

import java.util.List;

/**
 * 标签模块 API
 * 仅供学习研究使用
 * 
 * 有任何帮助或疑问请联系：gewechatapi
 */
public class LabelApi {

    /**
     * 添加标签
     *
     * @param appId     应用ID
     * @param labelName 标签名称
     * @return 添加结果
     */
    public static JSONObject addLabel(String appId, String labelName) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("labelName", labelName);
        return HttpUtil.postJSON("/label/addLabel", param);
    }

    /**
     * 删除标签
     *
     * @param appId   应用ID
     * @param labelId 标签ID
     * @return 删除结果
     */
    public static JSONObject deleteLabel(String appId, String labelId) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("labelId", labelId);
        return HttpUtil.postJSON("/label/deleteLabel", param);
    }

    /**
     * 修改标签名称
     *
     * @param appId     应用ID
     * @param labelId   标签ID
     * @param labelName 新标签名称
     * @return 修改结果
     */
    public static JSONObject modifyLabel(String appId, String labelId, String labelName) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("labelId", labelId);
        param.put("labelName", labelName);
        return HttpUtil.postJSON("/label/modifyLabel", param);
    }

    /**
     * 获取标签列表
     *
     * @param appId 应用ID
     * @return 标签列表
     */
    public static JSONObject getLabelList(String appId) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        return HttpUtil.postJSON("/label/getLabelList", param);
    }

    /**
     * 设置好友标签
     *
     * @param appId    应用ID
     * @param wxid     好友微信ID
     * @param labelIds 标签ID列表
     * @return 设置结果
     */
    public static JSONObject setContactLabel(String appId, String wxid, List<String> labelIds) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("wxid", wxid);
        param.put("labelIds", labelIds);
        return HttpUtil.postJSON("/label/setContactLabel", param);
    }

    /**
     * 获取好友标签
     *
     * @param appId 应用ID
     * @param wxid  好友微信ID
     * @return 标签信息
     */
    public static JSONObject getContactLabel(String appId, String wxid) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("wxid", wxid);
        return HttpUtil.postJSON("/label/getContactLabel", param);
    }
}
