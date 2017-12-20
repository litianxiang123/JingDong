package helloworld.example.com.jingdong.syhua.presenter;

import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.syhua.HuaBean;
import helloworld.example.com.jingdong.syhua.model.HuaModel;
import helloworld.example.com.jingdong.syhua.model.IHuaModel;
import helloworld.example.com.jingdong.view.IHuaActivity;

/**
 * Created by 李天祥 on 2017/12/15.
 */

public class HuaPrenter {
    private IHuaActivity iHuaActivity;
    private IHuaModel iHuaModel;

    public HuaPrenter(IHuaActivity iHuaActivity) {
        this.iHuaActivity = iHuaActivity;
        iHuaModel = new HuaModel();
    }

    public void getHua(){
        iHuaModel.getHua(new OnNetLisenter<HuaBean>() {
            @Override
            public void onSuccess(HuaBean huaBean) {
                iHuaActivity.showData(huaBean.getData());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
