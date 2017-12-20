package helloworld.example.com.jingdong.user.model;

import helloworld.example.com.jingdong.net.Api;
import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.net.RetrofitHelper;
import helloworld.example.com.jingdong.net.ServersApi;
import helloworld.example.com.jingdong.user.UserBean;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 李天祥 on 2017/12/13.
 */

public class UserModel implements IUserModel{
    @Override
    public void getUser(String d, final OnNetLisenter<UserBean> onNetLisenter) {
        ServersApi serversApi = RetrofitHelper.getServersApi(Api.HOST_URL);
        Flowable<UserBean> userBeanFlowable = serversApi.userBean("user", "getUserInfo", "2084");
        userBeanFlowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserBean>() {
                    @Override
                    public void accept(UserBean userBean) throws Exception {
                        onNetLisenter.onSuccess(userBean);
                    }
                });

    }
}
