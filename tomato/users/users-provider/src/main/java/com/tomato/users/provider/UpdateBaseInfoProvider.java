package com.tomato.users.provider;

import com.tomato.users.api.user.UpdateBaseInfoApi;
import com.tomato.users.biz.UpdateBaseInfoService;
import com.tomato.users.dto.user.UserDTO;
import com.tomato.users.dto.user.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 更新用户信息接口提供者
 * @Author: cuiwx
 * @CreateDate: 2019/5/11 0:08
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/11 0:08
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Service
public class UpdateBaseInfoProvider implements UpdateBaseInfoApi {

    @Autowired
    private UpdateBaseInfoService updateBaseInfoService;

    @Override
    public UserDTO updateBaseInfo(UserPO userPO) {
        return updateBaseInfoService.updateBaseInfo(userPO);
    }
}
