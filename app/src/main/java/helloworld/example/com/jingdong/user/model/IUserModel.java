package helloworld.example.com.jingdong.user.model;

import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.user.UserBean;

/**
 * Created by 李天祥 on 2017/12/13.
 */

public interface IUserModel {
    public void getUser(String d, OnNetLisenter<UserBean> onNetLisenter);
}
