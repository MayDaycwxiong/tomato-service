package com.tomato.sharings.api;

import com.tomato.sharings.dto.ActivityDTO;
import com.tomato.sharings.dto.ActivityPO;

/**
 * @Description: 用户发表动态接口
 * @Author: cuiwx
 * @CreateDate: 2019/5/18 10:53
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/18 10:53
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface AddActivityApi {
    /**
     * 方法实现说明    好友发表动态
     *
     * @author cuiwx
     * @date 2019/5/18 10:54
     */
    ActivityDTO addActivity(ActivityPO activityPO);
}
