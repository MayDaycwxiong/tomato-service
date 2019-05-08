package com.tomato.users.dto.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
* @Description:    UserPO返回的DTO类
* @Author:         cuiwx
* @CreateDate:     2019/5/8 19:41
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/8 19:41
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Setter
@Getter
@ToString
public class UserDTO implements Serializable {
    /**
     * 包装的userPO类
     */
    private UserPO userPO;
    /**
     * 验证标志
     * 0 请求成功
     * 1 请求失败
     */
    private String flag;
}
