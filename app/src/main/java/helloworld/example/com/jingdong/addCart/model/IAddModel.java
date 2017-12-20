package helloworld.example.com.jingdong.addCart.model;

import helloworld.example.com.jingdong.addCart.AddCartBean;
import helloworld.example.com.jingdong.net.OnNetLisenter;

/**
 * Created by 李天祥 on 2017/12/15.
 */

public interface IAddModel {
    public void getAdd(String u, String d, OnNetLisenter<AddCartBean> onNetLisenter);
}
