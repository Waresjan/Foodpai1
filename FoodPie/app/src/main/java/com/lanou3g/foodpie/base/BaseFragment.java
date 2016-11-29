package com.lanou3g.foodpie.base;



import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lanou3g.foodpie.R;

/**
 * Created by dllo on 16/11/22.
 */

public abstract class BaseFragment extends Fragment {
    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getLayout() == 0){
            //如果是没布局  会出现程序崩溃  所以给一个空布局
            return inflater.inflate(R.layout.null_layout,container,false);
        }
        return inflater.inflate(getLayout(),container,false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract int getLayout();
    protected abstract void initViews();
    protected abstract void initData();

    // 简化 findViewById 省去强转的过程
    protected <T extends View> T bindView(int id) {
        return (T)getView().findViewById(id);
    }

    // 方法重载, 指定在哪个 View 里 findViewById
    protected <T extends View> T bindView(View view, int id) {
        return (T)view.findViewById(id);
    }

    // 设置各种点击事件
    protected void setClick(View.OnClickListener onClickListener, View ... views){
        for (View view : views) {
            view.setOnClickListener(onClickListener);
        }
    }
}