package com.tomato.friends.api;

import com.tomato.friends.dto.ServerAddDTO;

/**
* @Description:    获取服务器IP以及端口信息
* @Author:         cuiwx
* @CreateDate:     2019/5/13 9:59
* @UpdateUser:     cuiwx
* @UpdateDate:     2019/5/13 9:59
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public interface GetServerInfoApi {
    /**
    * 方法实现说明    获取服务器IP以及端口信息
    * @author      cuiwx
    * @date        2019/5/13 10:03
    */
    ServerAddDTO getServerInfo();
}
