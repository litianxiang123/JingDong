package helloworld.example.com.jingdong.getCarts.model;

import helloworld.example.com.jingdong.getCarts.CartsBean;
import helloworld.example.com.jingdong.net.OnNetLisenter;

/**
 * Created by 李天祥 on 2017/12/16.
 */

public interface ICartsModel {
    public void getCarts(String u,OnNetLisenter<CartsBean> onNetLisenter);
}
