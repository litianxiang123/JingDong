package helloworld.example.com.jingdong.getCarts.presenter;

import java.util.ArrayList;
import java.util.List;

import helloworld.example.com.jingdong.getCarts.CartsBean;
import helloworld.example.com.jingdong.getCarts.model.CartsModel;
import helloworld.example.com.jingdong.getCarts.model.ICartsModel;
import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.view.ICartsActivity;

/**
 * Created by 李天祥 on 2017/12/16.
 */

public class CartsPresenter {
    private ICartsActivity iCartsActivity;
    private ICartsModel iCartsModel;

    public CartsPresenter(ICartsActivity iCartsActivity) {
        this.iCartsActivity = iCartsActivity;
        iCartsModel = new CartsModel();
    }

    public void getCarts(String u){
        iCartsModel.getCarts(u, new OnNetLisenter<CartsBean>() {
            @Override
            public void onSuccess(CartsBean cartsBean) {
                List<CartsBean.DataBean> dataBeen = cartsBean.getData();
                List<List<CartsBean.DataBean.DatasBean>> childList = new ArrayList<List<CartsBean.DataBean.DatasBean>>();
                for (int i = 0; i < dataBeen.size(); i++) {
                    List<CartsBean.DataBean.DatasBean> datasBeen = dataBeen.get(i).getList();
                    childList.add(datasBeen);
                }
                iCartsActivity.showData(dataBeen,childList);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
