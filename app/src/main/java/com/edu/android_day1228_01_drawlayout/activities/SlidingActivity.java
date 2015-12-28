package com.edu.android_day1228_01_drawlayout.activities;

import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.edu.android_day1228_01_drawlayout.R;

public class SlidingActivity extends AppCompatActivity implements SlidingPaneLayout.PanelSlideListener {

    private static final String TAG = "SlidingActivity";
    private SlidingPaneLayout sliding;
    private View view;
    private View menuSliding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_activty);
        sliding = (SlidingPaneLayout) findViewById(R.id.slidingLayout);
        view = findViewById(R.id.content_sliding);
        menuSliding = findViewById(R.id.menu_sliding);
        //滑动的监听
        sliding.setPanelSlideListener(this);
        // 打开关闭
        /*sliding.closePane();
        sliding.openPane();*/
    }

    /**
     * 滑动中
     *
     * @param panel
     * @param slideOffset [0-1] 全部打开是1 完全关闭是0
     */
    @Override
    public void onPanelSlide(View panel, float slideOffset) {
        // 设置锚点坐标 默认是在中心点上  setPivotY 必须是 11 以上的版本  可以使用兼容包
/*        view.setPivotX(0);
        view.setScaleX(1 - slideOffset * 0.5f);
        view.setScaleY(1 - slideOffset * 0.5f);*/
        Log.d(TAG, "onPanelSlide() returned: " + slideOffset);
        // 兼容低版本
        ViewCompat.setPivotX(view, 0);
        ViewCompat.setPivotY(view, view.getHeight() / 2);
        ViewCompat.setScaleX(view, 1 - slideOffset * 0.5f);
        ViewCompat.setScaleY(view, 1 - slideOffset * 0.5f);
        ViewCompat.setTranslationX(menuSliding, -menuSliding.getWidth() / 2 * (1 - slideOffset));
    }

    @Override
    public void onPanelOpened(View panel) {
    }

    @Override
    public void onPanelClosed(View panel) {

    }
}
