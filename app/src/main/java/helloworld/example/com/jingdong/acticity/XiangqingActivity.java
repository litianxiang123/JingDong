package helloworld.example.com.jingdong.acticity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import helloworld.example.com.jingdong.R;
import helloworld.example.com.jingdong.addCart.AddCartBean;
import helloworld.example.com.jingdong.addCart.presenter.AddPresenter;
import helloworld.example.com.jingdong.view.IAddActivity;
import helloworld.example.com.jingdong.view.IXiangqingActicity;
import helloworld.example.com.jingdong.xiangqing.XiangqingBean;
import helloworld.example.com.jingdong.xiangqing.presenter.XQPresenter;

public class XiangqingActivity extends AppCompatActivity implements View.OnClickListener ,IXiangqingActicity,IAddActivity{

    private ImageView mXqBack;
    private SimpleDraweeView mXqImg;
    /**
     * 123
     */
    private TextView mXqTvTitle;
    /**
     * 123
     */
    private TextView mXqTvSubhead;
    /**
     * 123
     */
    private TextView mXqTvPrice;
    /**
     * 加入购物车
     */
    private TextView mXqTvJia;
    /**
     * 立即购买
     */
    private TextView mXqTvBuy;
    private XQPresenter xqPresenter;
    private Uri uri;
    private AddPresenter addPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangqing);
        Bundle bundle = this.getIntent().getExtras();
        String name = bundle.getString("name");
        xqPresenter = new XQPresenter(this);
        xqPresenter.getXiangqing(name);
        addPresenter = new AddPresenter(this);
        initView();
    }

    private void initView() {
        mXqBack = (ImageView) findViewById(R.id.xq_back);
        mXqBack.setOnClickListener(this);
        mXqImg = (SimpleDraweeView) findViewById(R.id.xq_img);
        mXqTvTitle = (TextView) findViewById(R.id.xq_tv_title);
        mXqTvSubhead = (TextView) findViewById(R.id.xq_tv_subhead);
        mXqTvPrice = (TextView) findViewById(R.id.xq_tv_price);
        mXqTvJia = (TextView) findViewById(R.id.xq_tv_jia);
        mXqTvJia.setOnClickListener(this);
        mXqTvBuy = (TextView) findViewById(R.id.xq_tv_buy);
        mXqTvBuy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.xq_back:
                finish();
                break;
            case R.id.xq_tv_jia:
                Toast.makeText(XiangqingActivity.this,"加购成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.xq_tv_buy:
                break;
        }
    }

    @Override
    public void getData(XiangqingBean.DataBean dataBean) {
        String images = dataBean.getImages();
        String[] str = images.split("\\|");
        for (int i = 0; i < str.length; i++) {
            uri = Uri.parse(str[i]);
        }
        mXqImg.setImageURI(uri);
        mXqTvTitle.setText(dataBean.getTitle());
        mXqTvSubhead.setText(dataBean.getSubhead());
        mXqTvPrice.setText("￥"+dataBean.getPrice()+"");
        addPresenter.getAdd("2084",dataBean.getPid()+"");
    }

    @Override
    public void showAdd(AddCartBean addCartBean) {
        Log.i("TAG",addCartBean.toString());
    }
}
