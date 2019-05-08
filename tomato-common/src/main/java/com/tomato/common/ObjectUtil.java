package com.tomato.common;
/**
* @Description:    对象工具
* @Author:         cuiwx
* @CreateDate:     2019/5/8 19:28
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/8 19:28
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class ObjectUtil {
    /**
    * 方法实现说明    对象为空判断
    * @author      cuiwx
    * @date        2019/5/8 19:30
    */
    public static boolean isNull(Object object){
        if(object==null){
            return true;
        }
        return false;
    }
    public static boolean isNotNull(Object object){
        if(object!=null){
           return true;
        }
        return false;
    }
}
