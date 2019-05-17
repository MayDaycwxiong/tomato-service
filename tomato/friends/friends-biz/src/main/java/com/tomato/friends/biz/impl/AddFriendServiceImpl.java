package com.tomato.friends.biz.impl;

import com.tomato.common.ObjectUtil;
import com.tomato.common.StringUtil;
import com.tomato.friends.biz.AddFriendService;
import com.tomato.friends.dto.FriendsOfUserGroupDTO;
import com.tomato.friends.dto.FriendsOfUserGroupPO;
import com.tomato.friends.manager.AddFriendManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @Description:    添加好友Service
* @Author:         cuiwx
* @CreateDate:     2019/5/17 13:06
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/17 13:06
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Slf4j
@Service
public class AddFriendServiceImpl implements AddFriendService {

    @Autowired
    private AddFriendManager addFriendManager;

    @Override
    public FriendsOfUserGroupDTO addFriend(FriendsOfUserGroupPO friendsOfUserGroupPO) {
        FriendsOfUserGroupDTO friendsOfUserGroupDTO=new FriendsOfUserGroupDTO();
        int insert=0;
        if(ObjectUtil.isNotNull(friendsOfUserGroupPO)&& StringUtil.isNotEmpty(friendsOfUserGroupPO.getUserid())
        &&StringUtil.isNotEmpty(friendsOfUserGroupPO.getFriend())&&ObjectUtil.isNotNull(friendsOfUserGroupPO.getUsergroupid())){
            insert=addFriendManager.addFriend(friendsOfUserGroupPO);
            log.info("添加好友记录数为{}",insert);
        }
        dealData(friendsOfUserGroupDTO,friendsOfUserGroupPO,insert);
        return friendsOfUserGroupDTO;
    }
    /**
    * 方法实现说明    处理服务器返回的数据
    * @author      cuiwx
    * @date        2019/5/17 13:24
    */
    private void dealData(FriendsOfUserGroupDTO friendsOfUserGroupDTO, FriendsOfUserGroupPO friendsOfUserGroupPO, int insert) {
        // 不能进行添加好友操作
        if(ObjectUtil.isNull(friendsOfUserGroupPO)|| StringUtil.isEmpty(friendsOfUserGroupPO.getUserid())
                ||StringUtil.isEmpty(friendsOfUserGroupPO.getFriend())||ObjectUtil.isNull(friendsOfUserGroupPO.getUsergroupid())||insert<1){
            friendsOfUserGroupDTO.setFriendsOfUserGroupPO(friendsOfUserGroupPO);
            friendsOfUserGroupDTO.setFlag("1");
            log.info("添加好友失败");
        }else if(insert==1){
            friendsOfUserGroupDTO.setFriendsOfUserGroupPO(friendsOfUserGroupPO);
            friendsOfUserGroupDTO.setFlag("0");
            log.info("添加好友成功");
        }
    }
}
