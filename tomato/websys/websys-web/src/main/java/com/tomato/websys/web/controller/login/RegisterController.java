package com.tomato.websys.web.controller.login;

import com.tomato.common.ObjectUtil;
import com.tomato.users.api.user.RegisterApi;
import com.tomato.users.dto.user.UserDTO;
import com.tomato.users.dto.user.UserPO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @Description:    用户注册Controller
* @Author:         cuiwx
* @CreateDate:     2019/5/12 17:03
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/12 17:03
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Slf4j
@Api(tags = "用户注册Restful接口")
@RestController
@RequestMapping("/users")
public class RegisterController {

    @Autowired
    private RegisterApi registerApi;

    @ApiOperation(value = "返回一个账号")
    @PostMapping("/register.pub")
    public UserDTO register(UserPO userPO){
        if(ObjectUtil.isNull(userPO)){
            log.info("用户申请账号");
        }else{
            log.info("用户注册事件,请求参数为{}",userPO.toString());
        }
        return registerApi.register(userPO);
    }
}
