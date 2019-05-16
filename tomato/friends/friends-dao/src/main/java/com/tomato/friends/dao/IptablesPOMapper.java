package com.tomato.friends.dao;

import com.tomato.friends.dto.IptablesDTO;
import com.tomato.friends.dto.IptablesPO;
import org.apache.ibatis.annotations.Param;

public interface IptablesPOMapper {
    int deleteByPrimaryKey(@Param("channelid") String channelid, @Param("serverip") String serverip);

    int insert(IptablesPO record);

    int insertSelective(IptablesPO record);

    IptablesPO selectByPrimaryKey(@Param("channelid") String channelid, @Param("serverip") String serverip);

    int updateByPrimaryKeySelective(IptablesPO record);

    int updateByPrimaryKey(IptablesPO record);

    /**
     * 方法实现说明    根据请求客户端连接的服务器IP和客户端自己的IP地址查找客户端所在的局域网网关
     *
     * @author cuiwx
     * @date 2019/5/16 18:52
     */
    IptablesPO selectObject(@Param("serverip") String serverip, @Param("clientselfip") String clientselfip);

    /**
     * 方法实现说明    根据局域网网关和请求客户端连接的服务器IP查找好友对应的ip,此处为同一网关下的ip
     *
     * @author cuiwx
     * @date 2019/5/16 19:50
     */
    IptablesPO selectFinalObject(@Param("clientip") String clientIp, @Param("serverip") String serverIp, @Param("friendid") String friendId);
}