package helloworld.example.com.jingdong.faxian;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import helloworld.example.com.jingdong.R;

/**
 * Created by 李天祥 on 2017/12/16.
 */

public class MyAdapyet extends BaseAdapter{
    private Context context;
    private List<String> list;
    private LayoutInflater inflater;

    public MyAdapyet(Context context, List<String> list) {
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
            convertView = inflater.inflate(R.layout.faxian_item,null);
            holder.fx_jc = (JCVideoPlayer) convertView.findViewById(R.id.fx_jc);
            holder.fx_tv1 = (TextView) convertView.findViewById(R.id.fx_tv1);
            holder.fx_tv2 = (TextView) convertView.findViewById(R.id.fx_tv2);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.fx_jc.setUp("http://www.jmzsjy.com/UploadFile/微课/地方风味小吃——宫廷香酥牛肉饼.mp4", "视频播放");
        holder.fx_tv1.setText("123");
        holder.fx_tv2.setText("已播放3万次");
        return convertView;
    }

    class ViewHolder{
        private JCVideoPlayer fx_jc;
        private TextView fx_tv1,fx_tv2;
    }
}
