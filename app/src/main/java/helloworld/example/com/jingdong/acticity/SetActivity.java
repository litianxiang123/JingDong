package helloworld.example.com.jingdong.acticity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import helloworld.example.com.jingdong.R;

public class SetActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIvTx;
    /**
     * 登录/注册
     */
    private TextView mTvLore;
    private TextView mTvHy;
    private RelativeLayout mSetAddress;
    private ImageView mIvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        initView();
    }

    private void initView() {
        mIvTx = (ImageView) findViewById(R.id.iv_tx);
        mIvTx.setOnClickListener(this);
        mTvLore = (TextView) findViewById(R.id.tv_lore);
        mTvLore.setOnClickListener(this);
        mTvHy = (TextView) findViewById(R.id.tv_hy);
        mTvHy.setOnClickListener(this);
        mSetAddress = (RelativeLayout) findViewById(R.id.set_address);
        mSetAddress.setOnClickListener(this);
        mIvBack = (ImageView) findViewById(R.id.iv_back);
        mIvBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_lore:
                Intent intent = new Intent(SetActivity.this, LoginActivity.class);
                startActivityForResult(intent, 1);
                break;
            case R.id.tv_hy:
                break;
            case R.id.set_address:

                break;
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
