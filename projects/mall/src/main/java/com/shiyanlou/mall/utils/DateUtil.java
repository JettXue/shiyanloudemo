package com.shiyanlou.mall.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Jettx
 * @date 3/25/2020 2:52 PM
 */
public class DateUtil {

    /**
     * 格式化date
     *
     * @param date
     * @return
     */
    public static String getDateString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }
}
