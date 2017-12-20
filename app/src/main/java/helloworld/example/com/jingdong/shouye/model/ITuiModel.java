package helloworld.example.com.jingdong.shouye.model;

import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.shouye.ShouYeBean;

/**
 * Created by 李天祥 on 2017/12/15.
 */

public interface ITuiModel {
    public void getTui(OnNetLisenter<ShouYeBean> onNetLisenter);
}
