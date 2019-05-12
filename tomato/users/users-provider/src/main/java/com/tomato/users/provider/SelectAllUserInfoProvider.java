package com.tomato.users.provider;

import com.tomato.users.api.user.SelectAllUserInfoApi;
import com.tomato.users.biz.SelectAllUserInfoService;
import com.tomato.users.dto.user.UserDTO;
import com.tomato.users.dto.user.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 获取用户所有信息接口提供者
 * @Author: cuiwx
 * @CreateDate: 2019/5/11 17:28
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/11 17:28
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Service
public class SelectAllUserInfoProvider implements SelectAllUserInfoApi {

    @Autowired
    private SelectAllUserInfoService selectAllUserInfoService;

    @Override
    public UserDTO selectAllUserInfo(UserPO userPO) {
        return selectAllUserInfoService.selectAllUserInfo(userPO);
    }
}
