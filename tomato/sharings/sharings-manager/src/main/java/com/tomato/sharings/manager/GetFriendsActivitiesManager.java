package com.tomato.sharings.manager;

import com.tomato.sharings.dao.ActivityPOMapper;
import com.tomato.sharings.dto.ActivityPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class GetFriendsActivitiesManager {

    @Autowired
    private ActivityPOMapper activityPOMapper;

    /**
     * 方法实现说明    这里的参数暂时没有用到，后需考虑筛选指定用户下的好友动态信息
     *
     * @author cuiwx
     * @date 2019/5/18 12:15
     */
    public List<ActivityPO> getFriendsActivities(ActivityPO activityPO) {
        List<ActivityPO> activityPOList = activityPOMapper.selectActivities();
        log.info("获取好友动态完毕，共获取好友动态数{}", activityPOList.size());
        return activityPOList;
    }
}
