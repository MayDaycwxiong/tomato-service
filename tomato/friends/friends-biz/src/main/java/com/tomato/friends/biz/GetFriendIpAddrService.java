package com.tomato.friends.biz;

import com.tomato.friends.dto.IptablesDTO;
import com.tomato.friends.dto.IptablesPO;

/**
 * @Description: 获取好友ip地址Service接口
 * @Author: cuiwx
 * @CreateDate: 2019/5/16 18:40
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/16 18:40
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface GetFriendIpAddrService {
    /**
     * 方法实现说明    获取好友ip地址
     *
     * @author cuiwx
     * @date 2019/5/16 18:41
     */
    IptablesDTO getFriendIpAddr(IptablesPO iptablesPO);

    /**
     * 方法实现说明    获取请求客户端所在网关
     *
     * @author cuiwx
     * @date 2019/5/16 19:57
     */
    IptablesPO getSelfClientIp(IptablesPO iptablesPO);

    /**
     * 方法实现说明    直接获得用户的IP
     *
     * @author cuiwx
     * @date 2019/5/23 16:17
     */
    IptablesDTO getFriendIpSimple(IptablesPO iptablesPO);
}
