package com.lanou3g.foodpie.eat.homepage;


import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;

import com.lanou3g.foodpie.R;
import com.lanou3g.foodpie.base.CommonVH;
import com.lanou3g.foodpie.eat.homepage.HomePageBean.FeedsBean;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/25.
 */


public class HomePageAdapter extends RecyclerView.Adapter {
    private ArrayList<FeedsBean> mFeedsBeanArrayList;

    public void setFeedsBeanArrayList(ArrayList<FeedsBean> feedsBeanArrayList) {
        mFeedsBeanArrayList = feedsBeanArrayList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CommonVH commonVH;
        switch (viewType){
            case 1:
                commonVH = CommonVH.getViewHolder(parent, R.layout.item_eat_homepage1);
                break;
            default:
                commonVH = CommonVH.getViewHolder(parent,R.layout.item_eat_homepage2);
        }
        return commonVH;
    }

    @Override
    public int getItemViewType(int position) {
        String title = mFeedsBeanArrayList.get(position).getTitle();
        if (title == null){
            //type为1 :表示第一张他图片
            //tye 为2 :表示正常的图片和文字结合
            return 1;
        }

        return 2;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
     int type = getItemViewType(position);
        CommonVH commonVH = (CommonVH)holder;
        Bitmap bitmap = null ;

        // 获取 图片, 标题, 头像, 发布者

        String imgUrl = mFeedsBeanArrayList.get(position).getCard_image();
        String title = mFeedsBeanArrayList.get(position).getTitle();
        String description = mFeedsBeanArrayList.get(position).getDescription();

        String iconUrl = mFeedsBeanArrayList.get(position).getPublisher_avatar();
        String publisher = mFeedsBeanArrayList.get(position).getPublisher();


        switch (type){
            case 1:
                commonVH.setImage(R.id.homepage_item_card_image1,imgUrl);
                break;

            default:
                commonVH.setImage(R.id.homepage_item_card_image, imgUrl);
                commonVH.setText(R.id.homepage_item_title, title);
                commonVH.setText(R.id.homepage_item_description, description);

                commonVH.setText(R.id.homepage_item_publisher, publisher);

                commonVH.setCircleImage(R.id.homepage_item_publisher_image, iconUrl);



                break;
        }

    }

    @Override
    public int getItemCount() {
        return mFeedsBeanArrayList == null ? null : mFeedsBeanArrayList.size();
    }
}
