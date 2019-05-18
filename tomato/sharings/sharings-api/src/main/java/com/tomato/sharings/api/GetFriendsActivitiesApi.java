package com.tomato.sharings.api;

import com.tomato.sharings.dto.ActivityPO;
import com.tomato.sharings.dto.GetActivitysDTO;

/**
 * @Description: 获取好友动态(list)接口
 * @Author: cuiwx
 * @CreateDate: 2019/5/18 11:55
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/18 11:55
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface GetFriendsActivitiesApi {
    /**
     * 方法实现说明    获取好友动态
     *
     * @author cuiwx
     * @date 2019/5/18 11:56
     */
    GetActivitysDTO getFriendsActivities(ActivityPO activityPO);
}
