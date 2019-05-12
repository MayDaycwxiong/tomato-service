package com.tomato.users.biz;

import com.tomato.users.dto.user.UserDTO;
import com.tomato.users.dto.user.UserPO;

/**
 * @Description: 登录service接口
 * @Author: cuiwx
 * @CreateDate: 2019/5/7 22:52
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/7 22:52
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface LoginService {
    /**
     * 方法实现说明    登录接口
     *
     * @author cuiwx
     * @date 2019/5/7 22:52
     */
    UserDTO login(UserPO userPO);

}
