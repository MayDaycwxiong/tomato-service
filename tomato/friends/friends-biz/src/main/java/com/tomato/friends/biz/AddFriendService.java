package com.tomato.friends.biz;

import com.tomato.friends.dto.FriendsOfUserGroupDTO;
import com.tomato.friends.dto.FriendsOfUserGroupPO;

/**
 * @Description: 添加好友Service接口
 * @Author: cuiwx
 * @CreateDate: 2019/5/17 13:04
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/17 13:04
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface AddFriendService {
    /**
     * 方法实现说明    添加好友接口
     *
     * @author cuiwx
     * @date 2019/5/17 13:05
     */
    FriendsOfUserGroupDTO addFriend(FriendsOfUserGroupPO friendsOfUserGroupPO);
}
