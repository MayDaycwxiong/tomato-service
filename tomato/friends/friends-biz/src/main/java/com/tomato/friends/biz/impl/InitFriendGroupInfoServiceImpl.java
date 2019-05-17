package com.tomato.friends.biz.impl;

import com.tomato.common.CollectionUtil;
import com.tomato.common.ObjectUtil;
import com.tomato.common.StringUtil;
import com.tomato.friends.biz.InitFriendGroupInfoService;
import com.tomato.friends.dto.UserGroupDTO;
import com.tomato.friends.dto.UserGroupPO;
import com.tomato.friends.extbean.friendsList.*;
import com.tomato.friends.manager.InitFriendGroupInfoManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 初始化好友分组Service
 * @Author: cuiwx
 * @CreateDate: 2019/5/17 2:38
 * @UpdateUser: cuiwx
 * @UpdateDate: 2019/5/17 2:38
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Slf4j
@Service
public class InitFriendGroupInfoServiceImpl implements InitFriendGroupInfoService {

    @Autowired
    private InitFriendGroupInfoManager initFriendGroupInfoManager;

    @Override
    public UserGroupDTO createFriendGroupInfo(UserGroupPO userGroupPO) {
        UserGroupDTO userGroupDTO=new UserGroupDTO();
        int insert=0;
        if(ObjectUtil.isNotNull(userGroupPO)&& StringUtil.isNotEmpty(userGroupPO.getUserid())){
            List<UserGroupPO> insertList = beforeCreat(userGroupPO);
            insert = initFriendGroupInfoManager.createFriendGroupInfo(insertList);
            log.info("好友分组初始化成功，插入记录数为{}",insert);
        }
        dealData(userGroupDTO,userGroupPO,insert);
        return userGroupDTO;
    }

    @Override
    public FriendsListDTO getFriendsList(UserGroupPO userGroupPO) {
        FriendsListDTO friendsListDTO=new FriendsListDTO();
        List<ResultListSql> list=null;
        if(ObjectUtil.isNotNull(userGroupPO)&&StringUtil.isNotEmpty(userGroupPO.getUserid())){
            list=initFriendGroupInfoManager.getFriendsList(userGroupPO);
            log.info("获取好友列表成功，共有好友列表数量为{}",list.size());
            translate(friendsListDTO,list);
        }
        dealData(friendsListDTO);
        return friendsListDTO;
    }
    /**
    * 方法实现说明    处理服务器返回的数据(==>好友列表数据)
    * @author      cuiwx
    * @date        2019/5/17 20:56
    */
    private void dealData(FriendsListDTO friendsListDTO) {
        if(CollectionUtil.isNotEmpty(friendsListDTO.getUserGroupInfoList())){
            friendsListDTO.setFlag("0");
            log.info("获取好友列表成功");
        }else{
            friendsListDTO.setFlag("1");
            log.info("获取好友列表失败");
        }
    }

    /**
    * 方法实现说明    把查询出来的列表数据进行转换
    * @author      cuiwx
    * @date        2019/5/17 17:39
    */
    private void translate(FriendsListDTO friendsListDTO, List<ResultListSql> list) {
        if(CollectionUtil.isNotEmpty(list)){
            List<UserGroupInfo> userGroupInfoList=new ArrayList<>();
            // UserGroupInfo.getUserGroupPO.getUsergroupid 好友分组的唯一标识
            Map<Integer,UserGroupInfo> map=new HashMap<>();
            for(ResultListSql rs:list){
                // 初始化好友分组，合并同一个分组下的好友信息
                if(!map.containsKey(rs.getUsergroupid())){
                    UserGroupInfo userGroupInfo=new UserGroupInfo();
                    // 某一个具体的分组信息，必定不为空字段
                    UserGroupPO userGroupPO=new UserGroupPO();
                    userGroupPO.setUsergroupid(rs.getUsergroupid());
                    userGroupPO.setUserid(rs.getUserid());
                    userGroupPO.setUsergroupname(rs.getUsergroupname());
                    // 初始化好友列表数组
                    List<FriendInfo> friendInfoList=new ArrayList<>();
                    userGroupInfo.setUserGroupPO(userGroupPO);
                    userGroupInfo.setFriendInfoList(friendInfoList);
                    // 初始化map
                    map.put(rs.getUsergroupid(),userGroupInfo);
                }
                // 该分组下必须有好友才进行赋值操作
                if(StringUtil.isNotEmpty(rs.getFriend())){
                    // 某一好友的具体信息
                    FriendInfo friendInfo=new FriendInfo();
                    friendInfo.setFriendId(rs.getFriend());
                    // 好友信息赋值
                    UserPO userPO=new UserPO();
                    userPO.setUsername(StringUtil.isNotEmpty(rs.getUsername())?rs.getUsername():"");
                    userPO.setUsericon(StringUtil.isNotEmpty(rs.getUsericon())?rs.getUsericon():"");
                    userPO.setUsersex(StringUtil.isNotEmpty(rs.getUsersex())?rs.getUsersex():"");
                    userPO.setUserbirthday(ObjectUtil.isNotNull(rs.getUserbirthday())?rs.getUserbirthday():null);
                    userPO.setUserage(ObjectUtil.isNotNull(rs.getUserage())?rs.getUserage():null);
                    userPO.setUseraddr(StringUtil.isNotEmpty(rs.getUseraddr())?rs.getUseraddr():"");
                    userPO.setUsermotto(StringUtil.isNotEmpty(rs.getUsermotto())?rs.getUsermotto():"");
                    userPO.setUserrole(StringUtil.isNotEmpty(rs.getUserrole())?rs.getUserrole():"");
                    friendInfo.setUserPO(userPO);
                    map.get(rs.getUsergroupid()).getFriendInfoList().add(friendInfo);
                }
            }
//            性能没有下面的高
//            for(Map.Entry<Integer,UserGroupInfo> friendMap:map.entrySet()){
//
//            }
            for(UserGroupInfo userGroupInfo:map.values()){
                userGroupInfoList.add(userGroupInfo);
            }
            friendsListDTO.setUserGroupInfoList(userGroupInfoList);
            map.clear();
            map=null;
        }
    }

    /**
    * 方法实现说明    处理服务器返回数据
    * @author      cuiwx
    * @date        2019/5/17 11:51
    */
    private void dealData(UserGroupDTO userGroupDTO, UserGroupPO userGroupPO, int insert) {
        // 插入不成功
        if(ObjectUtil.isNull(userGroupPO)||StringUtil.isEmpty(userGroupPO.getUserid())||insert<1){
            userGroupDTO.setUserGroupPO(userGroupPO);
            userGroupDTO.setFlag("1");
            log.info("好友分组初始化失败");
        }else if(insert==4){    // 这里好友初始化分组需要插入4条数据
            userGroupDTO.setUserGroupPO(userGroupPO);
            userGroupDTO.setFlag("0");
            log.info("好友分组初始化成功");
        }
    }

    /**
     * 方法实现说明   初始化好友分组
     *
     * @author cuiwx
     * @date 2019/5/17 10:48
     */
    private List<UserGroupPO> beforeCreat(UserGroupPO userGroupPO) {
        List<UserGroupPO> list = new ArrayList<>();
        UserGroupPO userGroupPO1 = new UserGroupPO(userGroupPO.getUserid(), "我的好友");
        list.add(userGroupPO1);
        UserGroupPO userGroupPO2 = new UserGroupPO(userGroupPO.getUserid(), "我的同学");
        list.add(userGroupPO2);
        UserGroupPO userGroupPO3 = new UserGroupPO(userGroupPO.getUserid(), "我的同事");
        list.add(userGroupPO3);
        UserGroupPO userGroupPO4 = new UserGroupPO(userGroupPO.getUserid(), "我的亲人");
        list.add(userGroupPO4);
        return list;
    }
}
