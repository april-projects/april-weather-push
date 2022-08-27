package com.mobaijun.util;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.mobaijun.constant.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: SkywalkerUtil
 * description: 天行数据 api
 *
 * @author MoBaiJun 2022/8/27 19:31
 */
public class SkywalkerUtil {

    /**
     * 彩虹屁
     *
     * @return 句子
     */
    public static String getCaiHongPi() {
        String format = String.format(Constant.CAI_HONG_PI, Constant.TIN_API);
        JSONObject jsonObject = JSONUtil.parseObj(HttpUtil.get(format));
        JSONArray newsList = jsonObject.getJSONArray(Constant.NEWS_LIST);
        return newsList.getJSONObject(0).get(Constant.CONTENT).toString();
    }

    /**
     * 每日一句英文
     *
     * @return 内容体
     */
    public static Map<String, String> getSentence() {
        String format = String.format(Constant.SENTENCE, Constant.TIN_API);
        JSONObject jsonObject = JSONUtil.parseObj(HttpUtil.get(format));
        JSONArray newsList = jsonObject.getJSONArray(Constant.NEWS_LIST);
        String en = newsList.getJSONObject(0).get("en").toString();
        String zh = newsList.getJSONObject(0).get("zh").toString();
        Map<String, String> map = new HashMap<>(1);
        map.put("zh", zh);
        map.put("en", en);
        return map;
    }
}
