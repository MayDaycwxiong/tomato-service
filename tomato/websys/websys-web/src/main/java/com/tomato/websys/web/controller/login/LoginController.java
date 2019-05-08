package com.tomato.websys.web.controller.login;

import com.tomato.common.ObjectUtil;
import com.tomato.users.api.user.LoginApi;
import com.tomato.users.dto.user.UserDTO;
import com.tomato.users.dto.user.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
* @Description:    用户登录Controller
* @Author:         cuiwx
* @CreateDate:     2019/5/7 22:50
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/7 22:50
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Slf4j
@RestController
@RequestMapping("/users")
public class LoginController {

    @Autowired
    private LoginApi loginApi;

    @PostMapping("/login.pub")
    public UserDTO login(UserPO userPO){
        if(ObjectUtil.isNull(userPO)){
            log.info("Object is null");
        }else{
            log.info("请求参数:{}",userPO.toString());
        }
        return loginApi.login(userPO);
    }

}
