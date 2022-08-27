package com.mobaijun.util;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.mobaijun.model.Weather;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: WeatherUtils
 * description: 天气工具类
 *
 * @author MoBaiJun 2022/8/27 15:27
 */
public class WeatherUtil {

    /**
     * 获取每日天气
     *
     * @return 天气内容
     */
    public static Weather getWeather() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> map = new HashMap<>();
        // 地区行政代码
        map.put("district_id", "320583");
        // 这个是数据类型
        map.put("data_type", "all");
        // 百读请求
        map.put("ak", "AQrEuYfvMuKD1QW74qxnFLhI9aAKnT7j");
        String res = restTemplate.getForObject(
                "https://api.map.baidu.com/weather/v1/?district_id={district_id}&data_type={data_type}&ak={ak}",
                String.class,
                map);
        JSONObject json = JSONUtil.parseObj(res);
        JSONArray forecasts = json.getJSONObject("result").getJSONArray("forecasts");
        List<Weather> weathers = forecasts.toList(Weather.class);
        JSONObject now = json.getJSONObject("result").getJSONObject("now");
        Weather weather = weathers.get(0);
        weather.setTextNow(now.get("text").toString());
        weather.setTemp(now.get("temp").toString());
        weather.setWindClass(now.get("wind_class").toString());
        weather.setWindDir(now.get("wind_dir").toString());
        return weather;
    }
}
