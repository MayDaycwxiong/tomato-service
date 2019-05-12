package com.tomato.users.api.user;

import com.tomato.users.dto.user.UserDTO;
import com.tomato.users.dto.user.UserPO;

/**
 * @Description: users模块向外暴露的借口
 * @Author: cuiwx
 * @CreateDate: 2019/5/11 17:16
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/11 17:16
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface SelectAllUserInfoApi {
    /**
    * 方法实现说明    获取用户所有信息接口
    * @author      cuiwx
    * @date        2019/5/11 17:17
    */
    UserDTO selectAllUserInfo(UserPO userPO);
}
