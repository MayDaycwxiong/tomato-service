package com.tomato.friends.dao;

import com.tomato.friends.dto.UserGroupPO;
import com.tomato.friends.extbean.friendsList.ResultListSql;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserGroupPOMapper {
    int deleteByPrimaryKey(Integer usergroupid);

    int insert(UserGroupPO record);

    int insertSelective(UserGroupPO record);

    UserGroupPO selectByPrimaryKey(Integer usergroupid);

    int updateByPrimaryKeySelective(UserGroupPO record);

    int updateByPrimaryKey(UserGroupPO record);

    /**
     * 方法实现说明    初始化好友分组接口
     *
     * @author cuiwx
     * @date 2019/5/17 10:51
     */
    int initFriendGroupInfo(List<UserGroupPO> list);

    /**
     * 方法实现说明    获取好友分组下的好友(所有分组下的所有好友)
     *
     * @author cuiwx
     * @date 2019/5/17 16:43
     */
    List<ResultListSql> userFriendsList(@Param("userid") String userid);
}