package helloworld.example.com.jingdong.xiangqing.presenter;

import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.view.IXiangqingActicity;
import helloworld.example.com.jingdong.xiangqing.XiangqingBean;
import helloworld.example.com.jingdong.xiangqing.model.IXQModel;
import helloworld.example.com.jingdong.xiangqing.model.XQModel;

/**
 * Created by 李天祥 on 2017/12/14.
 */

public class XQPresenter {
    private IXiangqingActicity iXiangqingActicity;
    private IXQModel ixqModel;

    public XQPresenter(IXiangqingActicity iXiangqingActicity) {
        this.iXiangqingActicity = iXiangqingActicity;
        ixqModel = new XQModel();
    }

    public void getXiangqing(String d){
       ixqModel.getXiangqing(d, new OnNetLisenter<XiangqingBean>() {
           @Override
           public void onSuccess(XiangqingBean xiangqingBean) {
               XiangqingBean.DataBean data = xiangqingBean.getData();
               iXiangqingActicity.getData(data);
           }

           @Override
           public void onFailure(Exception e) {

           }
       });
    }
}
