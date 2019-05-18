package com.tomato.sharings.biz;

import com.tomato.sharings.dto.ActivityPO;
import com.tomato.sharings.dto.GetActivitysDTO;

/**
 * @Description: 获取好友动态Service接口
 * @Author: cuiwx
 * @CreateDate: 2019/5/18 12:02
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/18 12:02
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface GetFriendsActivitiesService {
    /**
     * 方法实现说明    获取好友动态
     *
     * @author cuiwx
     * @date 2019/5/18 12:03
     */
    GetActivitysDTO getFriendsActivities(ActivityPO activityPO);
}
