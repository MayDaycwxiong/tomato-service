package com.tomato.friends.netty.nettymain.MySqlUtil;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

/**
* @Description:    获取MySql连接
* @Author:         cuiwx
* @CreateDate:     2019/5/15 0:07
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/15 0:07
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Slf4j
public class ConnectionUtil {
    private static Connection con=null;
    /**
     * 用户名
     */
    private static final String USER=Properties.mysql_username;
    /**
     * 密码
     */
    private static final String PASSWORD=Properties.mysql_password;
    /**
     * url
     */
    private static final String URL=Properties.mysql_url;
    /**
     * 驱动名称
     */
    private static final String DRIVERNAME=Properties.mysql_drivername;
    /**
    * 方法实现说明    获取连接
    * @author      cuiwx
    * @date        2019/5/15 0:29
    */
    public static Connection getMySqlCon(){
        if(con==null){
            synchronized (ConnectionUtil.class){
                if(con==null){
                    try {
                        Class.forName(DRIVERNAME);
                        con= DriverManager.getConnection(URL,USER,PASSWORD);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                        log.info("MySql驱动异常");
                    } catch (SQLException e) {
                        e.printStackTrace();
                        log.info("获取MySql连接异常");
                    }
                }
            }
        }
        return con;
    }

    /**
    * 方法实现说明    关闭开启的连接
    * @author      cuiwx
    * @date        2019/5/15 0:28
    */
    public static void closeRecourse(Connection con, Statement st, PreparedStatement ps,ResultSet rs){
        try {
            if(con!=null){
                con.close();
            }
            if(st!=null){
                st.close();
            }
            if(ps!=null){
                ps.close();
            }
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.info("关闭连接资源异常");
        }
    }
}
