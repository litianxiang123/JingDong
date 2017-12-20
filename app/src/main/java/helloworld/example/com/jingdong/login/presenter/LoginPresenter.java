package helloworld.example.com.jingdong.login.presenter;

import helloworld.example.com.jingdong.login.bean.LoginBean;
import helloworld.example.com.jingdong.login.model.ILoginModel;
import helloworld.example.com.jingdong.login.model.LoginModel;
import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.view.ILoginActivity;

/**
 * Created by 李天祥 on 2017/12/13.
 */

public class LoginPresenter {
    private ILoginActivity iLoginActivity;
    private ILoginModel iLoginModel;

    public LoginPresenter(ILoginActivity iLoginActivity) {
        this.iLoginActivity = iLoginActivity;
        iLoginModel = new LoginModel();
    }

    public void getLogin(String m,String p){
        iLoginModel.getLLogin(m, p, new OnNetLisenter<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                iLoginActivity.show(loginBean.getMsg());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });

    }


}
