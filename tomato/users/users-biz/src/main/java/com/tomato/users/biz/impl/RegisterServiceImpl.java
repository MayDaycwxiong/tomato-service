package com.tomato.users.biz.impl;

import com.tomato.common.StringUtil;
import com.tomato.users.biz.RegisterService;
import com.tomato.users.dto.user.UserDTO;
import com.tomato.users.dto.user.UserPO;
import com.tomato.users.manager.RegisterManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 注册Service
 * @Author: cuiwx
 * @CreateDate: 2019/5/12 17:15
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/12 17:15
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Slf4j
@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterManager registerManager;

    @Override
    public UserDTO register(UserPO userPO) {
        UserPO returnUserPO = new UserPO();
        UserDTO userDTO = new UserDTO();
        if (StringUtil.isEmpty(userPO.getUserid())) {
            log.info("申请账号");
            String userid = registerManager.createUserid();
            log.info("申请成功的userid为{}", userid);
            returnUserPO.setUserid(userid);
            dealData(returnUserPO, userDTO, userPO);
        }else if(StringUtil.isNotEmpty(userPO.getUserid())&&StringUtil.isNotEmpty(userPO.getUserpassword())){
            // 初始化好友昵称(userName)与好友头像(userIcon)
            userPO.setUsername(userPO.getUserid());
            userPO.setUsericon("http://129.204.108.13:8888/group1/M00/00/00/rBAAB1zfjauAHPeyAADLkL5q2aY836.png");
            int register=registerManager.register(userPO);
            dealData(register,userDTO);
        }
        return userDTO;
    }

    /**
    * 方法实现说明    注册账号返回数据处理
    * @author      cuiwx
    * @date        2019/5/12 19:04
    */
    private void dealData(int register, UserDTO userDTO) {
        if(register==1){
            log.info("注册账号成功,插入记录数为{}",register);
            userDTO.setFlag("0");
        }else{
            log.info("注册账号失败,插入记录数为{}",register);
            userDTO.setFlag("1");
        }
    }

    /**
     * 方法实现说明    申请账号返回数据处理
     *
     * @author cuiwx
     * @date 2019/5/12 17:49
     */
    private void dealData(UserPO returnUserPO, UserDTO userDTO, UserPO userPO) {
        userDTO.setUserPO(returnUserPO);
        userDTO.setFlag("0");
        log.info("申请账号成功");
    }

}
