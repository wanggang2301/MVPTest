package com.wg.mvptest.iview;

import com.wg.mvptest.bean.User;

/**
 * @author: Wangg
 * @Name：IShowUserView
 * @Description:
 * @Created on:2016/11/1  16:32.
 */

public interface IShowUserView {
    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();

}
