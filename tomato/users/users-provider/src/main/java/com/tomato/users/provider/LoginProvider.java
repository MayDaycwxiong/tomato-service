package com.tomato.users.provider;

import com.tomato.users.api.user.LoginApi;
import com.tomato.users.biz.LoginService;
import com.tomato.users.dto.user.UserDTO;
import com.tomato.users.dto.user.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
* @Description:    登录接口提供者
* @Author:         cuiwx
* @CreateDate:     2019/5/7 22:51
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/7 22:51
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Service
public class LoginProvider implements LoginApi {

    @Autowired
    private LoginService loginService;

    @Override
    public UserDTO login(UserPO userPO) {
        return loginService.login(userPO);
    }
}
