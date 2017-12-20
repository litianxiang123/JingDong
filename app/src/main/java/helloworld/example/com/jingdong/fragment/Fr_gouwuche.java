package helloworld.example.com.jingdong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import helloworld.example.com.jingdong.R;
import helloworld.example.com.jingdong.getCarts.CartsBean;
import helloworld.example.com.jingdong.getCarts.adapter.MyCartsAdapter;
import helloworld.example.com.jingdong.getCarts.eventBus.MessageEvent;
import helloworld.example.com.jingdong.getCarts.eventBus.PriceAndCountEvent;
import helloworld.example.com.jingdong.getCarts.presenter.CartsPresenter;
import helloworld.example.com.jingdong.view.ICartsActivity;

/**
 * Created by 李天祥 on 2017/12/13.
 */

public class Fr_gouwuche extends Fragment implements ICartsActivity{
    private View view;
    private ExpandableListView mElv;
    private CheckBox mCheckbox2;
    /**
     * 0
     */
    private TextView mTvPrice;
    /**
     * 结算(0)
     */
    private TextView mTvNum;
    private CartsPresenter cartsPresenter;
    private MyCartsAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fr_gouwuche, null);
        EventBus.getDefault().register(this);
        cartsPresenter = new CartsPresenter(this);
        cartsPresenter.getCarts("2084");
        initView(view);
        mCheckbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.changeAllListCbState(mCheckbox2.isChecked());
            }
        });
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void initView(View view) {
        mElv = (ExpandableListView) view.findViewById(R.id.elv);
        mCheckbox2 = (CheckBox) view.findViewById(R.id.checkbox2);
        mTvPrice = (TextView) view.findViewById(R.id.tv_price);
        mTvNum = (TextView) view.findViewById(R.id.tv_num);
    }

    @Override
    public void showData(List<CartsBean.DataBean> groupList, List<List<CartsBean.DataBean.DatasBean>> childList) {
        adapter = new MyCartsAdapter(getContext(),groupList,childList);
        mElv.setAdapter(adapter);
        mElv.setGroupIndicator(null);
        for (int i = 0; i < groupList.size(); i++) {
            mElv.expandGroup(i);
        }
    }

    @Subscribe
    public void onMessageEvent(MessageEvent event) {
        mCheckbox2.setChecked(event.isChecked());
    }

    @Subscribe
    public void onMessageEvent(PriceAndCountEvent event) {
        mTvNum.setText("结算(" + event.getCount() + ")");
        mTvPrice.setText(event.getPrice() + "");
    }

}
