package com.lanou3g.foodpie.eat.evaluate;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lanou3g.foodpie.R;
import com.lanou3g.foodpie.base.CommonVH;
import com.lanou3g.foodpie.eat.evaluate.EvaluateBean.FeedsBean;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/24.
 */
public class EvaluateAdapter extends BaseAdapter {
    private ArrayList<FeedsBean> mFragmentArrayList;

    public void setFragmentArrayList(ArrayList<FeedsBean> fragmentArrayList) {
        mFragmentArrayList = fragmentArrayList;
        //notifyDataSetChanged方法通过一个外部的方法控制如果适配器的内容
        // 改变时需要强制调用getView来刷新每个Item的内容,可以实现动态的刷新列表的功能
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return mFragmentArrayList == null ? 0 : mFragmentArrayList.size() ;
    }

    @Override
    public Object getItem(int position) {
        return mFragmentArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CommonVH commonVH = CommonVH.getViewHolder(
                convertView,parent,R.layout.item_eat_evaluate
        );
        String img = mFragmentArrayList.get(position).getBackground();
        String source = mFragmentArrayList.get(position).getSource();
        String title = mFragmentArrayList.get(position).getTitle();
        String tail = mFragmentArrayList.get(position).getTail();

        commonVH.setImage(R.id.item_evaluate_img, img);
        commonVH.setText(R.id.item_evaluate_source, source);
        commonVH.setText(R.id.item_evaluate_title, title);
        commonVH.setText(R.id.item_evaluate_tail, tail);

        return commonVH.getItemView();
    }

}
