package helloworld.example.com.jingdong.catagory.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import helloworld.example.com.jingdong.R;
import helloworld.example.com.jingdong.catagory.CataGoryBean;

/**
 * Created by 李天祥 on 2017/12/14.
 */

public class Leftadapter extends BaseAdapter{
    private Context context;
    private List<CataGoryBean.DataBean> list;
    private LayoutInflater inflater;

    public Leftadapter(Context context, List<CataGoryBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.left_item,null);
            holder.tv = (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        CataGoryBean.DataBean dataBean = list.get(position);
        holder.tv.setText(dataBean.getName());
        //自己加的属性，用于判断是否选中
        if (dataBean.isChecked()){
            holder.tv.setBackgroundColor(Color.parseColor("#EEEEEE"));
            holder.tv.setTextColor(Color.parseColor("#FF0000"));
        }else{
            holder.tv.setBackgroundColor(Color.parseColor("#ffffff"));
            holder.tv.setTextColor(Color.parseColor("#FF262426"));
        }
        return convertView;
    }

    class ViewHolder{
        TextView tv;
    }

    public void press(int position){
        for (int i = 0; i < list.size(); i++) {
            CataGoryBean.DataBean dataBean = list.get(i);
            dataBean.setChecked(false);
        }
        CataGoryBean.DataBean dataBean = list.get(position);
        dataBean.setChecked(true);
        notifyDataSetChanged();
    }
}
