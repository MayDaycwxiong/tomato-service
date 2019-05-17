package com.tomato.friends.extbean.friendsList;

import com.tomato.friends.dto.FriendsOfUserGroupPO;
import com.tomato.friends.dto.UserGroupPO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
* @Description:    好友列表数组，
* @Author:         cuiwx
* @CreateDate:     2019/5/17 15:40
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/17 15:40
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@ToString
@Getter
@Setter
public class UserGroupInfo implements Serializable {
    /**
     * 用户分组信息
     */
    private UserGroupPO userGroupPO;
    /**
     * 分组下的好友列表信息
     */
    private List<FriendInfo> friendInfoList;
}
