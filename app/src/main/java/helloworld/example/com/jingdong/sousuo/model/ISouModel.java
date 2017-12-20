package helloworld.example.com.jingdong.sousuo.model;

import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.sousuo.SouBean;

/**
 * Created by 李天祥 on 2017/12/15.
 */

public interface ISouModel {
    public void getSou(String k, OnNetLisenter<SouBean> onNetLisenter);
}
