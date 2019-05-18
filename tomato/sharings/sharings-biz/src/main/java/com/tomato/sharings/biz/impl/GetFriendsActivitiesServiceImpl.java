package com.tomato.sharings.biz.impl;

import com.tomato.common.CollectionUtil;
import com.tomato.sharings.biz.GetFriendsActivitiesService;
import com.tomato.sharings.dto.ActivityPO;
import com.tomato.sharings.dto.GetActivitysDTO;
import com.tomato.sharings.manager.GetFriendsActivitiesManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 获取好友动态Service
 * @Author: cuiwx
 * @CreateDate: 2019/5/18 12:04
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/18 12:04
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Slf4j
@Service
public class GetFriendsActivitiesServiceImpl implements GetFriendsActivitiesService {

    @Autowired
    private GetFriendsActivitiesManager getFriendsActivitiesManager;

    @Override
    public GetActivitysDTO getFriendsActivities(ActivityPO activityPO) {
        GetActivitysDTO getActivitysDTO = new GetActivitysDTO();
        List<ActivityPO> list = getFriendsActivitiesManager.getFriendsActivities(activityPO);
        dealData(getActivitysDTO, activityPO, list);
        return getActivitysDTO;
    }

    /**
     * 方法实现说明    处理服务器返回数据
     *
     * @author cuiwx
     * @date 2019/5/18 12:19
     */
    private void dealData(GetActivitysDTO getActivitysDTO, ActivityPO activityPO, List<ActivityPO> list) {
//        这里不需要判断数组为空的情况
//        if(CollectionUtil.isNotEmpty(list)){
//
//        }
        getActivitysDTO.setActivityPOList(list);
        getActivitysDTO.setFlag("0");
        log.info("获取好友动态成功");
    }
}
