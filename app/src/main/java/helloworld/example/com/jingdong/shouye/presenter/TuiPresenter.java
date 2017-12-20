package helloworld.example.com.jingdong.shouye.presenter;

import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.shouye.ShouYeBean;
import helloworld.example.com.jingdong.shouye.model.ITuiModel;
import helloworld.example.com.jingdong.shouye.model.TuiModel;
import helloworld.example.com.jingdong.view.IShouYeActivity;

/**
 * Created by 李天祥 on 2017/12/15.
 */

public class TuiPresenter {
    private IShouYeActivity iShouYeActivity;
    private ITuiModel iTuiModel;

    public TuiPresenter(IShouYeActivity iShouYeActivity) {
        this.iShouYeActivity = iShouYeActivity;
        iTuiModel = new TuiModel();
    }

    public void getTui(){
        iTuiModel.getTui(new OnNetLisenter<ShouYeBean>() {
            @Override
            public void onSuccess(ShouYeBean shouYeBean) {
                iShouYeActivity.showTuiData(shouYeBean.getTuijian().getList());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
