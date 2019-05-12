package com.tomato.websys.common;


import com.tomato.common.StringUtil;
import com.tomato.users.dto.user.UserPO;
import lombok.extern.slf4j.Slf4j;
import sun.security.provider.MD2;

/**
 * @Description: 参数校验工具
 * @Author: cuiwx
 * @CreateDate: 2019/5/11 16:50
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/11 16:50
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Slf4j
public class ParamCheckUtil {
    /**
    * 方法实现说明    用户登陆信息检验
    * @author      cuiwx
    * @date        2019/5/11 17:13
    */
    public static void checkPasswordParam(UserPO userPO) {
        if (StringUtil.isNotEmpty(userPO.getUserid()) && StringUtil.isNotEmpty(userPO.getUserpassword())) {
            log.info("用户名{}和密码{}不为空", userPO.getUserid(), userPO.getUserpassword());
        } else if (StringUtil.isNotEmpty(userPO.getUserid()) && StringUtil.isEmpty(userPO.getUserpassword())) {
            log.info("用户名不为空{}和密码为空", userPO.getUserid());
        } else if (StringUtil.isEmpty(userPO.getUserid()) && StringUtil.isNotEmpty(userPO.getUserpassword())) {
            log.info("用户名为空和密码{}不为空", userPO.getUserpassword());
        } else {
            log.info("用户名和密码为空");
        }
    }
}
