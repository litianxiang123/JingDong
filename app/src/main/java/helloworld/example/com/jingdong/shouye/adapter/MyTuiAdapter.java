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

public class MyTuiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<ShouYeBean.TuijianBean.ListBean> list;
    private OnItemClickListener onItemClickListener;

    public MyTuiAdapter(Context context, List<ShouYeBean.TuijianBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    public interface OnItemClickListener{
        public void onItemClick(ShouYeBean.TuijianBean.ListBean listBean);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sy_tui_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ShouYeBean.TuijianBean.ListBean listBean = list.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        String images = listBean.getImages();
        String[] str = images.split("\\|");
        for (int i = 0; i < str.length; i++) {
            Uri uri = Uri.parse(str[i]);
            myViewHolder.tui_img.setImageURI(uri);
        }
        myViewHolder.tui_title.setText(listBean.getTitle());
        myViewHolder.tui_subhead.setText(listBean.getSubhead());
        myViewHolder.tui_price.setText("￥"+listBean.getPrice()+"");
        myViewHolder.tui_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, XiangqingActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name",listBean.getPid()+"");
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
        private SimpleDraweeView tui_img;
        private TextView tui_title,tui_subhead,tui_price;
        private LinearLayout tui_ll;
        public MyViewHolder(View itemView) {
            super(itemView);
            tui_img = (SimpleDraweeView) itemView.findViewById(R.id.tui_img);
            tui_title = (TextView) itemView.findViewById(R.id.tui_title);
            tui_subhead = (TextView) itemView.findViewById(R.id.tui_subhead);
            tui_price = (TextView) itemView.findViewById(R.id.tui_price);
            tui_ll = (LinearLayout) itemView.findViewById(R.id.tui_ll);
        }
    }
}
