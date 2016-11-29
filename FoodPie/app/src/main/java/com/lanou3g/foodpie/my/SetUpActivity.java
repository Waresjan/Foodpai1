package com.lanou3g.foodpie.my;


import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;


import com.lanou3g.foodpie.R;
import com.lanou3g.foodpie.base.BaseActivity;

/**
 * Created by dllo on 16/11/28.
 */
public class SetUpActivity extends BaseActivity implements OnClickListener {
   private ImageButton mImageButton;
    @Override
    protected int getLayout() {
        return R.layout.activity_set_up;
    }

    @Override
    protected void initViews() {
     mImageButton =  bindView(R.id.btn_setup_back);
        setClick(this,mImageButton);
    }



    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_setup_back:
                finish();
        }
    }
}
