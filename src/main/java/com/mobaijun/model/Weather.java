package com.mobaijun.model;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: Weather
 * description: 天气推送内容
 *
 * @author MoBaiJun 2022/8/27 15:21
 */
public class Weather {
    private String name;
    private String areaName;
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

    public String getWdNight() {
        return wdNight;
    }

    public void setWdNight(String wdNight) {
        this.wdNight = wdNight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getTextNight() {
        return textNight;
    }

    public void setTextNight(String textNight) {
        this.textNight = textNight;
    }

    public String getWdDay() {
        return wdDay;
    }

    public void setWdDay(String wdDay) {
        this.wdDay = wdDay;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getWcNight() {
        return wcNight;
    }

    public void setWcNight(String wcNight) {
        this.wcNight = wcNight;
    }

    public String getTextDay() {
        return textDay;
    }

    public void setTextDay(String textDay) {
        this.textDay = textDay;
    }

    public String getWcDay() {
        return wcDay;
    }

    public void setWcDay(String wcDay) {
        this.wcDay = wcDay;
    }

    public String getTextNow() {
        return textNow;
    }

    public void setTextNow(String textNow) {
        this.textNow = textNow;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWindClass() {
        return windClass;
    }

    public void setWindClass(String windClass) {
        this.windClass = windClass;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "name='" + name + '\'' +
                ", areaName='" + areaName + '\'' +
                ", wdNight='" + wdNight + '\'' +
                ", date='" + date + '\'' +
                ", high='" + high + '\'' +
                ", week='" + week + '\'' +
                ", textNight='" + textNight + '\'' +
                ", wdDay='" + wdDay + '\'' +
                ", low='" + low + '\'' +
                ", wcNight='" + wcNight + '\'' +
                ", textDay='" + textDay + '\'' +
                ", wcDay='" + wcDay + '\'' +
                ", textNow='" + textNow + '\'' +
                ", temp='" + temp + '\'' +
                ", windClass='" + windClass + '\'' +
                ", windDir='" + windDir + '\'' +
                '}';
    }
}
