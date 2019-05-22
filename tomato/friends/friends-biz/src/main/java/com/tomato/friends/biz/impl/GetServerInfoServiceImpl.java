package com.tomato.friends.biz.impl;

import com.tomato.common.CollectionUtil;
import com.tomato.friends.biz.GetServerInfoService;
import com.tomato.friends.dto.ServerAddDTO;
import com.tomato.friends.dto.ServerAddPO;
import com.tomato.friends.manager.GetServerInfoManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
* @Description:    获取服务器Service
* @Author:         cuiwx
* @CreateDate:     2019/5/13 14:53
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/13 14:53
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Slf4j
@Service
public class GetServerInfoServiceImpl implements GetServerInfoService {

    @Autowired
    private GetServerInfoManager getServerInfoManager;

    @Override
    public ServerAddDTO getServerInfo() {
        List<ServerAddPO> serverInfoPOList=getServerInfoManager.getServerInfo();
        ServerAddDTO serverAddDTO=new ServerAddDTO();
        dealData(serverAddDTO,serverInfoPOList);
        return serverAddDTO;
    }
    /**
    * 方法实现说明    随机返回一台服务器的ip和端口
    * @author      cuiwx
    * @date        2019/5/13 14:53
    */
    private void dealData(ServerAddDTO serverAddDTO, List<ServerAddPO> serverInfoPOList) {
        if(CollectionUtil.isEmpty(serverInfoPOList)){
            serverAddDTO.setFlage("1");
            log.info("获取失败，当前没有可用服务器");
            return;
        }
        if(serverInfoPOList.size()==1){
            serverAddDTO.setServerAddPO(serverInfoPOList.get(0));
            serverAddDTO.setFlage("0");
            log.info("当前只有一台服务器，获取成功");
            return;
        }
        random(serverAddDTO,serverInfoPOList);
    }
    /**
    * 方法实现说明    随机返回
    * @author      cuiwx
    * @date        2019/5/13 15:06
    */
    private void random(ServerAddDTO serverAddDTO,List<ServerAddPO> serverInfoPOList) {
//        StringBuffer numberChar=new StringBuffer();
//        for(int i=0;i<serverInfoPOList.size();i++){
//            numberChar.append(i+"");
//        }
//        log.info("用于随机的原始数字:{}",numberChar.toString());
//        Long seed=System.currentTimeMillis();
//        Random random=new Random(seed);
//        int index=Integer.parseInt(numberChar.toString().charAt(random.nextInt(numberChar.length()))+"");
        Long seed=System.currentTimeMillis();
        Random random=new Random(seed);
        int index=random.nextInt(serverInfoPOList.size());
        serverAddDTO.setServerAddPO(serverInfoPOList.get(index));
        serverAddDTO.setFlage("0");
        log.info("获取成功，随机返回的服务器为:{}",serverAddDTO.getServerAddPO().toString());
    }
}
