package helloworld.example.com.jingdong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import helloworld.example.com.jingdong.R;
import helloworld.example.com.jingdong.app.MyImageLoader;
import helloworld.example.com.jingdong.catagory.CataGoryBean;
import helloworld.example.com.jingdong.catagory.ProductCatagoryBean;
import helloworld.example.com.jingdong.catagory.adapter.Leftadapter;
import helloworld.example.com.jingdong.catagory.adapter.RightAdapter;
import helloworld.example.com.jingdong.catagory.presenter.CataGoryPresenter;
import helloworld.example.com.jingdong.view.ICataGoryActivity;
import helloworld.example.com.jingdong.widget.MyExpanableListView;

/**
 * Created by 李天祥 on 2017/12/13.
 */

public class Fr_fenlei extends Fragment implements ICataGoryActivity{
    private View view;
    private ListView mLvLeft;
    private Banner mBanner;
    private MyExpanableListView mElv;
    private Leftadapter leftadapter;
    private CataGoryPresenter cataGoryPresenter;
    private List<String> groupList = new ArrayList<>();
    private List<List<ProductCatagoryBean.DataBean.ListBean>> childList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fr_fenlei, null);
        initView(view);
        cataGoryPresenter = new CataGoryPresenter(this);
        cataGoryPresenter.getCataGory();
        mLvLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                leftadapter.press(position);
                CataGoryBean.DataBean dataBean = (CataGoryBean.DataBean) parent.getItemAtPosition(position);
                int cid = dataBean.getCid();
                cataGoryPresenter.getProductCatagory(cid+"");
            }
        });
        return view;
    }

    private void initView(View view) {
        mLvLeft = (ListView) view.findViewById(R.id.lv_left);
        mBanner = (Banner) view.findViewById(R.id.banner);
        mElv = (MyExpanableListView) view.findViewById(R.id.elv);

        mBanner.setImageLoader(new MyImageLoader());

        List<String> images = new ArrayList<>();

        images.add("https://m.360buyimg.com/n0/jfs/t6130/97/1370670410/180682/1109582a/593276b1Nd81fe723.jpg!q70.jpg");
        images.add("https://m.360buyimg.com/n0/jfs/t5815/178/2614671118/51656/7f52d137/593276c7N107b725a.jpg!q70.jpg");
        images.add("https://m.360buyimg.com/n0/jfs/t5815/178/2614671118/51656/7f52d137/593276c7N107b725a.jpg!q70.jpg");

        mBanner.setImages(images);
        mBanner.start();
    }

    @Override
    public void showData(List<CataGoryBean.DataBean> list) {
        leftadapter = new Leftadapter(getContext(),list);
        mLvLeft.setAdapter(leftadapter);
    }

    @Override
    public void showElvData(List<ProductCatagoryBean.DataBean> list) {
        groupList.clear();
        childList.clear();
        for (int i = 0; i < list.size(); i++) {
            ProductCatagoryBean.DataBean dataBean = list.get(i);
            groupList.add(dataBean.getName());
            childList.add(dataBean.getList());
        }
        RightAdapter adapter = new RightAdapter(getContext(),groupList,childList);
        mElv.setAdapter(adapter);
        for (int i = 0; i < list.size(); i++) {
            mElv.expandGroup(i);
        }
    }
}
