package helloworld.example.com.jingdong.xiangqing.model;

import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.xiangqing.XiangqingBean;

/**
 * Created by 李天祥 on 2017/12/14.
 */

public interface IXQModel {
    public void getXiangqing(String d, OnNetLisenter<XiangqingBean> onNetLisenter);
}
