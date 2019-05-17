package com.tomato.friends.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Description: 对FriendsOfUserGroupPO类进行封装
 * @Author: cuiwx
 * @CreateDate: 2019/5/17 12:51
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/17 12:51
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Setter
@Getter
@ToString
public class FriendsOfUserGroupDTO implements Serializable {
    private FriendsOfUserGroupPO friendsOfUserGroupPO;
    /**
     * 操作成功标识
     * 0 操作成功
     * 1 操作失败
     */
    private String flag;
}
