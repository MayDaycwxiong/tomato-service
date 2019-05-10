package com.tomato.users.api.user;

import com.tomato.users.dto.user.UserDTO;
import com.tomato.users.dto.user.UserPO;

/**
* @Description:    users模块向外暴露的接口
* @Author:         cuiwx
* @CreateDate:     2019/5/10 23:56
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/10 23:56
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public interface UpdateBaseInfoApi {
    /**
    * 方法实现说明    更新接口
    * @author      cuiwx
    * @date        2019/5/10 23:57
    */
    UserDTO updateBaseInfo(UserPO userPO);
}
