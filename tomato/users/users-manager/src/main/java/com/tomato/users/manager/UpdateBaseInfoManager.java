package com.tomato.users.manager;

import com.tomato.users.dao.user.UserPOMapper;
import com.tomato.users.dto.user.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: 用户基本信息变更Manager
 * @Author: cuiwx
 * @CreateDate: 2019/5/11 0:16
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/11 0:16
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Slf4j
@Component
public class UpdateBaseInfoManager {
    @Autowired
    private UserPOMapper userPOMapper;

    public int updateBaseInfo(UserPO userPO) {
        int update = userPOMapper.updateByPrimaryKeySelective(userPO);
        log.info("本次更新记录数:{}", update);
        return update;
    }
}
