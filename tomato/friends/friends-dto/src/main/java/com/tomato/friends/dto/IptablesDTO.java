package com.tomato.friends.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Description: 对IptablesPO类进行封装
 * @Author: cuiwx
 * @CreateDate: 2019/5/15 13:29
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/15 13:29
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@ToString
@Getter
@Setter
public class IptablesDTO implements Serializable {

    private IptablesPO iptablesPO;
    /**
     * 返回标识
     * 0 为获取成功
     * 1为获取失败
     */
    private String flag;

}
