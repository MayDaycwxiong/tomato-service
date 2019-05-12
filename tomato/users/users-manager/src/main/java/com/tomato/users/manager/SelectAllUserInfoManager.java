package com.tomato.users.manager;

import com.tomato.users.dao.user.UserPOMapper;
import com.tomato.users.dto.user.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: 获取用户所有信息Manager
 * @Author: cuiwx
 * @CreateDate: 2019/5/11 17:31
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/11 17:31
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Slf4j
@Component
public class SelectAllUserInfoManager {

    @Autowired
    private UserPOMapper userPOMapper;

    public UserPO selectAllUserInfo(UserPO userPO) {
        String userid = userPO.getUserid();
        log.info("查询的账号是:{}", userid);
        return userPOMapper.selectByPrimaryKey(userid);
    }
}
