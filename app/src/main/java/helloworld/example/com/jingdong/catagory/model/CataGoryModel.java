package helloworld.example.com.jingdong.catagory.model;

import helloworld.example.com.jingdong.catagory.CataGoryBean;
import helloworld.example.com.jingdong.catagory.ProductCatagoryBean;
import helloworld.example.com.jingdong.net.Api;
import helloworld.example.com.jingdong.net.OnNetLisenter;
import helloworld.example.com.jingdong.net.RetrofitHelper;
import helloworld.example.com.jingdong.net.ServersApi;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 李天祥 on 2017/12/13.
 */

public class CataGoryModel implements ICataGoryModel{
    @Override
    public void getCataGory(final OnNetLisenter<CataGoryBean> onNetLisenter) {
        ServersApi serversApi = RetrofitHelper.getServersApi(Api.HOST_URL);
        Flowable<CataGoryBean> cataGoryBeanFlowable = serversApi.cataGoryBean("product","getCatagory");
        cataGoryBeanFlowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CataGoryBean>() {
                    @Override
                    public void accept(CataGoryBean cataGoryBean) throws Exception {
                        onNetLisenter.onSuccess(cataGoryBean);
                    }
                });
    }

    @Override
    public void getProductCatagory(String c, final OnNetLisenter<ProductCatagoryBean> onNetLisenter) {
        ServersApi serversApi = RetrofitHelper.getServersApi(Api.HOST_URL);
        Flowable<ProductCatagoryBean> productCatagoryBeanFlowable = serversApi.proBean("product", "getProductCatagory", c);
        productCatagoryBeanFlowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ProductCatagoryBean>() {
                    @Override
                    public void accept(ProductCatagoryBean productCatagoryBean) throws Exception {
                        onNetLisenter.onSuccess(productCatagoryBean);
                    }
                });
    }
}
