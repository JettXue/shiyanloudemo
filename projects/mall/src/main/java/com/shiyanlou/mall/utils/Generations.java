package com.shiyanlou.mall.utils;/**
 * @Author jettx
 * @Date 3/24/2020 10:20 AM
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author Jettx
 * @date 3/24/2020 10:20 AM
 */
public class Generations {

    public static StringBuilder generateFilename(String suffixname) {
        Random r = new Random();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        StringBuilder tmpname = new StringBuilder();
        tmpname.append(sdf.format(new Date())).append(r.nextInt(100)).append(suffixname);
        return tmpname;
    }
}
