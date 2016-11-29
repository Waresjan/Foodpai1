package com.lanou3g.foodpie;



import android.os.Bundle;
import android.support.v4.app.FragmentManager;


import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lanou3g.foodpie.eat.EatFragment;
import com.lanou3g.foodpie.library.LibraryFragment;
import com.lanou3g.foodpie.my.MyFragment;



public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.main_rg);
        radioButton = (RadioButton) findViewById(R.id.main_radio_memorize);

        radioButton.setChecked(true);


        // 设置radioGroup的监听时间
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
               RadioButtonIsChecked(checkedId);
            }
        });
    }

    /** 选中不同项, 就将 FrameLayout 位置换成 相应的不同的 Fragment */
    private void RadioButtonIsChecked(int checkedId) {

        FragmentManager manager = getSupportFragmentManager();
       FragmentTransaction transaction = manager.beginTransaction();

        switch (checkedId) {
            case R.id.main_radio_memorize:
                transaction.replace(R.id.fl, new LibraryFragment());

                break;
            case R.id.main_radio_eat:
                transaction.replace(R.id.fl, new EatFragment());

                break;
            case R.id.main_radio_my:
                transaction.replace(R.id.fl, new MyFragment());

                break;
            default:
                Log.d("MainActivity", "出错啦!");
                break;
        }

        transaction.commit();
    }
}
