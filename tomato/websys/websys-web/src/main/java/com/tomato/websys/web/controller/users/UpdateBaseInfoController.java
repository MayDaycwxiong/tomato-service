package com.tomato.websys.web.controller.users;

import com.tomato.common.ObjectUtil;
import com.tomato.users.api.user.UpdateBaseInfoApi;
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
 * @Description: 更新用户基本信息Controller
 * @Author: cuiwx
 * @CreateDate: 2019/5/10 19:40
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/10 19:40
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Api(tags = "更新用户基本信息Restful接口")
@Slf4j
@RestController
@RequestMapping("/users")
public class UpdateBaseInfoController {
    @Autowired
    private UpdateBaseInfoApi updateBaseInfoApi;

    @ApiOperation(value = "更新用户信息，基本信息必填一个")
    @PostMapping("/updateBaseInfo.pub")
    public UserDTO updateBaseInfo(UserPO userPO) {
        if(ObjectUtil.isNull(userPO)){
            log.info("Object is null");
        }else{
            log.info("请求参数:{}",userPO.toString());
        }
        return updateBaseInfoApi.updateBaseInfo(userPO);
    }
}
