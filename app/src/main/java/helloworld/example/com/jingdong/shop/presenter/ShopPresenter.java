package helloworld.example.com.jingdong.shop.presenter;

import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.shop.ShopBean;
import helloworld.example.com.jingdong.shop.model.IShopModel;
import helloworld.example.com.jingdong.shop.model.ShopModel;
import helloworld.example.com.jingdong.view.IShopActivity;

/**
 * Created by 李天祥 on 2017/12/14.
 */

public class ShopPresenter {
    private IShopActivity iShopActivity;
    private IShopModel iShopModel;

    public ShopPresenter(IShopActivity iShopActivity) {
        this.iShopActivity = iShopActivity;
        iShopModel = new ShopModel();
    }

    public void getShop(String d){
        iShopModel.getShop(d, new OnNetLisenter<ShopBean>() {
            @Override
            public void onSuccess(ShopBean shopBean) {
                iShopActivity.showData(shopBean.getData());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
