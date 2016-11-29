package com.lanou3g.foodpie.eat.food;


import android.util.Log;
import android.widget.ListView;

import com.android.volley.Response;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.lanou3g.foodpie.R;
import com.lanou3g.foodpie.UrlValues;
import com.lanou3g.foodpie.base.BaseFragment;

import com.lanou3g.foodpie.volley.GsonRequest;
import com.lanou3g.foodpie.volley.VolleySingleton;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/24.
 */
public class FoodFragment extends BaseFragment {
  private ListView mListView;
    @Override
    protected int getLayout() {
        return R.layout.fragment_knowledge;
    }

    @Override
    protected void initViews() {
mListView = bindView(R.id.eat_knowledge_list_view);
    }

    @Override
    protected void initData() {
GsonRequest<FoodBean>gsonRequest = new GsonRequest<FoodBean>(
        FoodBean.class, UrlValues.FOOD_URL,
        new Listener<FoodBean>() {
            @Override
            public void onResponse(FoodBean response) {
                ArrayList<FoodBean.FeedsBean> feedsBeanArrayList =
                        (ArrayList<FoodBean.FeedsBean>) response.getFeeds();
                FoodAdapter adapter = new FoodAdapter();
                adapter.setFeedsBeanArrayList(feedsBeanArrayList);
                mListView.setAdapter(adapter);
            }
        }, new ErrorListener() {
    @Override
    public void onErrorResponse(VolleyError error) {
        Log.d("FoodFragment", "出错了");
    }
}
);
        VolleySingleton.getInstance().addRequest(gsonRequest);

    }

}
