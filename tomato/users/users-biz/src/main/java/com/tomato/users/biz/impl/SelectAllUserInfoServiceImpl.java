package com.tomato.users.biz.impl;

import com.tomato.common.ObjectUtil;
import com.tomato.users.biz.SelectAllUserInfoService;
import com.tomato.users.dto.user.UserDTO;
import com.tomato.users.dto.user.UserPO;
import com.tomato.users.manager.SelectAllUserInfoManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 获取用户所有信息Service
 * @Author: cuiwx
 * @CreateDate: 2019/5/11 17:28
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/11 17:28
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Slf4j
@Service
public class SelectAllUserInfoServiceImpl implements SelectAllUserInfoService {

    @Autowired
    private SelectAllUserInfoManager selectAllUserInfoManager;

    @Override
    public UserDTO selectAllUserInfo(UserPO userPO) {
        UserPO returnUserPO = selectAllUserInfoManager.selectAllUserInfo(userPO);
        UserDTO userDTO = new UserDTO();
        dealData(returnUserPO, userDTO, userPO);
        return userDTO;
    }

    /**
     * 方法实现说明    返回数据处理
     *
     * @author cuiwx
     * @date 2019/5/11 17:40
     */
    private void dealData(UserPO returnUserPO, UserDTO userDTO, UserPO userPO) {
        if (ObjectUtil.isNull(returnUserPO)) {
            log.info("查询结果为空");
            userDTO.setUserPO(userPO);
            userDTO.setFlag("1");
        } else {
            log.info("查询结果为:{}", returnUserPO.toString());
            returnUserPO.setUserpassword(null);     // 密码去除，防止非法获取密码
            userDTO.setUserPO(returnUserPO);
            userDTO.setFlag("0");
        }
    }
}
