package com.lanou3g.foodpie.eat;


import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.ImageButton;
import android.support.v4.app.Fragment;
import com.lanou3g.foodpie.R;
import com.lanou3g.foodpie.base.BaseFragment;
import com.lanou3g.foodpie.eat.evaluate.EvaluateFragment;
import com.lanou3g.foodpie.eat.food.FoodFragment;
import com.lanou3g.foodpie.eat.homepage.HomePageFragment;
import com.lanou3g.foodpie.eat.knowledge.KnowledgeFragment;

import java.util.ArrayList;



/**
 * Created by dllo on 16/11/24.
 */
public class EatFragment extends BaseFragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ArrayList<Fragment>mFragmentArrayList;
    private ImageButton camera;
    @Override
    protected int getLayout() {
        return R.layout.fragmnet_eat;
    }

    @Override
    protected void initViews() {
        mTabLayout = bindView(R.id.eat_tab_layout);
        mViewPager = bindView(R.id.ear_view_pager);

        camera = bindView(R.id.eat_label_camera);


        mFragmentArrayList = new ArrayList<>();
        mFragmentArrayList.add(new HomePageFragment());
        mFragmentArrayList.add(new EvaluateFragment());
        mFragmentArrayList.add(new KnowledgeFragment());
        mFragmentArrayList.add(new FoodFragment());

        MyEatAdapter adapter = new MyEatAdapter(getFragmentManager());
        adapter.setFragmentArrayList(mFragmentArrayList);
        mViewPager.setAdapter(adapter);

        //设置tablayout文字颜色
        mTabLayout.setTabTextColors(Color.BLACK,Color.RED);

        //设置指示颜色
        mTabLayout.setSelectedTabIndicatorColor(Color.RED);
//
//        //设置圆形指示器
//        mTabLayout.setScrollIndicators();

       mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    protected void initData() {

    }
}
