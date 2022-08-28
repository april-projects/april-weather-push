# april-weather-push

企业微信每日天气推送项目

请求地址：https://mp.weixin.qq.com/debug/cgi-bin/sandboxinfo?action=showinfo&t=sandbox/index



### 模板消息

~~~tex
日期：2022-08-27 星期六
墨白早上好呀！
今日天气：阴
今天平均温度：25
今日最低温度：25
今日最高温度：27
今天会有：小雨
今天有：1级，东北风
距离墨白的生日还有132天
-----------------------------
今日彩虹屁：她的脸上不是汗水，而是玫瑰花的露水。
-----------------------------
今日句子：不学习的人,象不长谷物的荒地.
今日句子：An ignorant man is like a piece of barren land.
~~~
* 模板源拼接字符串
~~~java
"日期：" + weather.getDate() + " " + weather.getWeek() +
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
~~~



> 参考文章：
>
> [公众号推送早安问候以及天气预报(JAVA)](https://blog.csdn.net/qq_45408390/article/details/126251729)
