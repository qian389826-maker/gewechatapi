package com.gewechat.api.base;

import com.alibaba.fastjson2.JSONObject;
import com.gewechat.util.HttpUtil;

/**
 * 收藏夹模块 API
 * 仅供学习研究使用
 * 
 * 有任何帮助或疑问请联系：gewechatapi
 */
public class FavorApi {

    /**
     * 同步收藏夹
     *
     * @param appId      应用ID
     * @param keyBuf     同步密钥
     * @return 同步结果
     */
    public static JSONObject syncFavor(String appId, String keyBuf) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("keyBuf", keyBuf);
        return HttpUtil.postJSON("/favor/syncFavor", param);
    }

    /**
     * 获取收藏夹内容
     *
     * @param appId   应用ID
     * @param favId   收藏ID
     * @return 收藏内容
     */
    public static JSONObject getFavor(String appId, String favId) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("favId", favId);
        return HttpUtil.postJSON("/favor/getFavor", param);
    }

    /**
     * 删除收藏夹
     *
     * @param appId   应用ID
     * @param favId   收藏ID
     * @return 删除结果
     */
    public static JSONObject deleteFavor(String appId, String favId) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("favId", favId);
        return HttpUtil.postJSON("/favor/deleteFavor", param);
    }
}
