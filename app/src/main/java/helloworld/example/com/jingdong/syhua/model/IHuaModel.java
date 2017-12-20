package helloworld.example.com.jingdong.syhua.model;

import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.syhua.HuaBean;

/**
 * Created by 李天祥 on 2017/12/15.
 */

public interface IHuaModel {
    public void getHua(OnNetLisenter<HuaBean> onNetLisenter);
}
