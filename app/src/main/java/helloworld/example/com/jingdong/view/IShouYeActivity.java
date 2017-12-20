package helloworld.example.com.jingdong.view;

import java.util.List;

import helloworld.example.com.jingdong.shouye.ShouYeBean;

/**
 * Created by 李天祥 on 2017/12/15.
 */

public interface IShouYeActivity {
    public void showMiaoData(List<ShouYeBean.MiaoshaBean.ListBeanX> listBeanXes);

    public void showTuiData(List<ShouYeBean.TuijianBean.ListBean> listBeanList);
}
