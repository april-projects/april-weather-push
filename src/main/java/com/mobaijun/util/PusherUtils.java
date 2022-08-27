package com.mobaijun.util;

import com.mobaijun.model.Weather;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: PusherUtils
 * description: 推送工具类
 *
 * @author MoBaiJun 2022/8/27 15:31
 */
public class PusherUtils {
    /**
     * 微信推送
     */
    public static void push() {
        // 1，配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        String appId = "wx70b456af48a9e511";
        wxStorage.setAppId(appId);
        String secret = "a3e812eeb2843cd15893434e6b368bfc";
        wxStorage.setSecret(secret);
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);
        List<String> user = new LinkedList<>();
        user.add("ow2wX6tv_NG8xNxtz7USM6g0aq_s");
        user.add("ow2wX6m5v0cGLDF68P21bdcU58AY");
        user.forEach(temp -> {
            // 2,推送消息
            WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                    .toUser(temp)
                    .templateId("ZWAnJua8bfCnpFCskAvjaRZRy05EvAZf9XhAoLDPAAg")
                    .build();
            // 3,如果是正式版发送模版消息，这里需要配置你的信息
            Weather weather = WeatherUtil.getWeather();
            Map<String, String> map = SkywalkerUtil.getSentence();
            templateMessage.addData(new WxMpTemplateData("riqi", weather.getDate() + "  " + weather.getWeek(), "#00BFFF"));
            templateMessage.addData(new WxMpTemplateData("tianqi", weather.getTextNow(), "#00FFFF"));
            templateMessage.addData(new WxMpTemplateData("low", weather.getLow() + "", "#173177"));
            templateMessage.addData(new WxMpTemplateData("temp", weather.getTemp() + "", "#EE212D"));
            templateMessage.addData(new WxMpTemplateData("high", weather.getHigh() + "", "#FF6347"));
            templateMessage.addData(new WxMpTemplateData("windclass", weather.getWindClass() + "", "#42B857"));
            templateMessage.addData(new WxMpTemplateData("textDay", weather.getTextDay() + "", "#FF1493"));
            templateMessage.addData(new WxMpTemplateData("winddir", weather.getWindDir() + "", "#B95EA3"));
            templateMessage.addData(new WxMpTemplateData("caihongpi", SkywalkerUtil.getCaiHongPi(), "#FF69B4"));
            templateMessage.addData(new WxMpTemplateData("birthday", MemorialDayUtil.getBirthdayJie() + "", "#FFA500"));
            templateMessage.addData(new WxMpTemplateData("en", map.get("en") + "", "#C71585"));
            templateMessage.addData(new WxMpTemplateData("zh", map.get("zh") + "", "#C71585"));
            String beizhu = "墨白";
            templateMessage.addData(new WxMpTemplateData("beizhu", beizhu, "#FF0000"));
            try {
                System.out.println(templateMessage.toJson());
                System.out.println(wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage));
            } catch (Exception e) {
                System.out.println("推送失败：" + e.getMessage());
                e.printStackTrace();
            }
        });
    }
}
