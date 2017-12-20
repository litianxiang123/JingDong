package helloworld.example.com.jingdong.addCart.presenter;

import helloworld.example.com.jingdong.addCart.AddCartBean;
import helloworld.example.com.jingdong.addCart.model.AddModel;
import helloworld.example.com.jingdong.addCart.model.IAddModel;
import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.view.IAddActivity;

/**
 * Created by 李天祥 on 2017/12/16.
 */

public class AddPresenter {
    private IAddActivity iAddActivity;
    private IAddModel iAddModel;

    public AddPresenter(IAddActivity iAddActivity) {
        this.iAddActivity = iAddActivity;
        iAddModel = new AddModel();
    }

    public void getAdd(String u,String d){
        iAddModel.getAdd(u, d, new OnNetLisenter<AddCartBean>() {
            @Override
            public void onSuccess(AddCartBean addCartBean) {
                iAddActivity.showAdd(addCartBean);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
