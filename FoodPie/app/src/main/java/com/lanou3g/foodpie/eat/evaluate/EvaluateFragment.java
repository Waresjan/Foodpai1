package com.lanou3g.foodpie.eat.evaluate;


import android.util.Log;
import android.widget.ListView;

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
public class EvaluateFragment extends BaseFragment {

    private ListView mListView;
    @Override
    protected int getLayout() {
        return R.layout.fragment_evaluate;
    }

    @Override
    protected void initViews() {
    mListView = bindView(R.id.list_view_evaluate);
    }

    @Override
    protected void initData() {
        GsonRequest<EvaluateBean>gsonRequest = new
                GsonRequest<EvaluateBean>(
                EvaluateBean.class, UrlValues.EVALUATE_URL,
                new Listener<EvaluateBean>() {
                    @Override
                    public void onResponse(EvaluateBean response) {
                        ArrayList<EvaluateBean.FeedsBean> feedsBeenArrayList =
                                (ArrayList<EvaluateBean.FeedsBean>) response.getFeeds();
                        EvaluateAdapter adapter = new EvaluateAdapter();
                        adapter.setFragmentArrayList(feedsBeenArrayList);
                        mListView.setAdapter(adapter);
                    }
                }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //网络请求失败
                Log.d("EvaluateFragment", "请求失败");
            }
        }
        );
        VolleySingleton.getInstance().addRequest(gsonRequest);
    }
}
