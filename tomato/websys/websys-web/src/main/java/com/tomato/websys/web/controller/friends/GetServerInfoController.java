package com.tomato.websys.web.controller.friends;

import com.tomato.friends.api.GetServerInfoApi;
import com.tomato.friends.dto.ServerAddDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @Description:    获取服务器IP端口信息Controller
* @Author:         cuiwx
* @CreateDate:     2019/5/13 10:07
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/13 10:07
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Slf4j
@Api(tags = "获取服务器信息Restful接口")
@RestController
@RequestMapping("/friends")
public class GetServerInfoController {
    @Autowired
    private GetServerInfoApi getServerInfoApi;

    @ApiOperation(value = "得到服务器信息")
    @PostMapping("/getServerInfo.pub")
    public ServerAddDTO getServerInfo(){
        return getServerInfoApi.getServerInfo();
    }

}
