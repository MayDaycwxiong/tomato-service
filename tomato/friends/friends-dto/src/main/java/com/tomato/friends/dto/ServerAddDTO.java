package com.tomato.friends.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
* @Description:    ServerAdd返回的DTO类
* @Author:         cuiwx
* @CreateDate:     2019/5/13 15:17
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/13 15:17
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@ToString
@Getter
@Setter
public class ServerAddDTO extends ServerAddPO implements Serializable {
    /**
     * 包装的PO类
     */
    private ServerAddPO serverAddPO;
    /**
     * 返回标志
     * 0 成功获取
     * 1 失败获取
     */
    private String flage;
}
