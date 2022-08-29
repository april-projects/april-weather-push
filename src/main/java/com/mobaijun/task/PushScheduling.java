package com.mobaijun.task;

import com.mobaijun.service.WeChatMessageService;
import com.mobaijun.util.ContentUtil;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: PushScheduling
 * class description： 定时任务
 *
 * @author MoBaiJun 2022/8/29 9:59
 */
@Component
@EnableScheduling
public class PushScheduling {
    /**
     * 应用ID
     */
    private static final String AGENT_ID = "1000003";

    /**
     * 主程序（天气推送）|早上7：30
     */
    @Scheduled(cron = "0 30 7 * * ?")
    public void morningWeatherPush() {
        startPush();
    }

    /**
     * 主程序（天气推送）|晚上
     */
    @Scheduled(cron = "0 30 17 * * ?")
    public void nightWeatherPush() {
        startPush();
    }

    /**
     * 定时任务逻辑
     */
    private void startPush() {
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
