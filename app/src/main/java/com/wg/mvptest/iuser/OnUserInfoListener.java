package com.wg.mvptest.iuser;

import com.wg.mvptest.bean.User;

/**
 * @author: Wangg
 * @Name：OnUserInfoListener
 * @Description:
 * @Created on:2016/11/1  16:22.
 */

public interface OnUserInfoListener {
    void getUserInfoSuccess(User user);

    void getUserInfoFailed();
}
