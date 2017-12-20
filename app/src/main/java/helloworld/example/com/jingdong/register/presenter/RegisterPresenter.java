package helloworld.example.com.jingdong.register.presenter;

import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.register.RegisterBean;
import helloworld.example.com.jingdong.register.model.IRegisterModel;
import helloworld.example.com.jingdong.register.model.RegisterModel;
import helloworld.example.com.jingdong.view.IRegisterActivity;

/**
 * Created by 李天祥 on 2017/12/13.
 */

public class RegisterPresenter {
    private IRegisterActivity iRegisterActivity;
    private IRegisterModel iRegisterModel;

    public RegisterPresenter(IRegisterActivity iRegisterActivity) {
        this.iRegisterActivity = iRegisterActivity;
        iRegisterModel = new RegisterModel();
    }

    public void getRegister(String m,String p){
        iRegisterModel.getRegister(m, p, new OnNetLisenter<RegisterBean>() {
            @Override
            public void onSuccess(RegisterBean registerBean) {
                iRegisterActivity.show(registerBean.getMsg());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
