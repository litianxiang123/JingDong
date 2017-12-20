package helloworld.example.com.jingdong.catagory.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import helloworld.example.com.jingdong.R;
import helloworld.example.com.jingdong.catagory.ProductCatagoryBean;

/**
 * Created by 李天祥 on 2017/12/14.
 */

public class ElvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<ProductCatagoryBean.DataBean.ListBean> listBeen;
    private  OnItemClickListener onItemClickListener;

    public ElvAdapter(Context context, List<ProductCatagoryBean.DataBean.ListBean> listBeen) {
        this.context = context;
        this.listBeen = listBeen;
    }
    //1、接口回调第一步，先定义一个接口
    public interface OnItemClickListener{
        public void onitemClick(ProductCatagoryBean.DataBean.ListBean listBean);
    }

    //3.定义一个方法
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.elv_rv_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ProductCatagoryBean.DataBean.ListBean listBean = listBeen.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.iv.setImageURI(listBean.getIcon());
        myViewHolder.tv.setText(listBean.getName());
        myViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onitemClick(listBean);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listBeen.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private SimpleDraweeView iv;
        private TextView tv;
        private LinearLayout ll;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv = (SimpleDraweeView) itemView.findViewById(R.id.iv);
            tv = (TextView) itemView.findViewById(R.id.tv);
            ll = (LinearLayout) itemView.findViewById(R.id.ll);
        }
    }
}
