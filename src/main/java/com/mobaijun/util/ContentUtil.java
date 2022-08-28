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
                "地区：" + weather.getAreaName() +
                " \n" +
                "----------------------------------" +
                " \n" +
                "纵然世间黑暗，仍有一点星光。" +
                " \n" +
                "----------------------------------" +
                " \n" +
                weather.getName() + "今日可能会有：" + weather.getTextNow() +
                " \n" +
                weather.getName() + "今日多时为：" + weather.getTextDay() + "天" +
                " \n" +
                weather.getName() + "今日可能有：" + weather.getWindClass() + "，" + weather.getWindDir() +
                " \n" +
                weather.getName() + "当前气温：" + weather.getTemp() + "℃" +
                " \n" +
                weather.getName() + "今日最低温度：" + weather.getLow() + "℃" +
                " \n" +
                weather.getName() + "今日最高温度：" + weather.getHigh() + "℃" +
                " \n" +
                "距离墨白的生日还有" + birthdayJie + "天" +
                " \n" +
                "----------------------------------" +
                " \n" +
                "每日一夸：" + caiHongPi +
                " \n" +
                "----------------------------------" +
                " \n" +
                "每日一句：" + sentence.get("zh") +
                " \n" +
                "每日一句：" + sentence.get("en");
    }
}
