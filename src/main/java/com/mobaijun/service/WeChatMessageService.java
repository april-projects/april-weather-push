package com.mobaijun.service;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import com.mobaijun.constant.Constant;

import javax.net.ssl.HttpsURLConnection;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: WeChatMessageService
 * description: 企业微信消息推送实现类
 *
 * @author MoBaiJun 2022/8/27 21:31
 */
public class WeChatMessageService {
    /**
     * tools log
     */
    private static final Log log = Log.get(WeChatMessageService.class);

    /**
     * 企业Id
     */
    private static final String CORPID = "wwd0fd33ee4f5c1073";

    /**
     * 应用私钥
     */
    private static final String CORPSECRET = "CNvaIJWS75ROUYi9ocNKP0mCJcLGVH5BoQLYI8zWtL0";

    /**
     * 获取访问权限码（access_token）URL  GET请求
     */
    private static final String ACCESS_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=CORPID&corpsecret=CORPSECRET";

    /**
     * 发送消息URL POST请求
     */
    private static final String SEND_MESSAGE_URL = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=";

    /**
     * 获取企业微信用户userid POST请求
     */
    private static final String GET_USERID_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserid?access_token=";

    /**
     * 获取部门列表地址 get请求
     */
    private static final String GET_DEPARTMENT_LIST_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=";

    /**
     * 获取部门成员详情地址 get请求
     */
    private static final String GET_USER_LIST_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/list";


    /**
     * 获取token
     *
     * @return token
     */
    public static String getAccessToken() {
        //获取token
        String url = ACCESS_TOKEN_URL.replaceAll("CORPID", CORPID).replaceAll("CORPSECRET", CORPSECRET);
        String result = HttpUtil.get(url);
        JSONObject jsonObject = JSONUtil.parseObj(result);
        String accessToken = jsonObject.get("access_token").toString();
        log.error("token 是：{}", accessToken);
        return accessToken;
    }

    /**
     * 根据电话号码获取userId
     *
     * @param token         token
     * @param employeePhone 手机号
     * @return 用户id
     */
    public static String getUserId(String token, String employeePhone) {
        String json = "{" +
                "\"mobile\":" + "\"" + employeePhone + "\"" +
                "}";
        String result = "";
        String url = GET_USERID_URL + token;
        try {
            HttpsURLConnection http = getPostHttp(url, "");
            OutputStream os = http.getOutputStream();
            os.write(json.getBytes(StandardCharsets.UTF_8));
            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] jsonBytes = new byte[size];
            is.read(jsonBytes);
            result = new String(jsonBytes, StandardCharsets.UTF_8);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSONUtil.parseObj(result);
        if (jsonObject.get("errmsg") != null) {
            log.error("该IP地址未在企业可信IP配置，请配置后重新尝试：{}", jsonObject.get("errmsg"));
            return null;
        }
        return jsonObject.get("userid").toString();
    }

    /**
     * 发送 post 请求 hutool 可替代
     *
     * @param action 地址
     * @param token  token
     * @return 链接
     */
    public static HttpsURLConnection getPostHttp(String action, String token) {
        URL url = null;
        HttpsURLConnection http = null;
        try {
            url = new URL(action);
            http = (HttpsURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            if (StrUtil.isNotBlank(token)) {
                http.setRequestProperty("token", token);
            }
            http.setDoOutput(true);
            http.setDoInput(true);
            // 连接超时30秒
            System.setProperty("sun.net.client.defaultConnectTimeout", "30000");
            // 读取超时30秒
            System.setProperty("sun.net.client.defaultReadTimeout", "30000");
            http.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return http;
    }

    /**
     * 发送微信消息
     */
    public static void sendMessage(String token, String json) {
        //请求链接
        String action = SEND_MESSAGE_URL + token;
        try {
            HttpRequest.post(action)
                    .body(json)
                    .execute().body();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取微信所有用户
     *
     * @return JSON 集合
     */
    public List<JSONObject> getWechatAllUser() {
        // 获取token

        String token = getAccessToken();
        String template = GET_USER_LIST_URL + Constant.TEMPLATE;
        String str = StrUtil.format(template, token);
        String userResult = HttpUtil.get(str);
        JSONObject jsonUser = JSONUtil.parseObj(userResult);
        // 返回结果
        List<JSONObject> resultJsonList = new ArrayList<>();
        if (Constant.ZERO.equals(jsonUser.get(Constant.ERROR_CODE))) {
            String userListStr = jsonUser.get(Constant.USER_LIST).toString();
            JSONArray userList = JSONUtil.parseArray(userListStr);
            resultJsonList = JSONUtil.toList(userList.toJSONString(userList.size()), JSONObject.class);
        }
        return resultJsonList;
    }
}