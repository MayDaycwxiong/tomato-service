package com.tomato.users.api.user;

import com.tomato.users.dto.user.UserDTO;
import com.tomato.users.dto.user.UserPO;

/**
* @Description:    users模块向外暴露的接口
* @Author:         cuiwx
* @CreateDate:     2019/5/7 10:53
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/7 10:53
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public interface LoginApi {
    /**
    * 方法实现说明    登录接口
    * @author      cuiwx
    * @date        2019/5/7 10:56
    */
    UserDTO login(UserPO userPO);

}
