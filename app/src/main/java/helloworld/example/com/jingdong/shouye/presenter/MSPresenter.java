package helloworld.example.com.jingdong.shouye.presenter;

import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.shouye.ShouYeBean;
import helloworld.example.com.jingdong.shouye.model.IMSModel;
import helloworld.example.com.jingdong.shouye.model.MSModel;
import helloworld.example.com.jingdong.view.IShouYeActivity;

/**
 * Created by 李天祥 on 2017/12/15.
 */

public class MSPresenter {
    private IShouYeActivity iShouYeActivity;
    private IMSModel imsModel;

    public MSPresenter(IShouYeActivity iShouYeActivity) {
        this.iShouYeActivity = iShouYeActivity;
        imsModel = new MSModel();
    }
    public void getMiao(){
        imsModel.getMiao(new OnNetLisenter<ShouYeBean>() {
            @Override
            public void onSuccess(ShouYeBean shouYeBean) {

                iShouYeActivity.showMiaoData(shouYeBean.getMiaosha().getList());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
