package com.lanou3g.foodpie.library;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lanou3g.foodpie.R;
import com.lanou3g.foodpie.base.CommonVH;
import com.lanou3g.foodpie.library.LibraryBean.GroupBean.CategoriesBean;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/26.
 */
public class LibraryAdapter extends BaseAdapter {
    private ArrayList<CategoriesBean> mBeanArrayList;

    public void setBeanArrayList(ArrayList<CategoriesBean> beanArrayList) {
        mBeanArrayList = beanArrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mBeanArrayList == null ? 0 : mBeanArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mBeanArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CommonVH commonVH = CommonVH.getViewHolder
                (convertView,parent, R.layout.item_library);


        String imgUrl = mBeanArrayList.get(position).getImage_url();
        String name = mBeanArrayList.get(position).getName();

        commonVH.setImage(R.id.item_library_iv,imgUrl);
       commonVH.setText(R.id.item_library_tv,name);
        return commonVH.getItemView();
    }
}
