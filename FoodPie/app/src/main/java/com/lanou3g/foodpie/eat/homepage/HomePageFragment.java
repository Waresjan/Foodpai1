package com.lanou3g.foodpie.eat.homepage;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.LinearLayout;

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
public class HomePageFragment extends BaseFragment {
   private RecyclerView mRecyclerView;
    @Override
    protected int getLayout() {
        return R.layout.fragment_home_page;
    }

    @Override
    protected void initViews() {
    mRecyclerView = bindView(R.id.eat_homepage_rv);

    }

    @Override
    protected void initData() {
        gsonMethod();

    }

    private void gsonMethod() {
        GsonRequest<HomePageBean> gsonRequest = new GsonRequest<HomePageBean>(
                HomePageBean.class, UrlValues.HOMEPAGE_URL,
                new Listener<HomePageBean>() {
                    @Override
                    public void onResponse(HomePageBean response) {
                        //网络请求成功
                        Log.d("HomePageFragment", "response:" + response);
                        ArrayList<HomePageBean.FeedsBean> feedsBeanArrayList =
                                (ArrayList<HomePageBean.FeedsBean>) response.getFeeds();

                        HomePageAdapter adapter = new HomePageAdapter();
                        adapter.setFeedsBeanArrayList(feedsBeanArrayList);
                        mRecyclerView.setAdapter(adapter);


                        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(
                                2, LinearLayout.VERTICAL
                        );

                        mRecyclerView.setLayoutManager(manager);


                    }
                }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //请求失败
            }
        }
        );
        VolleySingleton.getInstance().addRequest(gsonRequest);
    }
}
