package com.lanou3g.foodpie.my;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


import com.lanou3g.foodpie.R;

import com.lanou3g.foodpie.base.BaseFragment;

/**
 * Created by dllo on 16/11/24.
 */
public class MyFragment extends BaseFragment implements OnClickListener {
private ImageButton SetUp;
    private Button loginBtn;
    private ImageView iconIv;
    @Override
    protected int getLayout() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initViews() {
    SetUp = bindView(R.id.my_setting);
    loginBtn = bindView(R.id.my_login);
        iconIv = bindView(R.id.my_icon);

       // SetUp.setOnClickListener(this);
    setClick(this,SetUp,loginBtn);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.my_setting:
                Intent intent = new Intent(getActivity(),SetUpActivity.class);
                startActivity(intent);
                break;

            case R.id.my_login:
                Intent intent1 = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent1);
        break;
        }


    }
}
