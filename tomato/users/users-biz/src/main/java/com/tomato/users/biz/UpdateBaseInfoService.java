package com.tomato.users.biz;

import com.tomato.users.dto.user.UserDTO;
import com.tomato.users.dto.user.UserPO;

/**
* @Description:    更新用户信息Service接口
* @Author:         cuiwx
* @CreateDate:     2019/5/11 0:10
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/11 0:10
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public interface UpdateBaseInfoService {
    /**
    * 方法实现说明    更新用户信息接口
    * @author      cuiwx
    * @date        2019/5/11 0:11
    */
    UserDTO updateBaseInfo(UserPO userPO);
}
