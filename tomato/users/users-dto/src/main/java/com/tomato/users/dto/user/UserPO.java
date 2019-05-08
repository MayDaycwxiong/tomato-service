package com.tomato.users.dto.user;


import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * tb_user
 */
@ToString
public class UserPO implements Serializable {
    /**
     * 用户id，即用户帐号
     * userId
     */
    @ApiModelProperty(value = "用户id，即用户帐号", required = true)
    private String userid;

    /**
     * 用户昵称
     * userName
     */
    @ApiModelProperty(value = "用户昵称", required = true)
    private String username;

    /**
     * 用户密码
     * userPassword
     */
    @ApiModelProperty(value = "用户密码", required = true)
    private String userpassword;

    /**
     * 用户头像，图片服务器地址，有默认值
     * userIcon
     */
    @ApiModelProperty(value = "用户头像，图片服务器地址，有默认值", required = true)
    private String usericon;

    /**
     * 用户性别，0表示男，1表示女
     * userSex
     */
    @ApiModelProperty(value = "用户性别，0表示男，1表示女", required = true)
    private String usersex;

    /**
     * 用户出生年月日
     * userBirthday
     */
    @ApiModelProperty(value = "用户出生年月日", required = true)
    private Date userbirthday;

    /**
     * 用户年龄
     * userAge
     */
    @ApiModelProperty(value = "用户年龄", required = true)
    private Integer userage;

    /**
     * 用户地址
     * userAddr
     */
    @ApiModelProperty(value = "用户地址", required = false)
    private String useraddr;

    /**
     * 用户个性签名
     * userMotto
     */
    @ApiModelProperty(value = "用户个性签名", required = false)
    private String usermotto;

    /**
     * 用户角色，用户的职业
     * userRole
     */
    @ApiModelProperty(value = "用户角色，用户的职业", required = false)
    private String userrole;

    /**
     * @return the value of tb_user.userId
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid the value for tb_user.userId
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * @return the value of tb_user.userName
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the value for tb_user.userName
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the value of tb_user.userPassword
     */
    public String getUserpassword() {
        return userpassword;
    }

    /**
     * @param userpassword the value for tb_user.userPassword
     */
    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    /**
     * @return the value of tb_user.userIcon
     */
    public String getUsericon() {
        return usericon;
    }

    /**
     * @param usericon the value for tb_user.userIcon
     */
    public void setUsericon(String usericon) {
        this.usericon = usericon;
    }

    /**
     * @return the value of tb_user.userSex
     */
    public String getUsersex() {
        return usersex;
    }

    /**
     * @param usersex the value for tb_user.userSex
     */
    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    /**
     * @return the value of tb_user.userBirthday
     */
    public Date getUserbirthday() {
        return userbirthday;
    }

    /**
     * @param userbirthday the value for tb_user.userBirthday
     */
    public void setUserbirthday(Date userbirthday) {
        this.userbirthday = userbirthday;
    }

    /**
     * @return the value of tb_user.userAge
     */
    public Integer getUserage() {
        return userage;
    }

    /**
     * @param userage the value for tb_user.userAge
     */
    public void setUserage(Integer userage) {
        this.userage = userage;
    }

    /**
     * @return the value of tb_user.userAddr
     */
    public String getUseraddr() {
        return useraddr;
    }

    /**
     * @param useraddr the value for tb_user.userAddr
     */
    public void setUseraddr(String useraddr) {
        this.useraddr = useraddr;
    }

    /**
     * @return the value of tb_user.userMotto
     */
    public String getUsermotto() {
        return usermotto;
    }

    /**
     * @param usermotto the value for tb_user.userMotto
     */
    public void setUsermotto(String usermotto) {
        this.usermotto = usermotto;
    }

    /**
     * @return the value of tb_user.userRole
     */
    public String getUserrole() {
        return userrole;
    }

    /**
     * @param userrole the value for tb_user.userRole
     */
    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }
}