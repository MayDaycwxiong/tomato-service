package com.tomato.common;

import java.util.List;

/**
 * @Description: 集合工具类
 * @Author: cuiwx
 * @CreateDate: 2019/5/13 14:55
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/13 14:55
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class CollectionUtil {
    /**
     * 方法实现说明    集合不为空判断
     *
     * @author cuiwx
     * @date 2019/5/13 14:59
     */
    public static boolean isNotEmpty(Object object) {
        if (object instanceof List) {
            if (ObjectUtil.isNotNull(object) && ((List) object).size() > 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEmpty(Object object) {
        return !isNotEmpty(object);
    }
}
