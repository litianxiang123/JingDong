package helloworld.example.com.jingdong.login.model;

import helloworld.example.com.jingdong.login.bean.LoginBean;
import helloworld.example.com.jingdong.net.Api;
import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.net.RetrofitHelper;
import helloworld.example.com.jingdong.net.ServersApi;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 李天祥 on 2017/12/13.
 */

public class LoginModel implements ILoginModel{
    @Override
    public void getLLogin(String m, String p, final OnNetLisenter<LoginBean> onNetLisenter) {
        ServersApi serversApi = RetrofitHelper.getServersApi(Api.HOST_URL);
        Flowable<LoginBean> loginBeanFlowable = serversApi.loginBean("user","login",m,p);
        loginBeanFlowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        onNetLisenter.onSuccess(loginBean);
                    }
                });
    }
}
