package com.tomato.friends.biz.impl;

import com.tomato.common.ObjectUtil;
import com.tomato.friends.biz.GetFriendIpAddrService;
import com.tomato.friends.dto.IptablesDTO;
import com.tomato.friends.dto.IptablesPO;
import com.tomato.friends.manager.GetFriendIpAddrManager;
import javafx.beans.binding.ObjectExpression;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @Description:    获取好友ip地址Service
* @Author:         cuiwx
* @CreateDate:     2019/5/16 18:42
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/16 18:42
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Slf4j
@Service
public class GetFriendIpAddrServiceImpl implements GetFriendIpAddrService {
    @Autowired
    private GetFriendIpAddrManager getFriendIpAddrManager;

    @Override
    public IptablesDTO getFriendIpAddr(IptablesPO iptablesPO) {
        IptablesDTO iptablesDTO=new IptablesDTO();
        IptablesPO returnIptablesPO=getSelfClientIp(iptablesPO);
        if(ObjectUtil.isNotNull(returnIptablesPO)){
            log.info("根据ServerIP和ClientSelfIP查询到的对象为{}",returnIptablesPO.toString());
            beforeSelect(returnIptablesPO,iptablesPO);
            returnIptablesPO=getFriendIpAddrManager.getFriendIpAddr(returnIptablesPO);
            if(ObjectUtil.isNotNull(returnIptablesPO)){
                log.info("最终返回的对象为{}",returnIptablesPO.toString());
            }else{
                log.info("该网关下没有好友对应的信息");
            }
        }
        detailData(returnIptablesPO,iptablesDTO,iptablesPO);
        return iptablesDTO;
    }
    /**
    * 方法实现说明    处理返回的结果
    * @author      cuiwx
    * @date        2019/5/16 20:15
    */
    private void detailData(IptablesPO returnIptablesPO, IptablesDTO iptablesDTO, IptablesPO iptablesPO) {
        if(ObjectUtil.isNull(returnIptablesPO)){
            iptablesDTO.setIptablesPO(iptablesPO);
            iptablesDTO.setFlag("1");
            log.info("查询对象不存在，返回查询失败");
        }else{
            iptablesDTO.setIptablesPO(returnIptablesPO);
            iptablesDTO.setFlag("0");
            log.info("最终返回的查询结果为{}",iptablesDTO.toString());
        }
    }

    /**
    * 方法实现说明    根据网关信息初始化查询对象
    * @author      cuiwx
    * @date        2019/5/16 20:05
    */
    private void beforeSelect(IptablesPO returnIptablesPO, IptablesPO iptablesPO) {
        returnIptablesPO.setUserid(iptablesPO.getUserid());
    }

    @Override
    public IptablesPO getSelfClientIp(IptablesPO iptablesPO) {
        IptablesPO returnIptablesPO=getFriendIpAddrManager.getSelfClientIp(iptablesPO);
        if(ObjectUtil.isNotNull(returnIptablesPO)) {
            log.info("返回的对象为{}", returnIptablesPO.toString());
        }else{
            log.info("请求用户自己没在线");
        }
        return returnIptablesPO;
    }

    /**
    * 方法实现说明    这里在部署好的环境下测试发现，不在同一个网关下，在同一个校园网里，如一个20153818，一个20153822账号可以点对点连接通讯
    * @author      cuiwx
    * @date        2019/5/23 16:17
    */
    @Override
    public IptablesDTO getFriendIpSimple(IptablesPO iptablesPO) {
        IptablesDTO iptablesDTO=new IptablesDTO();
        IptablesPO returnIptablesPO=getFriendIpAddrManager.getFriendIpSimple(iptablesPO);
        detailData(returnIptablesPO,iptablesDTO,iptablesPO);
        return iptablesDTO;
    }
}
