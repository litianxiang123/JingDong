package helloworld.example.com.jingdong.register.model;

import helloworld.example.com.jingdong.net.Api;
import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.net.RetrofitHelper;
import helloworld.example.com.jingdong.net.ServersApi;
import helloworld.example.com.jingdong.register.RegisterBean;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 李天祥 on 2017/12/13.
 */

public class RegisterModel implements IRegisterModel{
    @Override
    public void getRegister(String m, String p, final OnNetLisenter<RegisterBean> onNetLisenter) {
        ServersApi serversApi = RetrofitHelper.getServersApi(Api.HOST_URL);
        Flowable<RegisterBean> registerBeanFlowable = serversApi.registerBean("user", "reg", m, p);
        registerBeanFlowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RegisterBean>() {
                    @Override
                    public void accept(RegisterBean registerBean) throws Exception {
                        onNetLisenter.onSuccess(registerBean);
                    }
                });
    }
}
