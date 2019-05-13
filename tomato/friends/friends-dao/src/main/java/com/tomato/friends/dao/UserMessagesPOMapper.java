package com.tomato.friends.dao;

import com.tomato.friends.dto.UserMessagesPO;

public interface UserMessagesPOMapper {
    int deleteByPrimaryKey(Integer messageid);

    int insert(UserMessagesPO record);

    int insertSelective(UserMessagesPO record);

    UserMessagesPO selectByPrimaryKey(Integer messageid);

    int updateByPrimaryKeySelective(UserMessagesPO record);

    int updateByPrimaryKey(UserMessagesPO record);
}