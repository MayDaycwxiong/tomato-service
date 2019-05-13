package com.tomato.friends.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

import java.io.Serializable;

/**
 * tb_usergroup
 */
@ToString
public class UserGroupPO implements Serializable {
    /**
     * 用户组Id
     * userGroupId
     */
    @ApiModelProperty(value = "用户组Id", required = true)
    private Integer usergroupid;

    /**
     * 用户id，即用户账号，对应user表中的userId
     * userId
     */
    @ApiModelProperty(value = "用户id，即用户账号，对应user表中的userId", required = true)
    private String userid;

    /**
     * 分组名，有默认分组
     * userGroupName
     */
    @ApiModelProperty(value = "分组名，有默认分组", required = true)
    private String usergroupname;

    /**
     * 用户组标识，0表示没删除，1标识删除
     * userGroupFlag
     */
    @ApiModelProperty(value = "用户组标识，0表示没删除，1标识删除", required = false)
    private String usergroupflag;

    /**
     * @return the value of tb_usergroup.userGroupId
     */
    public Integer getUsergroupid() {
        return usergroupid;
    }

    /**
     * @param usergroupid the value for tb_usergroup.userGroupId
     */
    public void setUsergroupid(Integer usergroupid) {
        this.usergroupid = usergroupid;
    }

    /**
     * @return the value of tb_usergroup.userId
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid the value for tb_usergroup.userId
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * @return the value of tb_usergroup.userGroupName
     */
    public String getUsergroupname() {
        return usergroupname;
    }

    /**
     * @param usergroupname the value for tb_usergroup.userGroupName
     */
    public void setUsergroupname(String usergroupname) {
        this.usergroupname = usergroupname;
    }

    /**
     * @return the value of tb_usergroup.userGroupFlag
     */
    public String getUsergroupflag() {
        return usergroupflag;
    }

    /**
     * @param usergroupflag the value for tb_usergroup.userGroupFlag
     */
    public void setUsergroupflag(String usergroupflag) {
        this.usergroupflag = usergroupflag;
    }
}