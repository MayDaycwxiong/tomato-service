package com.tomato.friends.netty.nettymain;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
* @Description:    去除SpringBoot自带的tomcate容器所需添加的代码
* @Author:         cuiwx
* @CreateDate:     2019/5/13 18:48
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/13 18:48
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class SpringBootStartApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(NettyMainApplication.class);
    }
}
