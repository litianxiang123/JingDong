package helloworld.example.com.jingdong.catagory.model;

import helloworld.example.com.jingdong.catagory.CataGoryBean;
import helloworld.example.com.jingdong.catagory.ProductCatagoryBean;
import helloworld.example.com.jingdong.net.OnNetLisenter;

/**
 * Created by 李天祥 on 2017/12/13.
 */

public interface ICataGoryModel {
    public void getCataGory(OnNetLisenter<CataGoryBean> onNetLisenter);

    public void getProductCatagory(String c, OnNetLisenter<ProductCatagoryBean> onNetLisenter);
}
