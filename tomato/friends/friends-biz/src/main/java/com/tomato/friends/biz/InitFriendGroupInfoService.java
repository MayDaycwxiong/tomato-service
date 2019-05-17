package com.tomato.friends.biz;

import com.tomato.friends.dto.UserGroupDTO;
import com.tomato.friends.dto.UserGroupPO;
import com.tomato.friends.extbean.friendsList.FriendsListDTO;

/**
 * @Description: 初始化好友分组Service接口
 * @Author: cuiwx
 * @CreateDate: 2019/5/17 2:35
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/17 2:35
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface InitFriendGroupInfoService {
    /**
     * 方法实现说明    初始化好友分组
     *
     * @author cuiwx
     * @date 2019/5/17 2:36
     */
    UserGroupDTO createFriendGroupInfo(UserGroupPO userGroupPO);

    /**
     * 方法实现说明    获取好友列表
     *
     * @author cuiwx
     * @date 2019/5/17 17:20
     */
    FriendsListDTO getFriendsList(UserGroupPO userGroupPO);
}
