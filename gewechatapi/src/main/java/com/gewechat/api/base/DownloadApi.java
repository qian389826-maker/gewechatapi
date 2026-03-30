package com.gewechat.api.base;

import com.gewechat.util.HttpUtil;

/**
 * 文件下载模块 API
 * 仅供学习研究使用
 * 
 * 有任何帮助或疑问请联系：gewechatapi
 */
public class DownloadApi {

    /**
     * 下载文件
     *
     * @param fileUrl 文件URL（API返回的相对路径）
     * @return 文件字节数组
     */
    public static byte[] downloadFile(String fileUrl) {
        return HttpUtil.downloadFile(fileUrl);
    }

    /**
     * 下载图片并保存到本地
     *
     * @param fileUrl  文件URL
     * @param savePath 保存路径
     * @return 是否成功
     */
    public static boolean downloadImage(String fileUrl, String savePath) {
        byte[] data = downloadFile(fileUrl);
        if (data != null) {
            try {
                java.nio.file.Files.write(java.nio.file.Paths.get(savePath), data);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 下载语音并保存到本地
     *
     * @param fileUrl  文件URL
     * @param savePath 保存路径
     * @return 是否成功
     */
    public static boolean downloadVoice(String fileUrl, String savePath) {
        return downloadImage(fileUrl, savePath); // 复用相同逻辑
    }

    /**
     * 下载视频并保存到本地
     *
     * @param fileUrl  文件URL
     * @param savePath 保存路径
     * @return 是否成功
     */
    public static boolean downloadVideo(String fileUrl, String savePath) {
        return downloadImage(fileUrl, savePath); // 复用相同逻辑
    }

    /**
     * 下载文件并保存到本地
     *
     * @param fileUrl  文件URL
     * @param savePath 保存路径
     * @return 是否成功
     */
    public static boolean downloadFile(String fileUrl, String savePath) {
        return downloadImage(fileUrl, savePath); // 复用相同逻辑
    }
}
