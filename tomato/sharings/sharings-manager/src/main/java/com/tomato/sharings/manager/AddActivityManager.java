package com.tomato.sharings.manager;

import com.tomato.sharings.dao.ActivityPOMapper;
import com.tomato.sharings.dto.ActivityPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* @Description:    发表动态Manager
* @Author:         cuiwx
* @CreateDate:     2019/5/18 11:06
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/18 11:06
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Slf4j
@Component
public class AddActivityManager {

    @Autowired
    private ActivityPOMapper activityPOMapper;

    public int addActivity(ActivityPO activityPO){
        log.info("待插入的数据为{}",activityPO.toString());
       return activityPOMapper.insertSelective(activityPO);
    }
}
