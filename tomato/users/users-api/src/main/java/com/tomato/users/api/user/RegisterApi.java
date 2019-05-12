package com.tomato.users.api.user;

import com.tomato.users.dto.user.UserDTO;
import com.tomato.users.dto.user.UserPO;

/**
 * @Description: users模块向外暴露的接口
 * @Author: cuiwx
 * @CreateDate: 2019/5/12 17:07
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/12 17:07
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface RegisterApi {
    /**
     * 方法实现说明    注册接口
     *
     * @author cuiwx
     * @date 2019/5/12 17:08
     */
    UserDTO register(UserPO userPO);
}
