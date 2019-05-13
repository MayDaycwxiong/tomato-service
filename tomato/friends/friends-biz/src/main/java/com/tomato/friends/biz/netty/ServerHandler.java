package com.tomato.friends.biz.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServerHandler extends SimpleChannelInboundHandler<String> {
    public static ChannelGroup channels=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    public static Channel incoming=null;

    /**
    * 方法实现说明    建立连接的时候触发
    * @author      cuiwx
    * @date        2019/5/13 12:26
    */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel incoming=ctx.channel();
        log.info("Client:{}在线",incoming.remoteAddress());
    }
    /**
    * 方法实现说明    服务器读取客户端写入信息时触发
    * @author      cuiwx
    * @date        2019/5/13 12:27
    */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        incoming=channelHandlerContext.channel();
        if(s.equals("HEARTBATE")){
            log.info("client:{}-->Server:{}",incoming.remoteAddress(),s);
        }else{
            for(Channel channel:channels){
                if(channel!=incoming){
                    channel.writeAndFlush("");
                    log.info("发送连接的客户端IP");
                }
            }
        }
    }
    /**
    * 方法实现说明    服务器接收到新的客户端连接时触发
    * @author      cuiwx
    * @date        2019/5/13 12:43
    */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        channels.add(ctx.channel());
        for(Channel channel:channels){

        }
    }
    /**
    * 方法实现说明    出现IO错误或处理器抛出异常时触发
    * @author      cuiwx
    * @date        2019/5/13 12:46
    */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("client:{}出现异常:{}",ctx.channel().remoteAddress(),cause.getMessage());
        cause.printStackTrace();
        ctx.close();
        log.info("关闭client:{}连接通道",ctx.channel().remoteAddress());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("client:{}掉线",ctx.channel().remoteAddress());
    }
}
