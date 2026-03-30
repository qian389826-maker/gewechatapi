package com.gewechat.api.base;

import com.alibaba.fastjson2.JSONObject;
import com.gewechat.util.HttpUtil;

import java.util.List;

/**
 * 群聊模块 API
 * 仅供学习研究使用
 * 
 * 有任何帮助或疑问请联系：gewechatapi
 */
public class GroupApi {

    /**
     * 创建微信群
     *
     * @param appId    应用ID
     * @param wxids    成员微信ID列表
     * @return 创建结果
     */
    public static JSONObject createGroup(String appId, List<String> wxids) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("wxids", wxids);
        return HttpUtil.postJSON("/group/createGroup", param);
    }

    /**
     * 获取群列表
     *
     * @param appId 应用ID
     * @return 群列表
     */
    public static JSONObject getGroupList(String appId) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        return HttpUtil.postJSON("/group/getGroupList", param);
    }

    /**
     * 获取群详细信息
     *
     * @param appId    应用ID
     * @param groupWxid 群ID
     * @return 群信息
     */
    public static JSONObject getGroup(String appId, String groupWxid) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("groupWxid", groupWxid);
        return HttpUtil.postJSON("/group/getGroup", param);
    }

    /**
     * 获取群成员列表
     *
     * @param appId     应用ID
     * @param groupWxid 群ID
     * @return 成员列表
     */
    public static JSONObject getGroupMemberList(String appId, String groupWxid) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("groupWxid", groupWxid);
        return HttpUtil.postJSON("/group/getGroupMemberList", param);
    }

    /**
     * 修改群名称
     *
     * @param appId     应用ID
     * @param groupWxid 群ID
     * @param groupName 新群名称
     * @return 修改结果
     */
    public static JSONObject modifyGroupName(String appId, String groupWxid, String groupName) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("groupWxid", groupWxid);
        param.put("groupName", groupName);
        return HttpUtil.postJSON("/group/modifyGroupName", param);
    }

    /**
     * 修改群备注
     *
     * @param appId       应用ID
     * @param groupWxid   群ID
     * @param groupRemark 群备注
     * @return 修改结果
     */
    public static JSONObject modifyGroupRemark(String appId, String groupWxid, String groupRemark) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("groupWxid", groupWxid);
        param.put("groupRemark", groupRemark);
        return HttpUtil.postJSON("/group/modifyGroupRemark", param);
    }

    /**
     * 修改我在群里的昵称
     *
     * @param appId    应用ID
     * @param groupWxid 群ID
     * @param nickName 昵称
     * @return 修改结果
     */
    public static JSONObject modifyGroupNickName(String appId, String groupWxid, String nickName) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("groupWxid", groupWxid);
        param.put("nickName", nickName);
        return HttpUtil.postJSON("/group/modifyGroupNickName", param);
    }

    /**
     * 邀请好友进群
     *
     * @param appId     应用ID
     * @param groupWxid 群ID
     * @param wxids     好友微信ID列表
     * @return 邀请结果
     */
    public static JSONObject inviteGroupMember(String appId, String groupWxid, List<String> wxids) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("groupWxid", groupWxid);
        param.put("wxids", wxids);
        return HttpUtil.postJSON("/group/inviteGroupMember", param);
    }

    /**
     * 添加群成员（直接拉入，无需同意）
     *
     * @param appId     应用ID
     * @param groupWxid 群ID
     * @param wxids     好友微信ID列表
     * @return 添加结果
     */
    public static JSONObject addGroupMember(String appId, String groupWxid, List<String> wxids) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("groupWxid", groupWxid);
        param.put("wxids", wxids);
        return HttpUtil.postJSON("/group/addGroupMember", param);
    }

    /**
     * 删除群成员
     *
     * @param appId     应用ID
     * @param groupWxid 群ID
     * @param wxids     要删除的成员微信ID列表
     * @return 删除结果
     */
    public static JSONObject deleteGroupMember(String appId, String groupWxid, List<String> wxids) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("groupWxid", groupWxid);
        param.put("wxids", wxids);
        return HttpUtil.postJSON("/group/deleteGroupMember", param);
    }

    /**
     * 退出群聊
     *
     * @param appId     应用ID
     * @param groupWxid 群ID
     * @return 退出结果
     */
    public static JSONObject quitGroup(String appId, String groupWxid) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("groupWxid", groupWxid);
        return HttpUtil.postJSON("/group/quitGroup", param);
    }

    /**
     * 解散群聊（群主权限）
     *
     * @param appId     应用ID
     * @param groupWxid 群ID
     * @return 解散结果
     */
    public static JSONObject dismissGroup(String appId, String groupWxid) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("groupWxid", groupWxid);
        return HttpUtil.postJSON("/group/dismissGroup", param);
    }

    /**
     * 获取群二维码
     *
     * @param appId     应用ID
     * @param groupWxid 群ID
     * @return 二维码信息
     */
    public static JSONObject getGroupQrCode(String appId, String groupWxid) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("groupWxid", groupWxid);
        return HttpUtil.postJSON("/group/getGroupQrCode", param);
    }
}
