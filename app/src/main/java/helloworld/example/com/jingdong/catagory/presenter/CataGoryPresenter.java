package helloworld.example.com.jingdong.catagory.presenter;

import java.util.List;

import helloworld.example.com.jingdong.catagory.CataGoryBean;
import helloworld.example.com.jingdong.catagory.ProductCatagoryBean;
import helloworld.example.com.jingdong.catagory.model.CataGoryModel;
import helloworld.example.com.jingdong.catagory.model.ICataGoryModel;
import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.view.ICataGoryActivity;

/**
 * Created by 李天祥 on 2017/12/13.
 */

public class CataGoryPresenter {
    private ICataGoryActivity iCataGoryActivity;
    private ICataGoryModel iCataGoryModel;

    public CataGoryPresenter(ICataGoryActivity iCataGoryActivity) {
        this.iCataGoryActivity = iCataGoryActivity;
        iCataGoryModel = new CataGoryModel();
    }

    public void getProductCatagory(String c){
        iCataGoryModel.getProductCatagory(c + "", new OnNetLisenter<ProductCatagoryBean>() {
            @Override
            public void onSuccess(ProductCatagoryBean productCatagoryBean) {
                iCataGoryActivity.showElvData(productCatagoryBean.getData());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

    public void getCataGory(){
        iCataGoryModel.getCataGory(new OnNetLisenter<CataGoryBean>() {
            @Override
            public void onSuccess(CataGoryBean cataGoryBean) {
                iCataGoryActivity.showData(cataGoryBean.getData());
                List<CataGoryBean.DataBean> dataBeen = cataGoryBean.getData();
                int cid = dataBeen.get(0).getCid();
                getProductCatagory(cid+"");
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
