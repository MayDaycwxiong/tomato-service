package com.tomato.friends.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * tb_usermessages
 */
@ToString
public class UserMessagesPO implements Serializable {
    /**
     * 消息id，主键
     * messageId
     */
    @ApiModelProperty(value = "消息id，主键", required = true)
    private Integer messageid;

    /**
     * 用户id，即用户账号，对应user表的userId,标识消息发送方
     * sender
     */
    @ApiModelProperty(value = "用户id，即用户账号，对应user表的userId,标识消息发送方", required = true)
    private String sender;

    /**
     * 用户id，即用户账号，对应user表的userId,标识消息接收方
     * receiver
     */
    @ApiModelProperty(value = "用户id，即用户账号，对应user表的userId,标识消息接收方", required = true)
    private String receiver;

    /**
     * 离线状态下消息内容
     * content
     */
    @ApiModelProperty(value = "离线状态下消息内容", required = true)
    private String content;

    /**
     * 标识发送消息的时间
     * sendTime
     */
    @ApiModelProperty(value = "标识发送消息的时间", required = true)
    private Date sendtime;

    /**
     * 接收方消息是否接受到，未接收到置为0，接收到则置为1
     * messageRecFlag
     */
    @ApiModelProperty(value = "接收方消息是否接受到，未接收到置为0，接收到则置为1", required = false)
    private String messagerecflag;

    /**
     * @return the value of tb_usermessages.messageId
     */
    public Integer getMessageid() {
        return messageid;
    }

    /**
     * @param messageid the value for tb_usermessages.messageId
     */
    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    /**
     * @return the value of tb_usermessages.sender
     */
    public String getSender() {
        return sender;
    }

    /**
     * @param sender the value for tb_usermessages.sender
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * @return the value of tb_usermessages.receiver
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * @param receiver the value for tb_usermessages.receiver
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * @return the value of tb_usermessages.content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the value for tb_usermessages.content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the value of tb_usermessages.sendTime
     */
    public Date getSendtime() {
        return sendtime;
    }

    /**
     * @param sendtime the value for tb_usermessages.sendTime
     */
    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    /**
     * @return the value of tb_usermessages.messageRecFlag
     */
    public String getMessagerecflag() {
        return messagerecflag;
    }

    /**
     * @param messagerecflag the value for tb_usermessages.messageRecFlag
     */
    public void setMessagerecflag(String messagerecflag) {
        this.messagerecflag = messagerecflag;
    }
}