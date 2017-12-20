package helloworld.example.com.jingdong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import helloworld.example.com.jingdong.R;
import helloworld.example.com.jingdong.faxian.MyAdapyet;

/**
 * Created by 李天祥 on 2017/12/13.
 */

public class Fr_faxian extends Fragment {
   private View view;
    private ListView mFaxianLv;
    private List<String> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fr_faxian, null);
        initView(view);
        for (int i = 0; i < 10; i++) {
            list.add("a");
        }
        return view;
    }

    private void initView(View view) {
        mFaxianLv = (ListView) view.findViewById(R.id.faxian_lv);
        MyAdapyet adapyet = new MyAdapyet(getContext(),list);
        mFaxianLv.setAdapter(adapyet);
    }
}
