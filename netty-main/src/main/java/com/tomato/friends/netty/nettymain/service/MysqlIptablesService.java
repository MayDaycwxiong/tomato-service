package com.tomato.friends.netty.nettymain.service;

import com.tomato.friends.netty.nettymain.dto.IptablesPO;

/**
 * @Description: 统一定义iptables表操作
 * @Author: cuiwx
 * @CreateDate: 2019/5/15 0:34
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/15 0:34
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface MysqlIptablesService {
    /**
     * 方法实现说明    插入
     *
     * @author cuiwx
     * @date 2019/5/15 0:35
     */
    boolean insert(IptablesPO iptablesPO);

    /**
     * 方法实现说明    删除
     *
     * @author cuiwx
     * @date 2019/5/15 0:36
     */
    boolean delete(String serverIp, String channelId);
}
