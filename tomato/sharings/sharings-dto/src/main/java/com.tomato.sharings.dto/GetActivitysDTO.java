package com.tomato.sharings.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;

/**
* @Description:    获取好友动态(list)
* @Author:         cuiwx
* @CreateDate:     2019/5/18 11:51
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/18 11:51
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Slf4j
@Getter
@Setter
@ToString
public class GetActivitysDTO implements Serializable {
    private List<ActivityPO> activityPOList;
    /**
     * 获取成功标识
     * 0 成功
     * 1 失败
     */
    private String flag;
}
