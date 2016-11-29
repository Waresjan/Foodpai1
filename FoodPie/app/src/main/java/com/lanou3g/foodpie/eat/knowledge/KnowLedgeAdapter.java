package com.lanou3g.foodpie.eat.knowledge;


import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lanou3g.foodpie.R;
import com.lanou3g.foodpie.base.CommonVH;
import com.lanou3g.foodpie.eat.knowledge.KnowledgeBean.FeedsBean;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/25.
 */
public class KnowLedgeAdapter extends BaseAdapter{
    private ArrayList<FeedsBean> mFeedsBeanArrayList;

    public void setFeedsBeanArrayList(ArrayList<FeedsBean> feedsBeanArrayList) {
        mFeedsBeanArrayList = feedsBeanArrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mFeedsBeanArrayList == null ? 0 : mFeedsBeanArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mFeedsBeanArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        //有两种布局

        //type = 1  : 只有一张图的格局
        //type = 2  :有三种图片的格式

        int imgCount = mFeedsBeanArrayList.get(position).getImages().size();

        if (imgCount == 1){
            return 0;
        }
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //获取集合中的数据
        String title = mFeedsBeanArrayList.get(position).getTitle();
        String source = mFeedsBeanArrayList.get(position).getSource();
        String tail = mFeedsBeanArrayList.get(position).getTail();

       ArrayList<String> images = (ArrayList<String>)mFeedsBeanArrayList.get(position).getImages();

        int type = getItemViewType(position);
        Log.d("KnowLedgeAdapter", "type:" + type);
        CommonVH commonVH;

        switch (type){
            case 0:
                commonVH = CommonVH.getViewHolder(convertView, parent, R.layout.item_eat_knowledge1);
                commonVH.setText(R.id.item_knowledge_title, title);
                commonVH.setText(R.id.item_knowledge_source, source);
                commonVH.setText(R.id.item_knowledge_tail, tail);
                commonVH.setImage(R.id.item_knowledge_iv, images.get(0));
                break;

            default:
                commonVH = CommonVH.getViewHolder(convertView, parent, R.layout.item_eat_knowledge2);
                commonVH.setText(R.id.item_knowledge_title, title);
                commonVH.setText(R.id.item_knowledge_source1, source);
                commonVH.setText(R.id.item_knowledge_tail1, tail);
                commonVH.setImage(R.id.item_knowledge_img1, images.get(0));
                commonVH.setImage(R.id.item_knowledge_img2, images.get(1));
                commonVH.setImage(R.id.item_knowledge_img3, images.get(2));
                break;

        }

        return commonVH.getItemView();
        }


}
