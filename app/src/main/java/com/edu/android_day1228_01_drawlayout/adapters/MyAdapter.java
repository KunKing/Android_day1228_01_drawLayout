package com.edu.android_day1228_01_drawlayout.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.edu.android_day1228_01_drawlayout.fragments.BlackFragment;

import java.util.List;

/**
 * Created by Ming on 2015/12/28.
 */
public class MyAdapter extends FragmentPagerAdapter {

    private List<String> stringList;

    public MyAdapter(FragmentManager fm,List<String> stringList) {
        super(fm);
        this.stringList = stringList;
    }

    @Override
    public Fragment getItem(int position) {
        return BlackFragment.newInstance(stringList.get(position));
    }

    @Override
    public int getCount() {
        return stringList.size();
    }


    /**
     * 获取页的标题
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return stringList.get(position);
    }
}
