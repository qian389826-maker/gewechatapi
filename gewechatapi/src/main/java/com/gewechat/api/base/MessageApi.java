package com.gewechat.api.base;

import com.alibaba.fastjson2.JSONObject;
import com.gewechat.util.HttpUtil;

/**
 * 消息模块 API
 * 仅供学习研究使用
 * 
 * 有任何帮助或疑问请联系：gewechatapi
 */
public class MessageApi {

    /**
     * 发送文字消息
     *
     * @param appId   应用ID
     * @param toWxid  接收人微信ID
     * @param content 消息内容
     * @param ats     @某人（可选，格式：wxid1,wxid2）
     * @return 发送结果
     */
    public static JSONObject postText(String appId, String toWxid, String content, String ats) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("toWxid", toWxid);
        param.put("content", content);
        param.put("ats", ats);
        return HttpUtil.postJSON("/message/postText", param);
    }

    /**
     * 发送图片消息
     *
     * @param appId  应用ID
     * @param toWxid 接收人微信ID
     * @param imgUrl 图片URL
     * @return 发送结果
     */
    public static JSONObject postImage(String appId, String toWxid, String imgUrl) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("toWxid", toWxid);
        param.put("imgUrl", imgUrl);
        return HttpUtil.postJSON("/message/postImage", param);
    }

    /**
     * 发送文件消息
     *
     * @param appId    应用ID
     * @param toWxid   接收人微信ID
     * @param fileUrl  文件URL
     * @param fileName 文件名
     * @return 发送结果
     */
    public static JSONObject postFile(String appId, String toWxid, String fileUrl, String fileName) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("toWxid", toWxid);
        param.put("fileUrl", fileUrl);
        param.put("fileName", fileName);
        return HttpUtil.postJSON("/message/postFile", param);
    }

    /**
     * 发送语音消息
     *
     * @param appId        应用ID
     * @param toWxid       接收人微信ID
     * @param voiceUrl     语音文件URL
     * @param voiceDuration 语音时长（秒）
     * @return 发送结果
     */
    public static JSONObject postVoice(String appId, String toWxid, String voiceUrl, Integer voiceDuration) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("toWxid", toWxid);
        param.put("voiceUrl", voiceUrl);
        param.put("voiceDuration", voiceDuration);
        return HttpUtil.postJSON("/message/postVoice", param);
    }

    /**
     * 发送视频消息
     *
     * @param appId         应用ID
     * @param toWxid        接收人微信ID
     * @param videoUrl      视频URL
     * @param thumbUrl      缩略图URL
     * @param videoDuration 视频时长（秒）
     * @return 发送结果
     */
    public static JSONObject postVideo(String appId, String toWxid, String videoUrl, String thumbUrl, Integer videoDuration) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("toWxid", toWxid);
        param.put("videoUrl", videoUrl);
        param.put("thumbUrl", thumbUrl);
        param.put("videoDuration", videoDuration);
        return HttpUtil.postJSON("/message/postVideo", param);
    }

    /**
     * 发送链接消息
     *
     * @param appId    应用ID
     * @param toWxid   接收人微信ID
     * @param title    标题
     * @param desc     描述
     * @param linkUrl  链接地址
     * @param thumbUrl 缩略图URL
     * @return 发送结果
     */
    public static JSONObject postLink(String appId, String toWxid, String title, String desc, String linkUrl, String thumbUrl) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("toWxid", toWxid);
        param.put("title", title);
        param.put("desc", desc);
        param.put("linkUrl", linkUrl);
        param.put("thumbUrl", thumbUrl);
        return HttpUtil.postJSON("/message/postLink", param);
    }

    /**
     * 发送名片消息
     *
     * @param appId         应用ID
     * @param toWxid        接收人微信ID
     * @param nickName      昵称
     * @param nameCardWxid  名片微信ID
     * @return 发送结果
     */
    public static JSONObject postNameCard(String appId, String toWxid, String nickName, String nameCardWxid) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("toWxid", toWxid);
        param.put("nickName", nickName);
        param.put("nameCardWxid", nameCardWxid);
        return HttpUtil.postJSON("/message/postNameCard", param);
    }

    /**
     * 发送Emoji表情消息
     *
     * @param appId     应用ID
     * @param toWxid    接收人微信ID
     * @param emojiMd5  Emoji的MD5值
     * @param emojiSize Emoji大小
     * @return 发送结果
     */
    public static JSONObject postEmoji(String appId, String toWxid, String emojiMd5, String emojiSize) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("toWxid", toWxid);
        param.put("emojiMd5", emojiMd5);
        param.put("emojiSize", emojiSize);
        return HttpUtil.postJSON("/message/postEmoji", param);
    }

    /**
     * 发送小程序消息
     *
     * @param appId       应用ID
     * @param toWxid      接收人微信ID
     * @param miniAppId   小程序ID
     * @param displayName 显示名称
     * @param pagePath    页面路径
     * @param coverImgUrl 封面图片URL
     * @param title       标题
     * @param userName    用户名
     * @return 发送结果
     */
    public static JSONObject postMiniApp(String appId, String toWxid, String miniAppId, String displayName,
                                         String pagePath, String coverImgUrl, String title, String userName) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("toWxid", toWxid);
        param.put("miniAppId", miniAppId);
        param.put("displayName", displayName);
        param.put("pagePath", pagePath);
        param.put("coverImgUrl", coverImgUrl);
        param.put("title", title);
        param.put("userName", userName);
        return HttpUtil.postJSON("/message/postMiniApp", param);
    }

    /**
     * 发送APP消息
     *
     * @param appId  应用ID
     * @param toWxid 接收人微信ID
     * @param appmsg APP消息内容（XML格式）
     * @return 发送结果
     */
    public static JSONObject postAppMsg(String appId, String toWxid, String appmsg) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("toWxid", toWxid);
        param.put("appmsg", appmsg);
        return HttpUtil.postJSON("/message/postAppMsg", param);
    }

    /**
     * 转发文件
     *
     * @param appId  应用ID
     * @param toWxid 接收人微信ID
     * @param xml    文件XML内容
     * @return 转发结果
     */
    public static JSONObject forwardFile(String appId, String toWxid, String xml) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("toWxid", toWxid);
        param.put("xml", xml);
        return HttpUtil.postJSON("/message/forwardFile", param);
    }

    /**
     * 转发图片
     *
     * @param appId  应用ID
     * @param toWxid 接收人微信ID
     * @param xml    图片XML内容
     * @return 转发结果
     */
    public static JSONObject forwardImage(String appId, String toWxid, String xml) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("toWxid", toWxid);
        param.put("xml", xml);
        return HttpUtil.postJSON("/message/forwardImage", param);
    }

    /**
     * 转发视频
     *
     * @param appId  应用ID
     * @param toWxid 接收人微信ID
     * @param xml    视频XML内容
     * @return 转发结果
     */
    public static JSONObject forwardVideo(String appId, String toWxid, String xml) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("toWxid", toWxid);
        param.put("xml", xml);
        return HttpUtil.postJSON("/message/forwardVideo", param);
    }

    /**
     * 转发链接
     *
     * @param appId  应用ID
     * @param toWxid 接收人微信ID
     * @param xml    链接XML内容
     * @return 转发结果
     */
    public static JSONObject forwardUrl(String appId, String toWxid, String xml) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("toWxid", toWxid);
        param.put("xml", xml);
        return HttpUtil.postJSON("/message/forwardUrl", param);
    }

    /**
     * 转发小程序
     *
     * @param appId       应用ID
     * @param toWxid      接收人微信ID
     * @param xml         小程序XML内容
     * @param coverImgUrl 封面图片URL
     * @return 转发结果
     */
    public static JSONObject forwardMiniApp(String appId, String toWxid, String xml, String coverImgUrl) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("toWxid", toWxid);
        param.put("xml", xml);
        param.put("coverImgUrl", coverImgUrl);
        return HttpUtil.postJSON("/message/forwardMiniApp", param);
    }

    /**
     * 撤回消息
     *
     * @param appId      应用ID
     * @param toWxid     接收人微信ID
     * @param msgId      消息ID
     * @param newMsgId   新消息ID
     * @param createTime 消息创建时间
     * @return 撤回结果
     */
    public static JSONObject revokeMsg(String appId, String toWxid, String msgId, String newMsgId, String createTime) {
        JSONObject param = new JSONObject();
        param.put("appId", appId);
        param.put("toWxid", toWxid);
        param.put("msgId", msgId);
        param.put("newMsgId", newMsgId);
        param.put("createTime", createTime);
        return HttpUtil.postJSON("/message/revokeMsg", param);
    }
}
