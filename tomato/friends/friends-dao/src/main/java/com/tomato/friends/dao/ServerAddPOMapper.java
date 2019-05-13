package com.tomato.friends.dao;

import com.tomato.friends.dto.ServerAddPO;

import java.util.List;

public interface ServerAddPOMapper {
    int deleteByPrimaryKey(String serverip);

    int insert(ServerAddPO record);

    int insertSelective(ServerAddPO record);

    ServerAddPO selectByPrimaryKey(String serverip);

    int updateByPrimaryKeySelective(ServerAddPO record);

    int updateByPrimaryKey(ServerAddPO record);

    /**
     * 方法实现说明 获取服务器列表
     *
     * @author cuiwx
     * @date 2019/5/13 14:43
     */
    List<ServerAddPO> listOfServers();
}