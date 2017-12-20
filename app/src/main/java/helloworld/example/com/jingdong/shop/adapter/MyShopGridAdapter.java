package helloworld.example.com.jingdong.shop.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import helloworld.example.com.jingdong.R;
import helloworld.example.com.jingdong.acticity.XiangqingActivity;
import helloworld.example.com.jingdong.shop.ShopBean;

/**
 * Created by 李天祥 on 2017/12/19.
 */

public class MyShopGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<ShopBean.DataBean> list;
    private MyShopAdapter.OnItemClickListener onItemClickListener;

    public interface  OnItemClickListener{
        public void onItemClick(int a);
    }

    public void setOnItemClickListener(MyShopAdapter.OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }


    public MyShopGridAdapter(Context context, List<ShopBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shop_item2,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ShopBean.DataBean dataBean = list.get(position);
        MyShopGridAdapter.MyViewHolder myViewHolder = (MyShopGridAdapter.MyViewHolder) holder;
        String images = dataBean.getImages();
        String[] str = images.split("\\|");
        for (int i = 0; i < str.length; i++) {
            Uri uri = Uri.parse(str[i]);
            myViewHolder.shop_img.setImageURI(uri);
        }
        myViewHolder.shop_tv_title.setText(dataBean.getTitle());
        myViewHolder.shop_tv_price.setText("￥"+dataBean.getPrice()+"");
        myViewHolder.shop_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, XiangqingActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name",dataBean.getPid()+"");
                intent.putExtras(bundle);
                context.startActivity(intent);
                //  Toast.makeText(context,"a",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private SimpleDraweeView shop_img;
        private TextView shop_tv_title,shop_tv_price;
        private LinearLayout shop_ll;
        public MyViewHolder(View itemView) {
            super(itemView);
            shop_img = (SimpleDraweeView) itemView.findViewById(R.id.shop_img);
            shop_tv_title = (TextView) itemView.findViewById(R.id.shop_tv_title);
            shop_tv_price = (TextView) itemView.findViewById(R.id.shop_tv_price);
            shop_ll = (LinearLayout) itemView.findViewById(R.id.shop_ll);
        }
    }
}
