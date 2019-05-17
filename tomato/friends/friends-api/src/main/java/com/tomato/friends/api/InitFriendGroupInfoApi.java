package com.tomato.friends.api;

import com.tomato.friends.dto.UserGroupDTO;
import com.tomato.friends.dto.UserGroupPO;
import com.tomato.friends.extbean.friendsList.FriendsListDTO;

/**
 * @Description: 创建好友分组信息
 * @Author: cuiwx
 * @CreateDate: 2019/5/17 2:18
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/17 2:18
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface InitFriendGroupInfoApi {
    /**
     * 方法实现说明    初始化好友分组
     *
     * @author cuiwx
     * @date 2019/5/17 2:22
     */
    UserGroupDTO createFriendGroupInfo(UserGroupPO userGroupPO);

    /**
     * 方法实现说明    获取好友列表信息接口
     *
     * @author cuiwx
     * @date 2019/5/17 12:49
     */
    FriendsListDTO getFriendsList(UserGroupPO userGroupPO);
}
