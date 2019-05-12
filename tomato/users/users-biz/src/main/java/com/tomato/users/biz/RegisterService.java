package com.tomato.users.biz;

import com.tomato.users.dto.user.UserDTO;
import com.tomato.users.dto.user.UserPO;

/**
 * @Description: 注册Service接口
 * @Author: cuiwx
 * @CreateDate: 2019/5/12 17:14
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/12 17:14
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface RegisterService {
    /**
     * 方法实现说明    注册接口
     *
     * @author cuiwx
     * @date 2019/5/12 17:15
     */
    UserDTO register(UserPO userPO);
}
