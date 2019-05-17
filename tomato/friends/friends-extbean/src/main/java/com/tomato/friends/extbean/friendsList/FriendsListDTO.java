package com.tomato.friends.extbean.friendsList;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 对好友分组信息UserGroupInfo进行封装
 * @Author: cuiwx
 * @CreateDate: 2019/5/17 17:04
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/17 17:04
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@ToString
@Setter
@Getter
public class FriendsListDTO implements Serializable {
    /**
     * 好友分组信息
     */
    private List<UserGroupInfo> userGroupInfoList;
    /**
     * 获取分组信息标识
     * 0 成功
     * 1 失败
     */
    private String flag;
}
