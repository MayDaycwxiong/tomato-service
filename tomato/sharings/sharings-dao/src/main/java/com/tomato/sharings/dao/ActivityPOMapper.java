package com.tomato.sharings.dao;


import com.tomato.sharings.dto.ActivityPO;

import java.util.List;

public interface ActivityPOMapper {
    int deleteByPrimaryKey(Integer activityid);

    int insert(ActivityPO record);

    int insertSelective(ActivityPO record);

    ActivityPO selectByPrimaryKey(Integer activityid);

    int updateByPrimaryKeySelective(ActivityPO record);

    int updateByPrimaryKey(ActivityPO record);

    List<ActivityPO> selectActivities();
}