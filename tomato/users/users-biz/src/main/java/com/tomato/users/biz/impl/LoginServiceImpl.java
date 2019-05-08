package com.tomato.users.biz.impl;

import com.tomato.common.ObjectUtil;
import com.tomato.users.biz.LoginService;
import com.tomato.users.dto.user.UserDTO;
import com.tomato.users.dto.user.UserPO;
import com.tomato.users.manager.LoginManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
* @Description:    登录service
* @Author:         cuiwx
* @CreateDate:     2019/5/7 22:52
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/7 22:52
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginManager loginManager;

    @Override
    public UserDTO login(UserPO userPO) {
        UserPO returnUserPO=loginManager.login(userPO);
        UserDTO userDTO=new UserDTO();
        dealData(returnUserPO,userDTO,userPO);
        return userDTO;
    }
    /**
    * 方法实现说明    验证密码是否相等
    * @author      cuiwx
    * @date        2019/5/8 19:45
    */
    private void dealData(UserPO returnUserPO, UserDTO userDTO, UserPO userPO) {
        if(ObjectUtil.isNull(returnUserPO)){
            log.info("账号对象不存在，查询结果为空");
            userDTO.setUserPO(userPO);
            userDTO.setFlag("-1");
        }else if(returnUserPO.getUserpassword().equals(userPO.getUserpassword())){
            log.info("查询结果为:{}",returnUserPO.toString());
            userDTO.setUserPO(returnUserPO);
            userDTO.setFlag("0");
        }else{
            log.info("查询结果为:{}",returnUserPO.toString());
            userDTO.setUserPO(userPO);
            userDTO.setFlag("1");
        }
    }

}
