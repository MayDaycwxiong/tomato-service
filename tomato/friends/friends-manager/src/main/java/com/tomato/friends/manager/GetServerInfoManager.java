package com.tomato.friends.manager;

import com.tomato.friends.dao.ServerAddPOMapper;
import com.tomato.friends.dto.ServerAddPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description: 获取服务器信息Manager
 * @Author: cuiwx
 * @CreateDate: 2019/5/13 14:17
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/13 14:17
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Slf4j
@Component
public class GetServerInfoManager {

    @Autowired
    private ServerAddPOMapper serverAddPOMapper;

    public List<ServerAddPO> getServerInfo() {
        List<ServerAddPO> list = serverAddPOMapper.listOfServers();
        log.info("服务器个数为:{}", list.size());
        return list;
    }
}
