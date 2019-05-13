package com.tomato.friends.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

import java.io.Serializable;

/**
 * tb_serveradd
 */
@ToString
public class ServerAddPO implements Serializable {
    /**
     * 服务器ip
     * serverIp
     */
    @ApiModelProperty(value = "服务器ip", required = true)
    private String serverip;

    /**
     * 服务器端口
     * serverPort
     */
    @ApiModelProperty(value = "服务器端口", required = true)
    private Integer serverport;

    /**
     * @return the value of tb_serveradd.serverIp
     */
    public String getServerip() {
        return serverip;
    }

    /**
     * @param serverip the value for tb_serveradd.serverIp
     */
    public void setServerip(String serverip) {
        this.serverip = serverip;
    }

    /**
     * @return the value of tb_serveradd.serverPort
     */
    public Integer getServerport() {
        return serverport;
    }

    /**
     * @param serverport the value for tb_serveradd.serverPort
     */
    public void setServerport(Integer serverport) {
        this.serverport = serverport;
    }
}