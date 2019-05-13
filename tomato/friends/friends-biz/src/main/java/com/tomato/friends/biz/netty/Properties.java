package com.tomato.friends.biz.netty;

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
        if(!"".equals("netty_port")){
            nettyPort=Integer.parseInt(bundle.getString("netty_port"));
        }
        if(!"".equals("readerIdleTime")){
            readerIdleTime=Integer.parseInt(bundle.getString("readerIdleTime"));
        }
        if(!"".equals("writerIdleTime")){
            writerIdleTime=Integer.parseInt(bundle.getString("writerIdleTime"));
        }
        if(!"".equals("allIdleTime")){
            allIdleTime=Integer.parseInt(bundle.getString("allIdleTime"));
        }
    }
}
