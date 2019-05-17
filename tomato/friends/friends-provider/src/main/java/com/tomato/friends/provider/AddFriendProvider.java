package com.tomato.friends.provider;

import com.tomato.friends.api.AddFriendApi;
import com.tomato.friends.biz.AddFriendService;
import com.tomato.friends.dto.FriendsOfUserGroupDTO;
import com.tomato.friends.dto.FriendsOfUserGroupPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddFriendProvider implements AddFriendApi {

    @Autowired
    private AddFriendService addFriendService;

    @Override
    public FriendsOfUserGroupDTO addFriend(FriendsOfUserGroupPO friendsOfUserGroupPO) {
        return addFriendService.addFriend(friendsOfUserGroupPO);
    }
}
