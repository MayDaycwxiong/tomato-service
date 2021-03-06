package com.tomato.users.biz.impl;

import com.tomato.common.StringUtil;
import com.tomato.users.biz.UpdateBaseInfoService;
import com.tomato.users.common.DateTranslate;
import com.tomato.users.dto.user.UserDTO;
import com.tomato.users.dto.user.UserPO;
import com.tomato.users.manager.UpdateBaseInfoManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;

/**
 * @Description: 更新用户信息Service
 * @Author: cuiwx
 * @CreateDate: 2019/5/11 0:12
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/11 0:12
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Slf4j
@Service
public class UpdateBaseInfoServiceImpl implements UpdateBaseInfoService {

    @Autowired
    private UpdateBaseInfoManager updateBaseInfoManager;

    @Override
    public UserDTO updateBaseInfo(UserPO userPO) {
        preUpdate(userPO);
        int update = updateBaseInfoManager.updateBaseInfo(userPO);
        UserDTO userDTO = new UserDTO();
        dealData(update, userDTO);
        return userDTO;
    }
    /**
    * 方法实现说明    参数检查
    * @author      cuiwx
    * @date        2019/5/12 10:49
    */
    private void preUpdate(UserPO userPO) {
        if(StringUtil.isNotEmpty(userPO.getBirthday())){
            Date date=null;
            try {
                date=DateTranslate.translateToDate(userPO.getBirthday());
                log.info("日期类型转换成功{}",date.toString());
                userPO.setUserbirthday(date);
            } catch (ParseException e) {
                e.printStackTrace();
                userPO.setUserbirthday(null);
            }
        }
    }

    /**
    * 方法实现说明    判断是否更新成功
    * @author      cuiwx
    * @date        2019/5/11 0:32
    */
    private void dealData(int update, UserDTO userDTO) {
        if (update == 1) {
            log.info("本次更新成功，更新记录数为：{}", update);
            userDTO.setFlag("0");
        } else {
            log.info("本次更新失败，更新记录数为：{}", update);
            userDTO.setFlag("1");
        }
    }
}
