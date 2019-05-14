package com.tomato.friends.netty.nettymain.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

/**
* @Description:    Netty服务器初始化类，绑定管道
* @Author:         cuiwx
* @CreateDate:     2019/5/13 11:00
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/13 11:00
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Slf4j
public class ServerInitializer extends ChannelInitializer<SocketChannel> {
    private AcceptorIdleStateTrigger idleStateTrigger=new AcceptorIdleStateTrigger();

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline=socketChannel.pipeline();

        pipeline.addLast(new IdleStateHandler(Properties.readerIdleTime,Properties.writerIdleTime,Properties.allIdleTime, TimeUnit.SECONDS));
        pipeline.addLast(idleStateTrigger);

//        pipeline.addLast("framer",new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));

        pipeline.addLast("decoder",new StringDecoder(Charset.forName("UTF-8")));
        pipeline.addLast("encoder",new StringEncoder(Charset.forName("UTF-8")));
        pipeline.addLast("handler",new ServerHandler());
        InetSocketAddress inetSocketAddress=socketChannel.remoteAddress();
        String clientIP=inetSocketAddress.getAddress().getHostAddress();
        log.info("client:{}连接上服务器",clientIP);
    }
}
