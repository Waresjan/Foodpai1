package com.lanou3g.foodpie;


import android.content.Intent;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;


import com.lanou3g.foodpie.base.BaseActivity;

public class StartActivity extends BaseActivity implements View.OnClickListener{
    private CountDownTimer timer;
    private ImageView imageView;

    @Override
    protected int getLayout() {
        return R.layout.acticity_start;
    }

    @Override
    protected void initViews() {
        imageView = bindView(R.id.start_iv);
        setClick(this, imageView);

    }

    @Override
    protected void initData() {
        timer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        };
        timer.start();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_iv:
                // 点击图片 实现提前跳转
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                timer.cancel();

                break;
            default:
                Log.d("StartActivity", "出错啦!");
                break;
        }
    }
}
