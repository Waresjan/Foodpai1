package com.lanou3g.foodpie.eat.knowledge;

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

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by dllo on 16/11/24.
 */
public class KnowledgeFragment extends BaseFragment {
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
        GsonRequest<KnowledgeBean>gsonRequest = new GsonRequest<KnowledgeBean>(
                KnowledgeBean.class, UrlValues.KNOWLEDGE_URL,
                new Listener<KnowledgeBean>() {
                    @Override
                    public void onResponse(KnowledgeBean response) {
                        Log.d("KnowledgeFragment", "response:" + response);
                        ArrayList<KnowledgeBean.FeedsBean> feedsBeanArrayList =
                                (ArrayList<KnowledgeBean.FeedsBean>) response.getFeeds();

                        KnowLedgeAdapter adapter = new KnowLedgeAdapter();
                        adapter.setFeedsBeanArrayList(feedsBeanArrayList);
                        mListView.setAdapter(adapter);
                    }
                }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("KnowledgeFragment", "数据请求失败");
            }
        }
        );
        VolleySingleton.getInstance().addRequest(gsonRequest);

    }
}
