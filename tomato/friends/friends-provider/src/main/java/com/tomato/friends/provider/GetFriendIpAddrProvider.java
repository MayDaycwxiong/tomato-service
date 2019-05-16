package com.tomato.friends.provider;

import com.tomato.friends.api.GetFriendIpAddrApi;
import com.tomato.friends.biz.GetFriendIpAddrService;
import com.tomato.friends.dto.IptablesDTO;
import com.tomato.friends.dto.IptablesPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @Description:    获取好友ip地址接口提供者
* @Author:         cuiwx
* @CreateDate:     2019/5/16 18:29
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/16 18:29
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Service
public class GetFriendIpAddrProvider implements GetFriendIpAddrApi {

    @Autowired
    private GetFriendIpAddrService getFriendIpAddrService;

    @Override
    public IptablesDTO getFriendIpAddr(IptablesPO iptablesPO) {
        return getFriendIpAddrService.getFriendIpAddr(iptablesPO);
    }
}
