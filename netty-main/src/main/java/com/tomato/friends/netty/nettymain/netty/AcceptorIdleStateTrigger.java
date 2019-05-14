package com.tomato.friends.netty.nettymain.netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;

/**
* @Description:    接收状态触发器
* @Author:         cuiwx
* @CreateDate:     2019/5/13 11:42
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/13 11:42
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Slf4j
@ChannelHandler.Sharable
public class AcceptorIdleStateTrigger extends SimpleChannelInboundHandler<String> {
    /**
    * 方法实现说明    响应客户端写事件，服务器端读
    * @author      cuiwx
    * @date        2019/5/13 11:43
    */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent){
            IdleState state=((IdleStateEvent) evt).state();
            if(state==IdleState.READER_IDLE){
                throw new Exception("idle exception");
            }
        }else {
            super.userEventTriggered(ctx, evt);
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        log.info("AcceptorIdleStateTrigger服务器{}",s);
    }
}
