package com.wg.mvptest;

import android.os.Handler;
import android.util.Log;

import com.wg.mvptest.bean.User;
import com.wg.mvptest.iuser.IGetUser;
import com.wg.mvptest.iuser.OnUserInfoListener;
import com.wg.mvptest.iview.IShowUserView;

/**
 * @author: Wangg
 * @Name：UserInfoPresenter
 * @Description:
 * @Created on:2016/11/1  16:37.
 */

public class UserInfoPresenter {

    private IGetUser iGetUser;

    private IShowUserView iShowUserView;

    private Handler mHandler = new Handler();

    public UserInfoPresenter(IShowUserView iShowUserView) {
        Log.d("ddffgg", iShowUserView + "");
        this.iShowUserView = iShowUserView;
        this.iGetUser = new GetUserInfo();  //获取model数据
    }

    public void getUserInfoToShow(int id) {
        iShowUserView.showLoading();

        iGetUser.getUserInfo(id, new OnUserInfoListener() {
            @Override
            public void getUserInfoSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        iShowUserView.toMainActivity(user);
                        iShowUserView.hideLoading();

                    }
                });
            }

            @Override
            public void getUserInfoFailed() {
                iShowUserView.showFailedError();
                iShowUserView.hideLoading();
            }
        });

    }

}
