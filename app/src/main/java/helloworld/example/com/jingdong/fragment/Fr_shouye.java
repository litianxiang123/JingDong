package helloworld.example.com.jingdong.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import helloworld.example.com.jingdong.R;
import helloworld.example.com.jingdong.acticity.SouActivity;
import helloworld.example.com.jingdong.app.MyImageLoader;
import helloworld.example.com.jingdong.shouye.ShouYeBean;
import helloworld.example.com.jingdong.shouye.adapter.MyMiaoAdapter;
import helloworld.example.com.jingdong.shouye.adapter.MyTuiAdapter;
import helloworld.example.com.jingdong.shouye.presenter.MSPresenter;
import helloworld.example.com.jingdong.shouye.presenter.TuiPresenter;
import helloworld.example.com.jingdong.syhua.HuaBean;
import helloworld.example.com.jingdong.syhua.adapter.MyHuaAdapter;
import helloworld.example.com.jingdong.syhua.presenter.HuaPrenter;
import helloworld.example.com.jingdong.view.IHuaActivity;
import helloworld.example.com.jingdong.view.IShouYeActivity;

/**
 * Created by 李天祥 on 2017/12/13.
 */

public class Fr_shouye extends Fragment implements IHuaActivity, IShouYeActivity, View.OnClickListener {
    private View view;
    private Banner mLunbo;
    private RecyclerView mRv;
    private HuaPrenter huaPrenter;
    private RecyclerView mMsRv;
    private MSPresenter msPresenter;
    private RecyclerView mTuiRv;
    private TuiPresenter tuiPresenter;
    /**
     * 都市丽人领劵满399减200
     */
    private EditText mEtName;
    private TextView mTime;

    private long mHour = 02;
    private long mMin = 15;
    private long mSecond = 36;
    private boolean isRun = true;
    String hourStr;
    String minuteStr;
    String secondStr;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fr_shouye, null);
        huaPrenter = new HuaPrenter(this);
        huaPrenter.getHua();
        msPresenter = new MSPresenter(this);
        msPresenter.getMiao();
        tuiPresenter = new TuiPresenter(this);
        tuiPresenter.getTui();
        initView(view);
        return view;
    }

    private void initView(View view) {
        mLunbo = (Banner) view.findViewById(R.id.lunbo);
        mRv = (RecyclerView) view.findViewById(R.id.rv);
        mLunbo.setImageLoader(new MyImageLoader());

        List<String> imgList = new ArrayList<>();

        imgList.add("https://www.zhaoapi.cn/images/quarter/ad1.png");
        imgList.add("https://www.zhaoapi.cn/images/quarter/ad2.png");
        imgList.add("https://www.zhaoapi.cn/images/quarter/ad3.png");
        imgList.add("https://www.zhaoapi.cn/images/quarter/ad4.png");

        mLunbo.setImages(imgList);
        mLunbo.start();
        // mRv.setLayoutManager(new GridLayoutManager(getContext(),6));
        mMsRv = (RecyclerView) view.findViewById(R.id.ms_rv);
        mTuiRv = (RecyclerView) view.findViewById(R.id.tui_rv);
        mEtName = (EditText) view.findViewById(R.id.et_name);
        mEtName.setOnClickListener(this);
        mTime = (TextView) view.findViewById(R.id.time);
        //startRun();
    }
        private void startRun() {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    while (isRun) {
                        try {
                            Thread.sleep(1000); // sleep 1000ms
                            Message message = Message.obtain();
                            message.what = 1;
                            timeHandler.sendMessage(message);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        /**
         * 倒计时计算
         */
        private void computeTime() {
            mSecond--;
            if (mSecond < 0) {
                mMin--;
                mSecond = 59;
                if (mMin < 0) {
                    mMin = 59;
                    mHour--;
                }
            }

    }

    private Handler timeHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==1) {
                computeTime();
                if (mHour<10){
                    hourStr="0"+mHour+"";
                }else {
                    hourStr="0"+mHour+"";
                }
                if (mMin<10){
                    minuteStr=mMin+"";
                }else {
                    minuteStr=mMin+"";
                }
                if (mSecond<10){
                    secondStr="0"+mSecond+"";
                }else {
                    secondStr=mSecond+"";
                }
            }
            mTime.setText("倒计时："+hourStr+"小时"+minuteStr+"分钟"+secondStr+"秒");
        }
    };

    @Override
    public void showData(List<HuaBean.DataBean> list) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setOrientation(gridLayoutManager.HORIZONTAL);
        mRv.setLayoutManager(gridLayoutManager);
        MyHuaAdapter adapter = new MyHuaAdapter(getContext(), list);
        mRv.setAdapter(adapter);
    }

    @Override
    public void showMiaoData(List<ShouYeBean.MiaoshaBean.ListBeanX> listBeanXes) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        gridLayoutManager.setOrientation(gridLayoutManager.HORIZONTAL);
        mMsRv.setLayoutManager(gridLayoutManager);
        MyMiaoAdapter myMiaoAdapter = new MyMiaoAdapter(getContext(), listBeanXes);
        mMsRv.setAdapter(myMiaoAdapter);
    }

    @Override
    public void showTuiData(List<ShouYeBean.TuijianBean.ListBean> listBeanList) {
        mTuiRv.setLayoutManager(new GridLayoutManager(getContext(), 2));
        MyTuiAdapter myTuiAdapter = new MyTuiAdapter(getContext(), listBeanList);
        mTuiRv.setAdapter(myTuiAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.et_name:
                Intent intent = new Intent(getContext(), SouActivity.class);
                startActivity(intent);
                break;
        }
    }
}
