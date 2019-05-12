package com.tomato.users.biz;

import com.tomato.users.dto.user.UserDTO;
import com.tomato.users.dto.user.UserPO;

/**
 * @Description: 获取用户所有信息Service接口
 * @Author: cuiwx
 * @CreateDate: 2019/5/11 17:25
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/11 17:25
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface SelectAllUserInfoService {
    /**
     * 方法实现说明    获取用户所有信息
     *
     * @author cuiwx
     * @date 2019/5/11 17:26
     */
    UserDTO selectAllUserInfo(UserPO userPO);
}
