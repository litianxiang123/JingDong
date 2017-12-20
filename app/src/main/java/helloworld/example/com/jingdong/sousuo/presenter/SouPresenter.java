package helloworld.example.com.jingdong.sousuo.presenter;

import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.sousuo.SouBean;
import helloworld.example.com.jingdong.sousuo.model.ISouModel;
import helloworld.example.com.jingdong.sousuo.model.SouModel;
import helloworld.example.com.jingdong.view.ISouActivity;

/**
 * Created by 李天祥 on 2017/12/15.
 */

public class SouPresenter {
    private ISouActivity iSouActivity;
    private ISouModel iSouModel;

    public SouPresenter(ISouActivity iSouActivity) {
        this.iSouActivity = iSouActivity;
        iSouModel = new SouModel();
    }

    public void getSou(String k){
        iSouModel.getSou(k, new OnNetLisenter<SouBean>() {
            @Override
            public void onSuccess(SouBean souBean) {
                iSouActivity.showData(souBean.getData());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
