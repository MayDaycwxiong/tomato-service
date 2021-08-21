package com.tomato.friends.netty.nettymain.netty;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tomato.friends.netty.nettymain.dto.IptablesDTO;
import com.tomato.friends.netty.nettymain.dto.IptablesPO;
import com.tomato.friends.netty.nettymain.service.MysqlIptablesService;
import com.tomato.friends.netty.nettymain.service.impl.MysqlIptablesServiceImpl;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ServerHandler extends SimpleChannelInboundHandler<String> {

    //    public static ChannelGroup channels=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    public static ExecutorService myThreadPool = Executors.newCachedThreadPool();
    public MysqlIptablesService mysqlIptablesService = new MysqlIptablesServiceImpl();

    /**
     * 方法实现说明    服务器接收到新的客户端连接时触发
     *
     * @author cuiwx
     * @date 2019/5/13 12:43
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
//        String channelId=ctx.channel().id().asLongText();
//        String handlerObject=ctx.handler().toString();
//        log.info("handlerAdded==>channelId={},handlerObject={}",channelId,handlerObject);
    }

    /**
     * 方法实现说明    建立连接的时候触发
     *
     * @author cuiwx
     * @date 2019/5/13 12:26
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        String channelId=ctx.channel().id().asLongText();
//        String handlerObject=ctx.handler().toString();
//        log.info("channelActive==>channelId={},handlerObject={}",channelId,handlerObject);
    }

    /**
     * 方法实现说明    服务器读取客户端写入信息时触发
     *
     * @author cuiwx
     * @date 2019/5/13 12:27
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        // 接收到的数据
        IptablesDTO iptablesDTO = JSON.parseObject(s, IptablesDTO.class);
        log.info("接收到的json数据为{}", iptablesDTO.toString());
        // 获取客户端ip
        Channel incoming = channelHandlerContext.channel();
        InetSocketAddress inetSocketAddress= (InetSocketAddress) incoming.remoteAddress();
        String clientIp=inetSocketAddress.getAddress().getHostAddress();
        // 得到绑定通道的唯一标识
        String channelId=channelHandlerContext.channel().id().asLongText();
        String handlerObject=channelHandlerContext.toString();
        // 获取服务器自身ip
        InetSocketAddress self= (InetSocketAddress) channelHandlerContext.channel().localAddress();
        String selfIp=self.getAddress().getHostAddress();
        log.info("channelRead0==>selfIP={},clientIP={},channelId={},handlerObject={}",selfIp,clientIp,channelId,handlerObject);
        if (iptablesDTO.getHeartBate().equals("HEARTBATE")) {
            log.info("client:{}发送 HEARTBATE -->Server:{}", clientIp, s);
        }
        myThreadPool.execute(() -> {
            if (iptablesDTO.getFirst().equals("0")) {
                IptablesPO iptablesPO = iptablesDTO.getIptablesPO();
                iptablesPO.setClientip(clientIp);
                iptablesPO.setServerip(selfIp);
                iptablesPO.setChannelid(channelId);
                mysqlIptablesService.insert(iptablesPO);
            } else if (iptablesDTO.getFirst().equals("1")) {
                log.info("已经登记过该Ip");
            }
        });
    }

    /**
     * 方法实现说明    出现IO错误或处理器抛出异常时触发
     *
     * @author cuiwx
     * @date 2019/5/13 12:46
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Channel incoming = ctx.channel();
        InetSocketAddress inetSocketAddress = (InetSocketAddress) incoming.remoteAddress();
        String clientIP = inetSocketAddress.getAddress().getHostAddress();
        cause.printStackTrace();
        log.info("exceptionCaught==>client{}出现异常",clientIP);
        ctx.close();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        // 客户端ip
        Channel incoming = ctx.channel();
        InetSocketAddress inetSocketAddress = (InetSocketAddress) incoming.remoteAddress();
        String clientIP = inetSocketAddress.getAddress().getHostAddress();
        // 服务器自身ip
        InetSocketAddress self= (InetSocketAddress) incoming.localAddress();
        String selfIp=self.getAddress().getHostAddress();
        // 分配的通道id
        String channelId=ctx.channel().id().asLongText();
        String handlerObject=ctx.toString();
        log.info("channelInactive==>client{}掉线，channelId={},handlerObject={}",clientIP,channelId,handlerObject);
        myThreadPool.execute(() -> mysqlIptablesService.delete(selfIp,channelId));
    }
}
