package com.tomato.friends.manager;

import com.tomato.friends.dao.UserGroupPOMapper;
import com.tomato.friends.dto.UserGroupPO;
import com.tomato.friends.extbean.friendsList.ResultListSql;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* @Description:    java类作用描述
* @Author:         cuiwx
* @CreateDate:     2019/5/17 2:41
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/17 2:41
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Slf4j
@Component
public class InitFriendGroupInfoManager {

    @Autowired
    private UserGroupPOMapper userGroupPOMapper;

    public int createFriendGroupInfo(List<UserGroupPO> list){
        log.info("待插入数据条数为{}",list.size());
        return userGroupPOMapper.initFriendGroupInfo(list);
    }

    public List<ResultListSql> getFriendsList(UserGroupPO userGroupPO){
        log.info("当前查询好友列表的用户为{}",userGroupPO.getUserid());
        return userGroupPOMapper.userFriendsList(userGroupPO.getUserid());
    }

}
