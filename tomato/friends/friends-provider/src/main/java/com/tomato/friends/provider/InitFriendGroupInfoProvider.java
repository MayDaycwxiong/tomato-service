package com.tomato.friends.provider;

import com.tomato.friends.api.InitFriendGroupInfoApi;
import com.tomato.friends.biz.InitFriendGroupInfoService;
import com.tomato.friends.dto.UserGroupDTO;
import com.tomato.friends.dto.UserGroupPO;
import com.tomato.friends.extbean.friendsList.FriendsListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @Description:    新建好友分组接口提供者
* @Author:         cuiwx
* @CreateDate:     2019/5/17 2:24
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/17 2:24
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Service
public class InitFriendGroupInfoProvider implements InitFriendGroupInfoApi{

    @Autowired
    private InitFriendGroupInfoService initFriendGroupInfoService;

    @Override
    public UserGroupDTO createFriendGroupInfo(UserGroupPO userGroupPO) {
        return initFriendGroupInfoService.createFriendGroupInfo(userGroupPO);
    }

    @Override
    public FriendsListDTO getFriendsList(UserGroupPO userGroupPO) {
        return initFriendGroupInfoService.getFriendsList(userGroupPO);
    }
}
