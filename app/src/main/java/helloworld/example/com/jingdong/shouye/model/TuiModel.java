package helloworld.example.com.jingdong.shouye.model;

import helloworld.example.com.jingdong.net.Api;
import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.net.RetrofitHelper;
import helloworld.example.com.jingdong.net.ServersApi;
import helloworld.example.com.jingdong.shouye.ShouYeBean;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 李天祥 on 2017/12/15.
 */

public class TuiModel implements ITuiModel{
    @Override
    public void getTui(final OnNetLisenter<ShouYeBean> onNetLisenter) {
        ServersApi serversApi = RetrofitHelper.getServersApi(Api.HOST_URL);
        Flowable<ShouYeBean> shouYeBeanFlowable = serversApi.syBean("ad", "getAd");
        shouYeBeanFlowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShouYeBean>() {
                    @Override
                    public void accept(ShouYeBean shouYeBean) throws Exception {
                        onNetLisenter.onSuccess(shouYeBean);
                    }
                });
    }
}
