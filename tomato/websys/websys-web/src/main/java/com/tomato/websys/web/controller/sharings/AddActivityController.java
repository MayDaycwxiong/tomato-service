package com.tomato.websys.web.controller.sharings;

import com.tomato.common.ObjectUtil;
import com.tomato.sharings.api.AddActivityApi;
import com.tomato.sharings.dto.ActivityDTO;
import com.tomato.sharings.dto.ActivityPO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @Description:    用户更新动态Controller
* @Author:         cuiwx
* @CreateDate:     2019/5/18 10:27
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/18 10:27
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Slf4j
@Api(tags = "用户发表动态Restful接口")
@RestController
@RequestMapping("/sharings")
public class AddActivityController {

    @Autowired
    private AddActivityApi addActivityApi;

    @ApiOperation(value = "用户发表动态")
    @PostMapping("/addActivity.pub")
    public ActivityDTO addActivity(ActivityPO acvityPO){
        if(ObjectUtil.isNull(acvityPO)){
            log.info("Object is null");
        }else{
            log.info("请求参数为{}",acvityPO.toString());
        }
        return addActivityApi.addActivity(acvityPO);
    }
}
