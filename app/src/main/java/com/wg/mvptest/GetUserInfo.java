package com.wg.mvptest;

import com.wg.mvptest.bean.User;
import com.wg.mvptest.iuser.IGetUser;
import com.wg.mvptest.iuser.OnUserInfoListener;

/**
 * @author: Wangg
 * @Name：GetUserInfo
 * @Description:
 * @Created on:2016/11/1  16:34.
 */

public class GetUserInfo implements IGetUser {
    @Override
    public void getUserInfo(final int id, final OnUserInfoListener listener) {

        new Thread() {

            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }                // 模拟信息获取成功
                if (id == 1) {
                    User user = new User();
                    user.setName("非著名程序员");
                    user.setAge("26");
                    user.setSex("男");
                    user.setId("1");
                    listener.getUserInfoSuccess(user);
                } else {
                    listener.getUserInfoFailed();
                }
            }
        }.start();

    }
}
