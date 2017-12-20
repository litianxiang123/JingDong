package helloworld.example.com.jingdong.xiangqing.model;

import helloworld.example.com.jingdong.net.Api;
import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.net.RetrofitHelper;
import helloworld.example.com.jingdong.net.ServersApi;
import helloworld.example.com.jingdong.xiangqing.XiangqingBean;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 李天祥 on 2017/12/14.
 */

public class XQModel implements IXQModel{
    @Override
    public void getXiangqing(String d, final OnNetLisenter<XiangqingBean> onNetLisenter) {
        ServersApi serversApi = RetrofitHelper.getServersApi(Api.HOST_URL);
        Flowable<XiangqingBean> xiangqingBeanFlowable = serversApi.XQbean("product", "getProductDetail", "android", d);
        xiangqingBeanFlowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<XiangqingBean>() {
                    @Override
                    public void accept(XiangqingBean xiangqingBean) throws Exception {
                        onNetLisenter.onSuccess(xiangqingBean);
                    }
                });
    }
}
