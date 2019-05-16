package com.tomato.friends.netty.nettymain.service.impl;

import com.tomato.friends.netty.nettymain.dto.IptablesPO;
import com.tomato.friends.netty.nettymain.manager.MysqlIptablesManager;
import com.tomato.friends.netty.nettymain.service.MysqlIptablesService;
/**
* @Description:    操作iptables表Service
* @Author:         cuiwx
* @CreateDate:     2019/5/15 0:36
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/15 0:36
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class MysqlIptablesServiceImpl implements MysqlIptablesService {
    private MysqlIptablesManager mysqlIptablesManager=new MysqlIptablesManager();

    @Override
    public boolean insert(IptablesPO iptablesPO) {
        return mysqlIptablesManager.insert(iptablesPO);
    }

    @Override
    public boolean delete(String serverIp, String channelId) {
        return mysqlIptablesManager.delete(serverIp,channelId);
    }
}
