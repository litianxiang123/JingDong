package helloworld.example.com.jingdong.view;

import helloworld.example.com.jingdong.login.bean.LoginBean;

/**
 * Created by 李天祥 on 2017/12/13.
 */

public interface ILoginActivity {
    public String getAccount();

    public String getPwd();

    public void show(String str);

    public void showData(LoginBean.DataBean dataBean);
}
