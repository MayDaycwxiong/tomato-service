package com.tomato.friends.provider;

import com.tomato.friends.api.GetServerInfoApi;
import com.tomato.friends.biz.GetServerInfoService;
import com.tomato.friends.dto.ServerAddDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
* @Description:    获取服务器ip以及端口接口提供者
* @Author:         cuiwx
* @CreateDate:     2019/5/16 18:28
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/16 18:28
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Service
public class GetServerInfoProvider implements GetServerInfoApi {

    @Autowired
    private GetServerInfoService getServerInfoService;

    @Override
    public ServerAddDTO getServerInfo() {
        return getServerInfoService.getServerInfo();
    }
}
