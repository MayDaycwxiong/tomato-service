package com.tomato.friends.extbean.friendsList;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
* @Description:    好友分组信息sql ResultMap返回映射类
* @Author:         cuiwx
* @CreateDate:     2019/5/17 16:03
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/17 16:03
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Getter
@Setter
@ToString
public class ResultListSql implements Serializable {
    /**
     * 分组id
     */
    private Integer usergroupid;
    /**
     * 用户id 即userid(获取的是该用户的分组)
     */
    private String userid;
    /**
     * 分组名
     */
    private String usergroupname;
    /**
     * 好友id(userid)
     */
    private String friend;
    /**
     * 好友昵称
     */
    private String username;
    /**
     * 好友头像
     */
    private String usericon;
    /**
     * 好友性别
     */
    private String usersex;
    /**
     * 好友出生年月日
     */
    private Date userbirthday;
    /**
     * 好友年龄
     */
    private Integer userage;
    /**
     * 好友地址
     */
    private String useraddr;
    /**
     * 好友座右铭
     */
    private String usermotto;
    /**
     * 好友身份角色
     */
    private String userrole;
}
