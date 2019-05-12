package com.tomato.common;
/**
 * @Description:    字符串工具
 * @Author:         cuiwx
 * @CreateDate:     2019/5/11 16:37
 * @UpdateUser:     cuiwx
 * @UpdateDate:     2019/5/11 16:37
 * @UpdateRemark:   修改内容
 * @Version:        1.0
 */
public class StringUtil {
    /**
     * 方法实现说明    字符串为空判断
     * @author      cuiwx
     * @date        2019/5/11 16:37
     */
    public static boolean isEmpty(String string){
        if(string==null||string.equals("")){
            return true;
        }
        return false;
    }
    public static boolean isNotEmpty(String string){
        return !isEmpty(string);
    }

}
