package com.mobaijun.util;

import com.mobaijun.model.Weather;

import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: ContentUtil
 * description: 内容整合
 *
 * @author MoBaiJun 2022/8/27 20:45
 */
public class ContentUtil {

    /**
     * 组装推送消息内容
     *
     * @return 消息内容
     */
    public static String getContent() {
        // 天气
        Weather weather = WeatherUtil.getWeather();
        // 彩虹屁
        String caiHongPi = SkywalkerUtil.getCaiHongPi();
        // 一言
        Map<String, String> sentence = SkywalkerUtil.getSentence();
        // 生日
        int birthdayJie = MemorialDayUtil.getBirthdayJie();
        return "日期：" + weather.getDate() + " " + weather.getWeek() +
                " \n" +
                "墨白早上好呀！" +
                " \n" +
                "增城今日天气：" + weather.getTextNow() + "天" +
                " \n" +
                "增城今日平均温度：" + weather.getTemp() + "°" +
                " \n" +
                "增城今日最低温度：" + weather.getLow() + "°" +
                " \n" +
                "增城今日最高温度：" + weather.getHigh() + "°" +
                " \n" +
                "增城今日会有：" + weather.getTextDay() +
                " \n" +
                "增城今日有：" + weather.getWindClass() + "，" + weather.getWindDir() +
                " \n" +
                "距离墨白的生日还有" + birthdayJie + "日" +
                " \n" +
                "-----------------------------" +
                " \n" +
                "今日彩虹屁：" + caiHongPi +
                " \n" +
                "-----------------------------" +
                " \n" +
                "今日句子：" + sentence.get("zh") +
                " \n" +
                "今日句子：" + sentence.get("en");
    }
}
