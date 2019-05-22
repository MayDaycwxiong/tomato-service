package com.tomato.websys.web.controller.friends;

import com.tomato.common.ObjectUtil;
import com.tomato.friends.api.AddFriendApi;
import com.tomato.friends.dto.FriendsOfUserGroupDTO;
import com.tomato.friends.dto.FriendsOfUserGroupPO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @Description:    添加好友Controller
* @Author:         cuiwx
* @CreateDate:     2019/5/17 12:58
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/17 12:58
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Slf4j
@Api(tags = "添加好友Restful接口")
@RestController
@RequestMapping("/friends")
public class AddFriendController {

    @Autowired
    private AddFriendApi addFriendApi;

    @ApiOperation(value = "添加好友")
    @PostMapping("/addFriend.pub")
    public FriendsOfUserGroupDTO addFriend(FriendsOfUserGroupPO friendsOfUserGroupPO){
        if(ObjectUtil.isNull(friendsOfUserGroupPO)){
            log.info("Object is null");
        }else{
            log.info("请求参数为{}",friendsOfUserGroupPO.toString());
        }
        return addFriendApi.addFriend(friendsOfUserGroupPO);
    }
}
