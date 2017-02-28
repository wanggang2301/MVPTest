package com.wg.mvptest;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wg.mvptest.bean.User;
import com.wg.mvptest.iview.IShowUserView;

public class MainActivity extends AppCompatActivity implements IShowUserView {

    private ImageView imageView;
    private Button btn;
    private TextView name_tv, age_tv, sex_tv;
    private ProgressDialog pd = null;

    private UserInfoPresenter userInfoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInfoPresenter = new UserInfoPresenter(this);
        btn = (Button) findViewById(R.id.btn);
        name_tv = (TextView) findViewById(R.id.name_tv);
        age_tv = (TextView) findViewById(R.id.age_tv);
        sex_tv = (TextView) findViewById(R.id.sex_tv);

        imageView = (ImageView) findViewById(R.id.ffffeee);

        pd = new ProgressDialog(this);
        pd.setMessage("正在加载……");
        final String imageurl ="http://m.1332255.com:81/news/upload/overseasInformation/photo/6515ad9c110b428998be0656b25afa24.png";


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInfoPresenter.getUserInfoToShow(1);
                ImageLoader.with(getApplicationContext(), imageurl, imageView);

            }
        });
    }


    @Override
    public void showFailedError() {
        Toast.makeText(this, "获取信息有误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {

        pd.show();
    }

    @Override
    public void hideLoading() {

        pd.cancel();

    }

    @Override
    public void toMainActivity(User user) {
        name_tv.setText(user.getName());
        age_tv.setText(user.getAge());
        sex_tv.setText(user.getSex());
    }


}
