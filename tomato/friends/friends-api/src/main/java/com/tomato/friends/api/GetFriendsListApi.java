package com.tomato.friends.api;

import com.tomato.friends.dto.UserGroupPO;
import com.tomato.friends.extbean.friendsList.FriendsListDTO;


/**
 * @Description: 获取好友列表信息
 * @Author: cuiwx
 * @CreateDate: 2019/5/17 12:37
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/17 12:37
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface GetFriendsListApi {
    /**
     * 方法实现说明    获取好友列表信息接口
     *
     * @author cuiwx
     * @date 2019/5/17 12:49
     */
    FriendsListDTO getFriendsList(UserGroupPO userGroupPO);
}
