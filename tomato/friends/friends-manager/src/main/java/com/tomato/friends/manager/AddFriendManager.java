package com.tomato.friends.manager;

import com.tomato.common.ObjectUtil;
import com.tomato.friends.dao.FriendsOfUserGroupPOMapper;
import com.tomato.friends.dto.FriendsOfUserGroupPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* @Description:    添加好友Manager
* @Author:         cuiwx
* @CreateDate:     2019/5/17 13:10
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/17 13:10
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Slf4j
@Component
public class AddFriendManager {

    @Autowired
    private FriendsOfUserGroupPOMapper friendsOfUserGroupPOMapper;

    public int addFriend(FriendsOfUserGroupPO friendsOfUserGroupPO){
        log.info("待插入的数据为{}",friendsOfUserGroupPO.toString());
        return friendsOfUserGroupPOMapper.insertSelective(friendsOfUserGroupPO);
    }

    public int exsist(FriendsOfUserGroupPO friendsOfUserGroupPO){
        String friendId=friendsOfUserGroupPO.getFriend();
        log.info("判断tb_user表中是否有好友信息，当前好友Id为{}",friendId);
        return friendsOfUserGroupPOMapper.existsFriends(friendId);
    }
}
