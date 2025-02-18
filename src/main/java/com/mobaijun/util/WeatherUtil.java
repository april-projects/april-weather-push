package com.mobaijun.util;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.mobaijun.constant.Constant;
import com.mobaijun.model.Location;
import com.mobaijun.model.Weather;

import java.util.List;

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
        // 参数1：地区行政代码，参数2：这个是数据类型，参数3：百度请求AK
        String format = String.format(Constant.DU_TQ, "440118", "all", "AQrEuYfvMuKD1QW74qxnFLhI9aAKnT7j");
        JSONObject json = JSONUtil.parseObj(HttpUtil.get(format));
        JSONObject result = json.getJSONObject("result");

        // 未来五天天气
        JSONArray forecasts = result.getJSONArray("forecasts");
        List<Weather> weathers = forecasts.toList(Weather.class);

        // 当日天气
        JSONObject now = result.getJSONObject("now");
        Weather weather = weathers.get(0);
        weather.setTextNow(now.get("text").toString());
        weather.setTemp(now.get("temp").toString());
        weather.setWindClass(now.get("wind_class").toString());
        weather.setWindDir(now.get("wind_dir").toString());

        // 地区信息
        Location location = result.get("location", Location.class);
        weather.setAreaName(location.getProvince() + location.getCity() + location.getName() + "区");
        weather.setName(location.getName());
        return weather;
    }
}
