package helloworld.example.com.jingdong.view;

import java.util.List;

import helloworld.example.com.jingdong.catagory.CataGoryBean;
import helloworld.example.com.jingdong.catagory.ProductCatagoryBean;

/**
 * Created by 李天祥 on 2017/12/13.
 */

public interface ICataGoryActivity {
    public void showData(List<CataGoryBean.DataBean> list);

    public void showElvData(List<ProductCatagoryBean.DataBean> list);
}
