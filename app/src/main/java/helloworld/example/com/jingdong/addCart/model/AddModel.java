package helloworld.example.com.jingdong.addCart.model;

import helloworld.example.com.jingdong.addCart.AddCartBean;
import helloworld.example.com.jingdong.net.Api;
import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.net.RetrofitHelper;
import helloworld.example.com.jingdong.net.ServersApi;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 李天祥 on 2017/12/15.
 */

public class AddModel implements IAddModel{
    @Override
    public void getAdd(String u, String d, final OnNetLisenter<AddCartBean> onNetLisenter) {
        ServersApi serversApi = RetrofitHelper.getServersApi(Api.HOST_URL);
        Flowable<AddCartBean> addCartBeanFlowable = serversApi.addBean("product", "addCart", "android", "2084", d);
        addCartBeanFlowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AddCartBean>() {
                    @Override
                    public void accept(AddCartBean addCartBean) throws Exception {
                        onNetLisenter.onSuccess(addCartBean);
                    }
                });
    }
}
