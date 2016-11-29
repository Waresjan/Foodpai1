package com.lanou3g.foodpie.eat;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;




import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/24.
 */
public class MyEatAdapter extends FragmentPagerAdapter {
    private String[]titles = new String[]{"首页","测评","知识","美食"};

    public MyEatAdapter(FragmentManager fm, ArrayList<Fragment> fragmentArrayList) {
        super(fm);
        mFragmentArrayList = fragmentArrayList;
    }

    private ArrayList<Fragment>mFragmentArrayList;


    public MyEatAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return mFragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentArrayList == null ? 0 : mFragmentArrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    public void setFragmentArrayList(ArrayList<Fragment> fragmentArrayList) {
        mFragmentArrayList = fragmentArrayList;
    }
}
