package com.tomato.friends.provider;

import com.tomato.friends.api.GetServerInfoApi;
import com.tomato.friends.biz.GetServerInfoService;
import com.tomato.friends.dto.ServerAddDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetServerInfoProvider implements GetServerInfoApi {

    @Autowired
    private GetServerInfoService getServerInfoService;

    @Override
    public ServerAddDTO getServerInfo() {
        return getServerInfoService.getServerInfo();
    }
}
