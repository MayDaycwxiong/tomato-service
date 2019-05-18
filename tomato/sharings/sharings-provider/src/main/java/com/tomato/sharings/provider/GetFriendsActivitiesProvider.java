package com.tomato.sharings.provider;

import com.tomato.sharings.api.GetFriendsActivitiesApi;
import com.tomato.sharings.biz.GetFriendsActivitiesService;
import com.tomato.sharings.dto.ActivityPO;
import com.tomato.sharings.dto.GetActivitysDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
* @Description:    获取好友动态(list)接口提供者
* @Author:         cuiwx
* @CreateDate:     2019/5/18 11:57
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/18 11:57
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Service
public class GetFriendsActivitiesProvider implements GetFriendsActivitiesApi {

    @Autowired
    private GetFriendsActivitiesService getFriendsActivitiesService;

    @Override
    public GetActivitysDTO getFriendsActivities(ActivityPO activityPO) {
        return getFriendsActivitiesService.getFriendsActivities(activityPO);
    }
}
