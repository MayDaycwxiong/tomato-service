package com.tomato.friends.netty.nettymain.netty;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

/**
* @Description:    netty服务器启动类
* @Author:         cuiwx
* @CreateDate:     2019/5/13 10:47
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/13 10:47
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Slf4j
public class Server {

    private static Server server=null;
    private int port=Properties.nettyPort;
    private AcceptorIdleStateTrigger idleStateTrigger=new AcceptorIdleStateTrigger();

    private Server(){
        log.info("Netty服务器port为:{}，开始启动服务器",port);
        startServer();
    }
     /**
     * 方法实现说明   server实例是否已经初始化
     * @author      cuiwx
     * @date        2019/5/13 11:15
     */
    public static boolean initServerInstance(){
        if(server==null){
            synchronized (Server.class){
                if(server==null){
                    log.info("第一次初始化Server实例");
                    server=new Server();
                }
            }
        }
        return true;
    }
    /**
    * 方法实现说明    启动netty服务器
    * @author      cuiwx
    * @date        2019/5/13 11:15
    */
    private void startServer() {
        EventLoopGroup bossGroup=new NioEventLoopGroup();
        EventLoopGroup wokerGroup=new NioEventLoopGroup();

        ServerBootstrap serverBootstrap=new ServerBootstrap()
                .group(bossGroup,wokerGroup)
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.INFO))
                .localAddress(new InetSocketAddress(port))
                .childHandler(new ServerInitializer())
                .option(ChannelOption.SO_BACKLOG,128)
                .childOption(ChannelOption.SO_KEEPALIVE,true);
        try {
            ChannelFuture channelFuture=serverBootstrap.bind(port).sync();
            log.info("Netty服务器启动了，监听端口为:{}",port);
            channelFuture.channel().closeFuture().sync();
            log.info("Netty服务器关闭了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            wokerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
    public static void main(String[] args){
        Server.initServerInstance();
    }
}
