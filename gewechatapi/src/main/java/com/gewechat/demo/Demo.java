package com.gewechat.demo;

import com.alibaba.fastjson2.JSONObject;
import com.gewechat.api.base.LoginApi;
import com.gewechat.api.base.MessageApi;
import com.gewechat.api.base.ContactApi;
import com.gewechat.api.base.GroupApi;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * GewechatAPI 使用示例
 * 仅供学习研究使用
 * 
 * 有任何帮助或疑问请联系：gewechatapi
 */
public class Demo {

    /**
     * 主方法 - 演示基本使用流程
     */
    public static void main(String[] args) throws InterruptedException {
        // ==================== 步骤1: 获取Token ====================
        System.out.println("正在获取Token...");
        JSONObject tokenResult = LoginApi.getToken();
        if (tokenResult.getIntValue("code") != 0) {
            System.out.println("获取Token失败: " + tokenResult.getString("msg"));
            return;
        }
        System.out.println("Token获取成功!");

        // ==================== 步骤2: 获取登录二维码 ====================
        System.out.println("正在获取登录二维码...");
        JSONObject qrResult = LoginApi.getQr("");
        if (qrResult.getIntValue("code") != 0) {
            System.out.println("获取二维码失败: " + qrResult.getString("msg"));
            return;
        }

        String appId = qrResult.getJSONObject("data").getString("appId");
        String uuid = qrResult.getJSONObject("data").getString("uuid");
        String qrBase64 = qrResult.getJSONObject("data").getString("qrBase64");

        System.out.println("请扫描二维码登录...");
        System.out.println("AppId: " + appId);
        System.out.println("UUID: " + uuid);
        // 实际使用时，将qrBase64转换为图片显示给用户扫码

        // ==================== 步骤3: 等待用户扫码并确认登录 ====================
        // 注意：实际使用时需要轮询检查登录状态
        System.out.println("等待用户扫码登录...");

        // 模拟等待扫码（实际使用时需要实现轮询逻辑）
        // JSONObject loginResult = LoginApi.checkQr(appId, uuid, "");

        // ==================== 步骤4: 登录成功后操作示例 ====================
        // 以下操作需要在登录成功后执行

        // 示例1: 发送文本消息
        // sendTextMessage(appId);

        // 示例2: 群发消息
        // massMessaging(appId);

        // 示例3: 获取通讯录
        // getContactList(appId);

        System.out.println("演示完成!");
    }

    /**
     * 示例: 发送文本消息
     *
     * @param appId 应用ID
     */
    public static void sendTextMessage(String appId) {
        System.out.println("发送文本消息...");

        // 接收人微信ID（可以是好友或群）
        String toWxid = "wxid_xxxxxxxxxxxx";  // 替换为实际的微信ID
        String content = "Hello, this is a test message from GewechatAPI!";

        JSONObject result = MessageApi.postText(appId, toWxid, content, "");

        if (result.getIntValue("code") == 0) {
            System.out.println("消息发送成功!");
        } else {
            System.out.println("消息发送失败: " + result.getString("msg"));
        }
    }

    /**
     * 示例: 群发消息
     *
     * @param appId 应用ID
     */
    public static void massMessaging(String appId) throws InterruptedException {
        System.out.println("开始群发消息...");

        // 群ID列表
        List<String> groupWxids = Arrays.asList(
                "39002402513@chatroom",
                "24099789585@chatroom",
                "52873617987@chatroom"
        );

        String message = "这是一条群发测试消息";

        for (String groupWxid : groupWxids) {
            JSONObject result = MessageApi.postText(appId, groupWxid, message, "");

            if (result.getIntValue("code") == 0) {
                System.out.println("发送到 " + groupWxid + " 成功!");
            } else {
                System.out.println("发送到 " + groupWxid + " 失败: " + result.getString("msg"));
            }

            // 随机延迟1-6秒，避免发送过快
            int delay = new Random().nextInt(6) + 1;
            System.out.println("等待 " + delay + " 秒...");
            Thread.sleep(delay * 1000);
        }

        System.out.println("群发完成!");
    }

    /**
     * 示例: 获取通讯录列表
     *
     * @param appId 应用ID
     */
    public static void getContactList(String appId) {
        System.out.println("获取通讯录列表...");

        JSONObject result = ContactApi.getContactList(appId);

        if (result.getIntValue("code") == 0) {
            System.out.println("通讯录获取成功!");
            // 解析通讯录数据
            // JSONArray contacts = result.getJSONObject("data").getJSONArray("contacts");
            // System.out.println("共有 " + contacts.size() + " 个联系人");
        } else {
            System.out.println("获取通讯录失败: " + result.getString("msg"));
        }
    }

    /**
     * 示例: 发送图片消息
     *
     * @param appId 应用ID
     */
    public static void sendImageMessage(String appId) {
        System.out.println("发送图片消息...");

        String toWxid = "wxid_xxxxxxxxxxxx";
        String imgUrl = "https://example.com/image.jpg";  // 图片URL

        JSONObject result = MessageApi.postImage(appId, toWxid, imgUrl);

        if (result.getIntValue("code") == 0) {
            System.out.println("图片发送成功!");
        } else {
            System.out.println("图片发送失败: " + result.getString("msg"));
        }
    }

    /**
     * 示例: 创建群聊
     *
     * @param appId 应用ID
     */
    public static void createGroup(String appId) {
        System.out.println("创建群聊...");

        // 要邀请的好友列表
        List<String> wxids = Arrays.asList(
                "wxid_friend1",
                "wxid_friend2"
        );

        JSONObject result = GroupApi.createGroup(appId, wxids);

        if (result.getIntValue("code") == 0) {
            String groupWxid = result.getJSONObject("data").getString("groupWxid");
            System.out.println("群聊创建成功! 群ID: " + groupWxid);
        } else {
            System.out.println("群聊创建失败: " + result.getString("msg"));
        }
    }

    /**
     * 示例: 检查在线状态
     *
     * @param appId 应用ID
     */
    public static void checkOnline(String appId) {
        System.out.println("检查在线状态...");

        JSONObject result = LoginApi.checkOnline(appId);

        if (result.getIntValue("code") == 0) {
            boolean isOnline = result.getJSONObject("data").getBooleanValue("online");
            System.out.println("在线状态: " + (isOnline ? "在线" : "离线"));
        } else {
            System.out.println("检查失败: " + result.getString("msg"));
        }
    }

    /**
     * 示例: 退出登录
     *
     * @param appId 应用ID
     */
    public static void logout(String appId) {
        System.out.println("退出登录...");

        JSONObject result = LoginApi.logout(appId);

        if (result.getIntValue("code") == 0) {
            System.out.println("退出成功!");
        } else {
            System.out.println("退出失败: " + result.getString("msg"));
        }
    }
}
