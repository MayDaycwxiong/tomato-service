package com.tomato.friends.api;

import com.tomato.friends.dto.IptablesDTO;
import com.tomato.friends.dto.IptablesPO;

/**
 * @Description: 获取同一个网关下的好友ip地址
 * @Author: cuiwx
 * @CreateDate: 2019/5/16 18:19
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/16 18:19
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface GetFriendIpAddrApi {
    /**
     * 方法实现说明    获取同一网关下好友ip地址
     *
     * @author cuiwx
     * @date 2019/5/16 18:26
     */
    IptablesDTO getFriendIpAddr(IptablesPO iptablesPO);
}
