package helloworld.example.com.jingdong.acticity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import helloworld.example.com.jingdong.R;
import helloworld.example.com.jingdong.sousuo.SouBean;
import helloworld.example.com.jingdong.sousuo.adapter.MySouAdapter;
import helloworld.example.com.jingdong.sousuo.presenter.SouPresenter;
import helloworld.example.com.jingdong.view.ISouActivity;

public class SouActivity extends AppCompatActivity implements ISouActivity, View.OnClickListener {

    private ImageView mIvSao;
    /**
     * 扫啊扫
     */
    private TextView mTvSao;
    /**
     * 都市丽人领劵满399减200
     */
    private EditText mEtName;
    private ImageView mIvMsg;
    /**
     * 信息
     */
    private TextView mTvMsg;
    private RecyclerView mSouRv;
    private ImageView mBtnSou;
    private SouPresenter souPresenter;

    private MySouAdapter mySouAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sou);
        souPresenter = new SouPresenter(this);

        initView();
    }

    private void initView() {
        mIvSao = (ImageView) findViewById(R.id.iv_sao);
        mTvSao = (TextView) findViewById(R.id.tv_sao);
        mEtName = (EditText) findViewById(R.id.et_name);
        mIvMsg = (ImageView) findViewById(R.id.iv_msg);
        mTvMsg = (TextView) findViewById(R.id.tv_msg);
        mSouRv = (RecyclerView) findViewById(R.id.sou_rv);
        mBtnSou = (ImageView) findViewById(R.id.btn_sou);
        mBtnSou.setOnClickListener(this);
    }

    @Override
    public void showData(List<SouBean.DataBean> dataBeen) {
        mSouRv.setLayoutManager(new LinearLayoutManager(this));
        mySouAdapter = new MySouAdapter(this,dataBeen);
        mSouRv.setAdapter(mySouAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_sou:
                souPresenter.getSou(mEtName.getText().toString().trim());
                break;
        }
    }
}
