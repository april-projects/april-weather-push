package com.mobaijun.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: MemorialDayUtil
 * description: 纪念日
 *
 * @author MoBaiJun 2022/8/27 19:52
 */
public class MemorialDayUtil {
    public static int getBirthdayJie() {
        try {
            return calculationBirthday("1999-02-21");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static int calculationBirthday(String climate) throws ParseException {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        // 存今天
        Calendar cToday = Calendar.getInstance();
        // 存生日
        Calendar cBirth = Calendar.getInstance();
        // 设置生日
        cBirth.setTime(myFormatter.parse(climate));
        // 修改为本年
        cBirth.set(Calendar.YEAR, cToday.get(Calendar.YEAR));
        int days;
        if (cBirth.get(Calendar.DAY_OF_YEAR) < cToday.get(Calendar.DAY_OF_YEAR)) {
            // 生日已经过了，要算明年的了
            days = cToday.getActualMaximum(Calendar.DAY_OF_YEAR) - cToday.get(Calendar.DAY_OF_YEAR);
            days += cBirth.get(Calendar.DAY_OF_YEAR);
        } else {
            // 生日还没过
            days = cBirth.get(Calendar.DAY_OF_YEAR) - cToday.get(Calendar.DAY_OF_YEAR);
        }
        // 输出结果
        return days;
    }
}
