package com.tomato.users.provider;

import com.tomato.users.api.user.RegisterApi;
import com.tomato.users.biz.RegisterService;
import com.tomato.users.dto.user.UserDTO;
import com.tomato.users.dto.user.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
* @Description:    注册接口提供者
* @Author:         cuiwx
* @CreateDate:     2019/5/12 17:09
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/12 17:09
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Service
public class RegisterProvider implements RegisterApi {

    @Autowired
    private RegisterService registerService;

    @Override
    public UserDTO register(UserPO userPO) {
        return registerService.register(userPO);
    }
}
