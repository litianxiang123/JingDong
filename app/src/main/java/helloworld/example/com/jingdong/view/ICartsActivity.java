package helloworld.example.com.jingdong.view;

import java.util.List;

import helloworld.example.com.jingdong.getCarts.CartsBean;

/**
 * Created by 李天祥 on 2017/12/16.
 */

public interface ICartsActivity {
    public void showData(List<CartsBean.DataBean> groupList,List<List<CartsBean.DataBean.DatasBean>> childList);
}
