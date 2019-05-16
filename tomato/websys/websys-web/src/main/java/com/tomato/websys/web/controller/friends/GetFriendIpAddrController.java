package com.tomato.websys.web.controller.friends;

import com.tomato.common.ObjectUtil;
import com.tomato.friends.api.GetFriendIpAddrApi;
import com.tomato.friends.dto.IptablesDTO;
import com.tomato.friends.dto.IptablesPO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @Description:    获取同一网关下好友ip地址Controller
* @Author:         cuiwx
* @CreateDate:     2019/5/16 18:31
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/16 18:31
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Slf4j
@Api(tags = "获取好友ip地址Restful接口")
@RestController
@RequestMapping("/friends")
public class GetFriendIpAddrController {
    @Autowired
    private GetFriendIpAddrApi getFriendIpAddrApi;

    @ApiOperation(value = "获取好友ip地址")
    @PostMapping("/getFriendIpAddr.pub")
    public IptablesDTO getFriendIpAddr(IptablesPO iptablesPO){
        if(ObjectUtil.isNull(iptablesPO)){
            log.info("Object is null");
        }else{
            log.info("请求参数{}",iptablesPO.toString());
        }
        return getFriendIpAddrApi.getFriendIpAddr(iptablesPO);
    }


}
