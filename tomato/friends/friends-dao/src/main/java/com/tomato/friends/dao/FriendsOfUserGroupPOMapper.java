package com.tomato.friends.dao;

import com.tomato.friends.dto.FriendsOfUserGroupPO;
import org.apache.ibatis.annotations.Param;

public interface FriendsOfUserGroupPOMapper {
    int deleteByPrimaryKey(@Param("userid") String userid, @Param("friend") String friend);

    int insert(FriendsOfUserGroupPO record);

    int insertSelective(FriendsOfUserGroupPO record);

    FriendsOfUserGroupPO selectByPrimaryKey(@Param("userid") String userid, @Param("friend") String friend);

    int updateByPrimaryKeySelective(FriendsOfUserGroupPO record);

    int updateByPrimaryKey(FriendsOfUserGroupPO record);

    /**
     * 方法实现说明    查询好友是否存在
     *
     * @author cuiwx
     * @date 2019/5/20 13:43
     */
    int existsFriends(@Param("userid") String userid);
}