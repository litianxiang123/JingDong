package helloworld.example.com.jingdong.catagory.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

import helloworld.example.com.jingdong.R;
import helloworld.example.com.jingdong.acticity.ShopActivity;
import helloworld.example.com.jingdong.catagory.ProductCatagoryBean;

/**
 * Created by 李天祥 on 2017/12/14.
 */

public class RightAdapter extends BaseExpandableListAdapter{
    private Context context;
    private List<String> groupList;
    private List<List<ProductCatagoryBean.DataBean.ListBean>> childList;
    private LayoutInflater inflater;

    public RightAdapter(Context context, List<String> groupList, List<List<ProductCatagoryBean.DataBean.ListBean>> childList) {
        this.context = context;
        this.groupList = groupList;
        this.childList = childList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childList.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupHolder holder;
        if (convertView == null){
            holder = new GroupHolder();
            convertView = inflater.inflate(R.layout.elv_item1,null);
            holder.tv = (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(holder);
        }else {
            holder = (GroupHolder) convertView.getTag();
        }
        String str = groupList.get(groupPosition);
        holder.tv.setText(str);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildHolder holder;
        if (convertView == null){
            holder = new ChildHolder();
            convertView = inflater.inflate(R.layout.elv_item2,null);
            holder.rv = (RecyclerView) convertView.findViewById(R.id.rv);
            convertView.setTag(holder);
        }else {
            holder = (ChildHolder) convertView.getTag();
        }
        List<ProductCatagoryBean.DataBean.ListBean> listBeen = childList.get(groupPosition);
        holder.rv.setLayoutManager(new GridLayoutManager(context,3));
        ElvAdapter adapter = new ElvAdapter(context,listBeen);
        holder.rv.setAdapter(adapter);
        adapter.setOnItemClickListener(new ElvAdapter.OnItemClickListener() {
            @Override
            public void onitemClick(ProductCatagoryBean.DataBean.ListBean listBean) {
                Intent intent = new Intent(context, ShopActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name",listBean.getPscid()+"");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class GroupHolder{
        TextView tv;
    }

    class ChildHolder{
        RecyclerView rv;
    }
}
