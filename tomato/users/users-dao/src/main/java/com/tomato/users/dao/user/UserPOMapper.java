package com.tomato.users.dao.user;

import com.tomato.users.dto.user.UserPO;
/**
* @Description:    tb_user mapper接口
* @Author:         cuiwx
* @CreateDate:     2019/5/7 22:54
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/7 22:54
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public interface UserPOMapper {
    int deleteByPrimaryKey(String userid);

    int insert(UserPO record);

    int insertSelective(UserPO record);

    UserPO selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(UserPO record);

    int updateByPrimaryKey(UserPO record);
}