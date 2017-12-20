package helloworld.example.com.jingdong.syhua.model;

import helloworld.example.com.jingdong.net.Api;
import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.net.RetrofitHelper;
import helloworld.example.com.jingdong.net.ServersApi;
import helloworld.example.com.jingdong.syhua.HuaBean;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 李天祥 on 2017/12/15.
 */

public class HuaModel implements IHuaModel{
    @Override
    public void getHua(final OnNetLisenter<HuaBean> onNetLisenter) {
        ServersApi serversApi = RetrofitHelper.getServersApi(Api.HOST_URL);
        Flowable<HuaBean> huaBeanFlowable = serversApi.huaBean("product","getCatagory");
        huaBeanFlowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HuaBean>() {
                    @Override
                    public void accept(HuaBean huaBean) throws Exception {
                        onNetLisenter.onSuccess(huaBean);
                    }
                });
    }
}
