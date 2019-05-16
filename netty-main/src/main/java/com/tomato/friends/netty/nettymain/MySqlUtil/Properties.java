package com.tomato.friends.netty.nettymain.MySqlUtil;

import java.util.ResourceBundle;

/**
* @Description:    获取属性文件信息
* @Author:         cuiwx
* @CreateDate:     2019/5/15 0:12
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/15 0:12
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class Properties {
    private static ResourceBundle bundle=ResourceBundle.getBundle("mysql");

    public static String mysql_url;
    public static String mysql_username;
    public static String mysql_password;
    public static String mysql_drivername;

    static {
        if(!"".equals(bundle.getString("mysql_url"))){
            mysql_url=bundle.getString("mysql_url");
        }
        if(!"".equals(bundle.getString("mysql_username"))){
            mysql_username=bundle.getString("mysql_username");
        }
        if(!"".equals(bundle.getString("mysql_password"))){
            mysql_password=bundle.getString("mysql_password");
        }
        if(!"".equals(bundle.getString("mysql_drivername"))){
            mysql_drivername=bundle.getString("mysql_drivername");
        }
    }
}
