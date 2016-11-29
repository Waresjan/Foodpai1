package com.lanou3g.foodpie.volley;/*
*      
*          ┌─┐       ┌─┐
*       ┌──┘ ┴───────┘ ┴──┐                     
*       │                 │
*       │       ───       │
*       │  ─┬┘       └┬─  │
*       │                 │
*       │       ─┴─       │
*       │                 │
*       └───┐         ┌───┘
*           │         │
*           │         │
*           │         │
*           │         └──────────────┐
*           │                        │
*           │                        ├─┐
*           │                        ┌─┘    
*           │                        │
*           └─┐  ┐  ┌───────┬──┐  ┌──┘         
*             │ ─┤ ─┤       │ ─┤ ─┤         
*             └──┴──┘       └──┴──┘ 
*                 神兽保佑 
*                 代码无BUG! 
*/

import android.app.Application;
import android.content.Context;

/**
 * Created by dllo on 16/11/24.
 */
public class MyApp extends Application{


    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;  //因为本类对象的application就是context的子类
    }

    public static Context getContext() {
        return context;
    }
}
