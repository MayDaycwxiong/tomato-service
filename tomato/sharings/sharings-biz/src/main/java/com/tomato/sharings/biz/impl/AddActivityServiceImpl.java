package com.tomato.sharings.biz.impl;

import com.tomato.common.ObjectUtil;
import com.tomato.common.StringUtil;
import com.tomato.sharings.biz.AddActivityService;
import com.tomato.sharings.dto.ActivityDTO;
import com.tomato.sharings.dto.ActivityPO;
import com.tomato.sharings.manager.AddActivityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Description: 发表动态Service
 * @Author: cuiwx
 * @CreateDate: 2019/5/18 11:04
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/18 11:04
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Slf4j
@Service
public class AddActivityServiceImpl implements AddActivityService {

    @Autowired
    private AddActivityManager addActivityManager;

    @Override
    public ActivityDTO addActivity(ActivityPO activityPO) {
        ActivityDTO activityDTO = new ActivityDTO();
        int insert=0;
        if (ObjectUtil.isNotNull(activityPO) && StringUtil.isNotEmpty(activityPO.getUserid())
                && StringUtil.isNotEmpty(activityPO.getContentjson())) {
            // 服务器设置接收时间
            activityPO.setReceivetime(new Date());
            insert=addActivityManager.addActivity(activityPO);
        }
        DealData(activityDTO,activityPO,insert);
        return activityDTO;
    }
    /**
    * 方法实现说明    处理服务器返回数据
    * @author      cuiwx
    * @date        2019/5/18 11:21
    */
    private void DealData(ActivityDTO activityDTO, ActivityPO activityPO, int insert) {
        // 不满足插入条件或者插入失败
        if(insert==0){
            activityDTO.setActivityPO(activityPO);
            activityDTO.setFlag("1");
            log.info("发表动态失败");
        }else if(insert==1){
            activityDTO.setActivityPO(activityPO);
            activityDTO.setFlag("0");
            log.info("发表动态成功");
        }
    }
}
