package com.tomato.sharings.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
* @Description:    对ActivityPO类进行封装
* @Author:         cuiwx
* @CreateDate:     2019/5/18 10:48
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/18 10:48
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Setter
@Getter
@ToString
public class ActivityDTO implements Serializable {
    private ActivityPO activityPO;
    /**
     * 成功标识
     * 0 成功
     * 1 失败
     */
    private String flag;
}
