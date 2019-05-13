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
}