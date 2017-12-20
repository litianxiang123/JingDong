package helloworld.example.com.jingdong.sousuo.adapter;

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
import helloworld.example.com.jingdong.sousuo.SouBean;

/**
 * Created by 李天祥 on 2017/12/15.
 */

public class MySouAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<SouBean.DataBean> list;
    private OnItemClickLisenter onItemClickLisenter;

    public MySouAdapter(Context context, List<SouBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    public interface OnItemClickLisenter{
        public void onItemClick(SouBean.DataBean dataBean);
    }

    public void setOnItemClickLisenter(OnItemClickLisenter onItemClickLisenter) {
        this.onItemClickLisenter = onItemClickLisenter;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sou_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        final SouBean.DataBean dataBean = list.get(position);
        String images = dataBean.getImages();
        String[] str = images.split("\\|");
        for (int i = 0; i < str.length; i++) {
            Uri uri = Uri.parse(str[i]);
            myViewHolder.sou_img.setImageURI(uri);
        }
        myViewHolder.sou_tv_title.setText(dataBean.getTitle());
        myViewHolder.sou_tv_price.setText("￥"+dataBean.getPrice()+"");
        myViewHolder.sou_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, XiangqingActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name",dataBean.getPid()+"");
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
        private SimpleDraweeView sou_img;
        private TextView sou_tv_title,sou_tv_price;
        private LinearLayout sou_ll;
        public MyViewHolder(View itemView) {
            super(itemView);
            sou_img = (SimpleDraweeView) itemView.findViewById(R.id.sou_img);
            sou_tv_title = (TextView) itemView.findViewById(R.id.sou_tv_title);
            sou_tv_price = (TextView) itemView.findViewById(R.id.sou_tv_price);
            sou_ll = (LinearLayout) itemView.findViewById(R.id.sou_ll);
        }
    }
}
