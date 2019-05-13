package com.tomato.websys.web.controller.users;

import com.tomato.common.ObjectUtil;
import com.tomato.users.api.user.SelectAllUserInfoApi;
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
 * @Description: 获取用户所有信息Controller
 * @Author: cuiwx
 * @CreateDate: 2019/5/11 17:14
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/11 17:14
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Slf4j
@Api(tags = "获取用户所有信息Restful接口")
@RestController
@RequestMapping("/users")
public class SelectAllUserInfoController {
    @Autowired
    private SelectAllUserInfoApi selectAllUserInfoApi;

    @ApiOperation(value = "获取用户所有的信息")
    @PostMapping("/selectAllUserInfo.pub")
    public UserDTO selectAllUserInfo(UserPO userPO) {
        if (ObjectUtil.isNull(userPO)) {
            log.info("Object is null");
        } else {
            log.info("请求参数为:{}", userPO.toString());
        }
        return selectAllUserInfoApi.selectAllUserInfo(userPO);
    }
}
