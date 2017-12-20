package helloworld.example.com.jingdong.acticity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import helloworld.example.com.jingdong.R;
import helloworld.example.com.jingdong.fragment.Fr_faxian;
import helloworld.example.com.jingdong.fragment.Fr_fenlei;
import helloworld.example.com.jingdong.fragment.Fr_gouwuche;
import helloworld.example.com.jingdong.fragment.Fr_shouye;
import helloworld.example.com.jingdong.fragment.Fr_wode;

public class SecondActivity extends AppCompatActivity {


    private RadioGroup mGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();


    }

    private void initView() {
        mGroup = (RadioGroup) findViewById(R.id.group);
        getFragment(new Fr_shouye());
        mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.btn_shouye:
                        getFragment(new Fr_shouye());
                        break;
                    case R.id.btn_fenlei:
                        getFragment(new Fr_fenlei());
                        break;
                    case R.id.btn_faxian:
                        getFragment(new Fr_faxian());
                        break;
                    case R.id.btn_gouwuche:
                        getFragment(new Fr_gouwuche());
                        break;
                    case R.id.btn_wode:
                        getFragment(new Fr_wode());
                        break;
                }
            }
        });
    }

    private void getFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
    }
}
