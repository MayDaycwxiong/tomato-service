package com.tomato.sharings.provider;

import com.tomato.sharings.api.AddActivityApi;
import com.tomato.sharings.biz.AddActivityService;
import com.tomato.sharings.dto.ActivityDTO;
import com.tomato.sharings.dto.ActivityPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @Description:    用户发表动态接口提供者
* @Author:         cuiwx
* @CreateDate:     2019/5/18 10:56
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/18 10:56
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Service
public class AddActivityProvider implements AddActivityApi {

    @Autowired
    private AddActivityService addActivityService;

    @Override
    public ActivityDTO addActivity(ActivityPO activityPO) {
        return addActivityService.addActivity(activityPO);
    }
}
