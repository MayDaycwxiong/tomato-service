package com.tomato.friends.extbean.friendsList;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Description: 对分组下的好友信息(分组表中friend - > 用户表中的记录)进行封装
 * @Author: cuiwx
 * @CreateDate: 2019/5/17 16:00
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/17 16:00
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Setter
@Getter
@ToString
public class FriendInfo implements Serializable {
    /**
     * 好友信息
     */
    private UserPO userPO;
    /**
     * 好友账号(userid)
     */
    private String friendId;
}
