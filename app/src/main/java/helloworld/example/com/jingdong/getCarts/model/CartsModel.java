package helloworld.example.com.jingdong.getCarts.model;

import helloworld.example.com.jingdong.getCarts.CartsBean;
import helloworld.example.com.jingdong.net.Api;
import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.net.RetrofitHelper;
import helloworld.example.com.jingdong.net.ServersApi;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 李天祥 on 2017/12/16.
 */

public class CartsModel implements ICartsModel{
    @Override
    public void getCarts(String u, final OnNetLisenter<CartsBean> onNetLisenter) {
        ServersApi serversApi = RetrofitHelper.getServersApi(Api.HOST_URL);
        Flowable<CartsBean> cartsBeanFlowable = serversApi.cartsBean("product", "getCarts", "android", "2084");
        cartsBeanFlowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CartsBean>() {
                    @Override
                    public void accept(CartsBean cartsBean) throws Exception {
                        onNetLisenter.onSuccess(cartsBean);
                    }
                });

    }
}
