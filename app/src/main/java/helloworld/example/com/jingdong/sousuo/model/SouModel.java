package helloworld.example.com.jingdong.sousuo.model;

import helloworld.example.com.jingdong.net.Api;
import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.net.RetrofitHelper;
import helloworld.example.com.jingdong.net.ServersApi;
import helloworld.example.com.jingdong.sousuo.SouBean;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 李天祥 on 2017/12/15.
 */

public class SouModel implements ISouModel{
    @Override
    public void getSou(String k, final OnNetLisenter<SouBean> onNetLisenter) {
        ServersApi serversApi = RetrofitHelper.getServersApi(Api.HOST_URL);
        Flowable<SouBean> souBeanFlowable = serversApi.souBean("product", "searchProducts","android", k);
        souBeanFlowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SouBean>() {
                    @Override
                    public void accept(SouBean souBean) throws Exception {
                        onNetLisenter.onSuccess(souBean);
                    }
                });
    }
}
