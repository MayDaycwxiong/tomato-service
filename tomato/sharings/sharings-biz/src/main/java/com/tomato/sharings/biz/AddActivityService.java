package com.tomato.sharings.biz;

import com.tomato.sharings.dto.ActivityDTO;
import com.tomato.sharings.dto.ActivityPO;

/**
 * @Description: 发表动态Sservice接口
 * @Author: cuiwx
 * @CreateDate: 2019/5/18 11:02
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/18 11:02
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface AddActivityService {
    /**
     * 方法实现说明    发表动态接口
     *
     * @author cuiwx
     * @date 2019/5/18 11:03
     */
    ActivityDTO addActivity(ActivityPO activityPO);
}
