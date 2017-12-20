package helloworld.example.com.jingdong.acticity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

import helloworld.example.com.jingdong.R;
import helloworld.example.com.jingdong.shop.ShopBean;
import helloworld.example.com.jingdong.shop.adapter.MyShopAdapter;
import helloworld.example.com.jingdong.shop.adapter.MyShopGridAdapter;
import helloworld.example.com.jingdong.shop.presenter.ShopPresenter;
import helloworld.example.com.jingdong.view.IShopActivity;

public class ShopActivity extends AppCompatActivity implements IShopActivity, View.OnClickListener {

    private ImageView mIvBack;
    /**
     * 扫啊扫
     */
    private LinearLayout mLlSao;
    private ImageButton mIvMsg;
    private LinearLayout mLlMsg;
    private LinearLayout mLlHead;
    private LinearLayout mLlNestToolBar;
    private RecyclerView mShopRv;
    private ShopPresenter shopPresenter;
    /**
     * 都市丽人领劵满399减200
     */
    private EditText mEtName;

    SharedPreferences con ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        Bundle bundle = this.getIntent().getExtras();
        String name = bundle.getString("name");
        shopPresenter = new ShopPresenter(this);
        shopPresenter.getShop(name);

        con = getSharedPreferences("isTrue", MODE_PRIVATE);
        con.edit().commit();
        initView();
    }

    private void initView() {
        mIvBack = (ImageView) findViewById(R.id.iv_back);
        mLlSao = (LinearLayout) findViewById(R.id.ll_sao);
        mIvMsg = (ImageButton) findViewById(R.id.iv_msg);
        mLlMsg = (LinearLayout) findViewById(R.id.ll_msg);
        mLlHead = (LinearLayout) findViewById(R.id.ll_head);
        mLlNestToolBar = (LinearLayout) findViewById(R.id.ll_nest_toolBar);
        mShopRv = (RecyclerView) findViewById(R.id.shop_rv);
        mIvBack.setOnClickListener(this);
        mEtName = (EditText) findViewById(R.id.et_name);
        mEtName.setOnClickListener(this);
        mIvMsg.setOnClickListener(this);
    }

    @Override
    public void showData(final List<ShopBean.DataBean> list) {
        mShopRv.setLayoutManager(new LinearLayoutManager(this));
        MyShopAdapter adapter = new MyShopAdapter(this, list);
        mShopRv.setAdapter(adapter);
        mIvMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isTrue = con.getBoolean("isTrue", true);
                if (isTrue){
                    mIvMsg.setImageResource(R.drawable.kind_grid);
                    mShopRv.setLayoutManager(new LinearLayoutManager(ShopActivity.this));
                    MyShopAdapter adapter = new MyShopAdapter(ShopActivity.this, list);
                    mShopRv.setAdapter(adapter);
                    //不要忘记提交
                    con.edit().putBoolean("isTrue",false).commit();
                }else {
                    mIvMsg.setImageResource(R.drawable.kind_liner);
                    mShopRv.setLayoutManager(new GridLayoutManager(ShopActivity.this,2));
                    MyShopGridAdapter myShopGridAdapter = new MyShopGridAdapter(ShopActivity.this,list);
                    mShopRv.setAdapter(myShopGridAdapter);
                    //不要忘记提交
                    con.edit().putBoolean("isTrue",true).commit();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.et_name:
                Intent intent = new Intent(ShopActivity.this, SouActivity.class);
                startActivity(intent);
                break;
        }
    }
}
