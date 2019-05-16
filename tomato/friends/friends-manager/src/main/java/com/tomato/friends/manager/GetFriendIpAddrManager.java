package com.tomato.friends.manager;

import com.tomato.friends.dao.IptablesPOMapper;
import com.tomato.friends.dto.IptablesPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: 获取好友ip地址Manager
 * @Author: cuiwx
 * @CreateDate: 2019/5/16 18:44
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/16 18:44
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Slf4j
@Component
public class GetFriendIpAddrManager {
    @Autowired
    private IptablesPOMapper iptablesPOMapper;

    public IptablesPO getFriendIpAddr(IptablesPO iptablesPO) {
        log.info("查询对象为{}",iptablesPO.toString());
        String clientIp=iptablesPO.getClientip();
        String serverIp=iptablesPO.getServerip();
        String friendId=iptablesPO.getUserid();
        log.info("clientIp={},serverIp={},friendId={}",clientIp,serverIp,friendId);
        return iptablesPOMapper.selectFinalObject(clientIp,serverIp,friendId);
    }

    public IptablesPO getSelfClientIp(IptablesPO iptablesPO) {
        log.info("查询对象为{}",iptablesPO.toString());
        String serverIp=iptablesPO.getServerip();
        String clientSelfIp=iptablesPO.getClientselfip();
        log.info("查询的ServerIP={},clientSelfIp={}",serverIp,clientSelfIp);
        return iptablesPOMapper.selectObject(serverIp,clientSelfIp);
    }
}
