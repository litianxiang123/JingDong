package helloworld.example.com.jingdong.user.presenter;

import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.user.UserBean;
import helloworld.example.com.jingdong.user.model.IUserModel;
import helloworld.example.com.jingdong.user.model.UserModel;
import helloworld.example.com.jingdong.view.IUserActivity;

/**
 * Created by 李天祥 on 2017/12/13.
 */

public class UserPresenter {
    private IUserActivity iUserActivity;
    private IUserModel iUserModel;

    public UserPresenter(IUserActivity iUserActivity) {
        this.iUserActivity = iUserActivity;
        iUserModel = new UserModel();
    }

    public void getUser(String d){
        iUserModel.getUser(d, new OnNetLisenter<UserBean>() {
            @Override
            public void onSuccess(UserBean userBean) {
                iUserActivity.showData(userBean.getData());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
