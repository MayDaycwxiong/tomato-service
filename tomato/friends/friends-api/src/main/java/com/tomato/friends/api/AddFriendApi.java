package com.tomato.friends.api;

import com.tomato.friends.dto.FriendsOfUserGroupDTO;
import com.tomato.friends.dto.FriendsOfUserGroupPO;

/**
 * @Description: 添加好友
 * @Author: cuiwx
 * @CreateDate: 2019/5/17 12:50
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/17 12:50
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface AddFriendApi {
    /**
     * 方法实现说明    添加好友接口
     *
     * @author cuiwx
     * @date 2019/5/17 12:54
     */
    FriendsOfUserGroupDTO addFriend(FriendsOfUserGroupPO friendsOfUserGroupPO);
}
