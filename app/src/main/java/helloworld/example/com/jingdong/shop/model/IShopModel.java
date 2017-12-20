package helloworld.example.com.jingdong.shop.model;

import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.shop.ShopBean;

/**
 * Created by 李天祥 on 2017/12/14.
 */

public interface IShopModel {
    public void getShop(String d, OnNetLisenter<ShopBean> onNetLisenter);
}
