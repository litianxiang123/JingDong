package helloworld.example.com.jingdong.login.model;

import helloworld.example.com.jingdong.login.bean.LoginBean;
import helloworld.example.com.jingdong.net.OnNetLisenter;

/**
 * Created by 李天祥 on 2017/12/13.
 */

public interface ILoginModel {
    public void getLLogin(String m, String p, OnNetLisenter<LoginBean> onNetLisenter);
}
