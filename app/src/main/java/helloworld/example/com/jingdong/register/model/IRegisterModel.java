package helloworld.example.com.jingdong.register.model;

import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.register.RegisterBean;

/**
 * Created by 李天祥 on 2017/12/13.
 */

public interface IRegisterModel {
    public void getRegister(String m, String p, OnNetLisenter<RegisterBean> onNetLisenter);
}
