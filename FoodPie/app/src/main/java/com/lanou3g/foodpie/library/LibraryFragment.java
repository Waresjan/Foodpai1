package com.lanou3g.foodpie.library;


import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.lanou3g.foodpie.R;
import com.lanou3g.foodpie.UrlValues;
import com.lanou3g.foodpie.base.BaseFragment;
import com.lanou3g.foodpie.library.LibraryBean.GroupBean;
import com.lanou3g.foodpie.volley.GsonRequest;
import com.lanou3g.foodpie.volley.VolleySingleton;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.os.Build.VERSION_CODES.M;

public class LibraryFragment extends BaseFragment {
    private Button btnSearch;
    private Button btnAnalysis;
    private Button btnCompare;
    private Button btnScanCompare;
    private GridView gridViewSort;
    private GridView gridViewBrand;
    private GridView gridViewDrink;
    @Override
    protected int getLayout() {
        return R.layout.fragment_librry;
    }

    @Override
    protected void initViews() {
        btnSearch = bindView(R.id.library_btn_search);
        btnAnalysis = bindView(R.id.library_btn_analysis);
        btnCompare = bindView(R.id.library_btn_compare);
        btnScanCompare = bindView(R.id.library_btn_scancompare);

        gridViewSort = bindView(R.id.library_grid1_sort);
        gridViewBrand = bindView(R.id.library_grid2_brand);
        gridViewDrink = bindView(R.id.library_grid3_drink);
    }

    @Override
    protected void initData() {
      //  setClick(this, btnAnalysis, btnScanCompare, btnCompare,btnSearch);

        gsonMethod();

    }

    private void gsonMethod() {
        GsonRequest<LibraryBean>gsonRequest = new GsonRequest<LibraryBean>(
                LibraryBean.class, UrlValues.LIBRARY_URL,
                new Listener<LibraryBean>() {
                    @Override
                    public void onResponse(LibraryBean response) {
                        getSort(response);
                        getBeand(response);
                        getDrink(response);
                    }




                }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //访问失败
                Log.d("LibraryFragment", "访问失败");

            }
        }
        );
        VolleySingleton.getInstance().addRequest(gsonRequest);
    }

    private void getDrink(final LibraryBean response) {
        ArrayList<LibraryBean.GroupBean.CategoriesBean>beanArrayListDrink
                =(ArrayList<LibraryBean.GroupBean.CategoriesBean>)response.getGroup().get(2).getCategories();

        LibraryAdapter adapter = new LibraryAdapter();
        adapter.setBeanArrayList(beanArrayListDrink);
        gridViewDrink.setAdapter(adapter);
//
//        gridViewDrink.setOnClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//               LibraryBean.GroupBean groupBean = response.getGroup().get(2);
//
//                Intent intent = new Intent(getActivity(),LibraryMoreActivity.class);
//                putDataInIntent(intent,groupBean,position);
//                startActivity(intent);
//            }
//
//
//        });
//
//
    }



    private void getBeand(LibraryBean response) {
ArrayList<LibraryBean.GroupBean.CategoriesBean>beanArrayListBeand =
        (ArrayList<LibraryBean.GroupBean.CategoriesBean>)response.getGroup().get(1).getCategories();
        LibraryAdapter adapter = new LibraryAdapter();
        adapter.setBeanArrayList(beanArrayListBeand);
        gridViewBrand.setAdapter(adapter);
    }

    private void getSort(LibraryBean response) {
ArrayList<LibraryBean.GroupBean.CategoriesBean>beanArrayListSort =
        (ArrayList<LibraryBean.GroupBean.CategoriesBean>)response.getGroup().get(0).getCategories();
        LibraryAdapter adapter = new LibraryAdapter();
        adapter.setBeanArrayList(beanArrayListSort);
        gridViewSort.setAdapter(adapter);
    }


}
