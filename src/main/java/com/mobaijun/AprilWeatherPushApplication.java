package com.mobaijun;

import com.mobaijun.service.WeChatMessageService;
import com.mobaijun.util.ContentUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * 天气推送
 *
 * @author mobai
 */
public class AprilWeatherPushApplication {

    /**
     * 应用ID
     */
    private static final String AGENT_ID = "1000003";

    /**
     * 主程序（天气推送）
     *
     * @param args 参数列表
     */
    public static void main(String[] args) {
        List<String> phone = new LinkedList<>();
        phone.add("17520353373");
        // 初始化token
        String token = WeChatMessageService.getAccessToken();
        phone.forEach(temp -> {
            // 得到userId
            String userId = WeChatMessageService.getUserId(token, temp);
            // 构造消息体
            String content = ContentUtil.getContent();
            String sb = "{" +
                    "\"touser\":" + "\"" + userId + "\"," +
                    "\"msgtype\":" + "\"" + "text" + "\"," +
                    "\"agentid\":" + "\"" + AGENT_ID + "\"," +
                    "\"text\":" + "{" +
                    "\"content\":" + "\"" + content + "\"}," +
                    "\"safe\":\"0\"" +
                    "}";
            // 发送消息
            WeChatMessageService.sendMessage(token, sb);
        });
    }
}
