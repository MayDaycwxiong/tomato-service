package com.tomato.friends.netty.nettymain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tomato.friends.netty.nettymain.dao")
public class NettyMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(NettyMainApplication.class, args);
    }

}
