package com.tomato.users.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @Description:    用户信息中的Date类型转换
* @Author:         cuiwx
* @CreateDate:     2019/5/12 10:46
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/12 10:46
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class DateTranslate {
    /**
    * 方法实现说明    字符串转换为日期类型
    * @author      cuiwx
    * @date        2019/5/12 10:47
    */
    public static Date translateToDate(String date) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(date);
    }
}
