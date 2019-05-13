package com.tomato.friends.dao;

import com.tomato.friends.dto.UserGroupPO;

public interface UserGroupPOMapper {
    int deleteByPrimaryKey(Integer usergroupid);

    int insert(UserGroupPO record);

    int insertSelective(UserGroupPO record);

    UserGroupPO selectByPrimaryKey(Integer usergroupid);

    int updateByPrimaryKeySelective(UserGroupPO record);

    int updateByPrimaryKey(UserGroupPO record);
}