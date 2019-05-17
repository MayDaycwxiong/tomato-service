package com.tomato.websys.web.controller.friends;

import com.tomato.common.ObjectUtil;
import com.tomato.friends.api.InitFriendGroupInfoApi;
import com.tomato.friends.dto.UserGroupDTO;
import com.tomato.friends.dto.UserGroupPO;
import com.tomato.friends.extbean.friendsList.FriendsListDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @Description:    初始化好友分组Controller
* @Author:         cuiwx
* @CreateDate:     2019/5/17 2:27
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/17 2:27
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Slf4j
@Api(tags = "初始化好友分组Restful接口")
@RestController
@RequestMapping("/friends")
public class InitFriendGroupInfoController {

    @Autowired
    private InitFriendGroupInfoApi initFriendGroupInfoApi;

    @ApiOperation(value = "初始化好友分组")
    @PostMapping("/initFriendGroupInfo.pub")
    public UserGroupDTO createFriendGroupInfo(UserGroupPO userGroupPO){
        if(ObjectUtil.isNull(userGroupPO)){
            log.info("Object is null");
        }else{
            log.info("请求参数为{}",userGroupPO.toString());
        }
        return initFriendGroupInfoApi.createFriendGroupInfo(userGroupPO);
    }

    @ApiOperation(value = "获取好友列表")
    @PostMapping("/getFriendsList.pub")
    public FriendsListDTO getFriendsList(UserGroupPO userGroupPO){
        if(ObjectUtil.isNull(userGroupPO)){
            log.info("Object is null");
        }else{
            log.info("请求参数为{}",userGroupPO.toString());
        }
        return initFriendGroupInfoApi.getFriendsList(userGroupPO);
    }

}
