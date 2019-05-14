package com.tomato.friends.netty.nettymain;

import com.tomato.friends.netty.nettymain.netty.Server;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
* @Description:    netty启动类
* @Author:         cuiwx
* @CreateDate:     2019/5/13 18:51
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/13 18:51
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Service
public class MainController {

    @PostConstruct
    public void start(){
        Server.initServerInstance();
    }
}
