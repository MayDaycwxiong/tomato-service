package com.tomato.users.manager;

import com.tomato.users.dao.user.UserPOMapper;
import com.tomato.users.dto.user.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Description: 注册manager
 * @Author: cuiwx
 * @CreateDate: 2019/5/12 17:23
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/12 17:23
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Slf4j
@Component
public class RegisterManager {

    @Autowired
    private UserPOMapper userPOMapper;

    public String createUserid(){
        String numberChar="0123456789";
        StringBuffer sb = new StringBuffer();
        sb.append("1");
        UserPO userPO=null;
        do {
            long seed = System.currentTimeMillis();
            Random random = new Random(seed);
            for (int i = 0; i < 10; i++) {
                sb.append(numberChar.charAt(random.nextInt(numberChar.length())));
            }
            log.info("随机生成的userid为{}", sb.toString());
            userPO=userPOMapper.selectByPrimaryKey(sb.toString());
            if(userPO!=null){
                sb.delete(1,sb.length());
            }
        }while(userPO!=null);
        return sb.toString();
    }

    public int register(UserPO userPO){
        int register=userPOMapper.insertSelective(userPO);
        log.info("本次插入记录条数{}",register);
        return register;
    }
}
