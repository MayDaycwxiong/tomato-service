package com.tomato.websys.web.controller.sharings;

import com.tomato.common.ObjectUtil;
import com.tomato.sharings.api.GetFriendsActivitiesApi;
import com.tomato.sharings.dto.ActivityPO;
import com.tomato.sharings.dto.GetActivitysDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @Description:    获取好友动态信息Controller
* @Author:         cuiwx
* @CreateDate:     2019/5/18 11:49
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/18 11:49
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Slf4j
@Api(tags = "获取好友动态信息Restful接口")
@RestController
@RequestMapping("/sharings")
public class GetFriendsActivitiesController {

    @Autowired
    private GetFriendsActivitiesApi getFriendsActivitiesApi;

    @ApiOperation(value = "获取好友动态(list)")
    @PostMapping("/getFriendsActivities.pub")
    public GetActivitysDTO getFriendsActivities(ActivityPO activityPO){
        if(ObjectUtil.isNull(activityPO)){
            log.info("Object is null");
        }else{
            log.info("请求参数为{}",activityPO.toString());
        }
        return getFriendsActivitiesApi.getFriendsActivities(activityPO);
    }
}
