package helloworld.example.com.jingdong.shouye.adapter;

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
import helloworld.example.com.jingdong.shouye.ShouYeBean;

/**
 * Created by 李天祥 on 2017/12/15.
 */

public class MyMiaoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<ShouYeBean.MiaoshaBean.ListBeanX> list;
    private  OnItemClickListener onItemClickListener;

    public MyMiaoAdapter(Context context, List<ShouYeBean.MiaoshaBean.ListBeanX> list) {
        this.context = context;
        this.list = list;
    }

    //1、接口回调第一步，先定义一个接口
    public interface OnItemClickListener{
        public void onItemClick(ShouYeBean.MiaoshaBean.ListBeanX listBeanX);
    }

    //3.定义一个方法
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sy_miao_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        final ShouYeBean.MiaoshaBean.ListBeanX listBeanX = list.get(position);
        final String images = listBeanX.getImages();
        String[] str = images.split("\\|");
        for (int i = 0; i < str.length; i++) {
            Uri uri = Uri.parse(str[i]);
            myViewHolder.miao_img.setImageURI(uri);
        }
        myViewHolder.miao_price.setText(listBeanX.getPrice()+"");
        myViewHolder.miao_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, XiangqingActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name",listBeanX.getPid()+"");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private SimpleDraweeView miao_img;
        private TextView miao_price;
        private LinearLayout miao_ll;
        public MyViewHolder(View itemView) {
            super(itemView);

            miao_img = (SimpleDraweeView) itemView.findViewById(R.id.miao_img);
            miao_price = (TextView) itemView.findViewById(R.id.miao_price);
            miao_ll = (LinearLayout) itemView.findViewById(R.id.miao_ll);
        }
    }
}
