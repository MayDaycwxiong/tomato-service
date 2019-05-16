package com.tomato.friends.netty.nettymain.manager;

import com.tomato.friends.netty.nettymain.MySqlUtil.ConnectionUtil;
import com.tomato.friends.netty.nettymain.dto.IptablesPO;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
* @Description:    iptables具体实现类
* @Author:         cuiwx
* @CreateDate:     2019/5/15 0:37
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/15 0:37
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Slf4j
public class MysqlIptablesManager {

    private Connection con= ConnectionUtil.getMySqlCon();
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    private String insertSql="insert into tb_iptables(clientIp,userid,serverIp,clientSelfIp,channelId) values(?,?,?,?,?)";
    private String deleteSql="delete from tb_iptables where serverIp=(?) and channelId=(?)";
    private String selectSql="select count(*) from tb_iptables where serverIp=(?) and channelId=(?)";

    public boolean insert(IptablesPO iptablesPO){
        boolean b=false;
        if(select(iptablesPO.getServerip(),iptablesPO.getChannelid())){
            log.info("待插入数据已存在");
            return true;
        }
        try {
            ps=con.prepareStatement(insertSql);
            ps.setObject(1,iptablesPO.getClientip());
            ps.setObject(2,iptablesPO.getUserid());
            ps.setObject(3,iptablesPO.getServerip());
            ps.setObject(4,iptablesPO.getClientselfip());
            ps.setObject(5,iptablesPO.getChannelid());
            ps.execute();
            b=true;
        } catch (SQLException e) {
            e.printStackTrace();
            log.info("插入过程出现异常{}",e.getMessage());
        }finally {
            ConnectionUtil.closeRecourse(null,null,ps,null);
        }
        return b;
    }

    public boolean delete(String serverIp, String channelId){
        boolean b=false;
        if(!select(serverIp,channelId)){
            log.info("待删除的信息不存在");
            return true;
        }
        try{
            ps=con.prepareStatement(deleteSql);
            ps.setObject(1,serverIp);
            ps.setObject(2,channelId);
            ps.execute();
            b=true;
        } catch (SQLException e) {
            e.printStackTrace();
            log.info("删除过程出现异常{}",e.getMessage());
        }finally {
            ConnectionUtil.closeRecourse(null,null,ps,null);
        }
        return b;
    }

    public boolean select(String serverIp,String channelId){
        boolean b=false;
        try {
            ps=con.prepareStatement(selectSql);
            ps.setObject(1,serverIp);
            ps.setObject(2,channelId);
            rs=ps.executeQuery();
            if(rs.next()&&rs.getInt(1)>0){
                log.info("查询信息存在");
                b=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionUtil.closeRecourse(null,null,ps,rs);
        }
        return b;
    }
}
