package helloworld.example.com.jingdong.syhua.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import helloworld.example.com.jingdong.R;
import helloworld.example.com.jingdong.syhua.HuaBean;

/**
 * Created by 李天祥 on 2017/12/15.
 */

public class MyHuaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<HuaBean.DataBean> list;

    public MyHuaAdapter(Context context, List<HuaBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hua_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        HuaBean.DataBean dataBean = list.get(position);
        Uri uri = Uri.parse(dataBean.getIcon());
        myViewHolder.hua_img.setImageURI(uri);
        myViewHolder.hua_tv.setText(dataBean.getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private SimpleDraweeView hua_img;
        private TextView hua_tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            hua_img = (SimpleDraweeView) itemView.findViewById(R.id.hua_img);
            hua_tv = (TextView) itemView.findViewById(R.id.hua_name);
        }
    }
}
