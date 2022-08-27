package com.mobaijun.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: Weather
 * description: 天气推送内容
 *
 * @author MoBaiJun 2022/8/27 15:21
 */
@Getter
@Setter
@ToString
public class Weather {
    private String wdNight;

    private String date;

    private String high;

    private String week;

    private String textNight;

    private String wdDay;

    private String low;

    private String wcNight;

    private String textDay;

    private String wcDay;

    /**
     * 当前天气
     */
    private String textNow;

    /**
     * 当前温度
     */
    private String temp;

    /**
     * 风级大小
     */
    private String windClass;

    /**
     * 风向
     */
    private String windDir;
}
