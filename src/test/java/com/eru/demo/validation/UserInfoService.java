package com.eru.demo.validation;

import javax.validation.Valid;

/**
 * Created by eru on 2019/12/15.
 */
public class UserInfoService {

    /**
     * userInfo作为输入参数
     * @param userInfo
     */
    public void setUserInfo(@Valid UserInfo userInfo){}

    /**
     * 对返回值进行检验
     * @return
     */
    public @Valid UserInfo getUserInfo(){
        return new UserInfo();
    }


    public UserInfoService() {
    }

    public UserInfoService(UserInfo userInfo) {

    }
}
