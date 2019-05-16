package com.tomato.friends.netty.nettymain.netty;

import java.util.ResourceBundle;

/**
* @Description:    读取Netty服务器配置文件
* @Author:         cuiwx
* @CreateDate:     2019/5/13 11:48
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/13 11:48
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class Properties {

    public static ResourceBundle bundle=ResourceBundle.getBundle("netty");
    /**
     * Netty port
     */
    public static int nettyPort;
    public static int readerIdleTime;
    public static int writerIdleTime;
    public static int allIdleTime;
    static {
        if(!"".equals(bundle.getString("netty_port"))){
            nettyPort=Integer.parseInt(bundle.getString("netty_port"));
        }
        if(!"".equals(bundle.getString("readerIdleTime"))){
            readerIdleTime=Integer.parseInt(bundle.getString("readerIdleTime"));
        }
        if(!"".equals(bundle.getString("writerIdleTime"))){
            writerIdleTime=Integer.parseInt(bundle.getString("writerIdleTime"));
        }
        if(!"".equals(bundle.getString("allIdleTime"))){
            allIdleTime=Integer.parseInt(bundle.getString("allIdleTime"));
        }
    }
}
