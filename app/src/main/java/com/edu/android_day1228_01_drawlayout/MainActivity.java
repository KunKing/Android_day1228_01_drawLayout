package com.edu.android_day1228_01_drawlayout;

import android.content.Intent;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.Toast;

import com.edu.android_day1228_01_drawlayout.activities.SlidingActivity;
import com.edu.android_day1228_01_drawlayout.adapters.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    //private LinearLayout menu;
    private NavigationView menu;
    private ActionBarDrawerToggle toggle;
    private ViewPager viewPager;
    private List<String> stringList;
    private MyAdapter adapter;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer = (DrawerLayout) findViewById(R.id.drawLayout);
        //menu = (LinearLayout) findViewById(R.id.menu);
        menu = (NavigationView) findViewById(R.id.menu);
        // 换 NavigationView 去掉
        // menu.setOnClickListener(this);
        menu.setNavigationItemSelectedListener(this);
        // 显示 home actionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // 参数3 4  是文字说明 显示 actionBar 三条线 menu
        toggle = new ActionBarDrawerToggle(this, drawer, 0, 0);
        toggle.syncState();
        // drawer 拉出 控制 actionBar 的显示
        drawer.setDrawerListener(toggle);
        init();
    }

    private void init() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        stringList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            stringList.add(String.format("第%02d页", i));
        }

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        FragmentManager fm = getSupportFragmentManager();
        adapter = new MyAdapter(fm, stringList);
        viewPager.setAdapter(adapter);
        //  tabLayout 必须放在 adapter 的下面
        tabLayout.setupWithViewPager(viewPager);
    }

    // LinearLayout
    @Override
    public void onClick(View v) {
        // 关闭抽屉
        //drawer.closeDrawer(menu);
        //4.0 以下不能不用 START
        //drawer.closeDrawer(Gravity.START);
        // 上下版本兼容
        drawer.closeDrawer(GravityCompat.START);
        Intent intent = new Intent(this, SlidingActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 对于菜单 actionBar 的点击事件 控制 drawer
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Navigation menu
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_1:
                Toast.makeText(this, "第一项点击", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_2:
                Toast.makeText(this, "第二项点击", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, SlidingActivity.class);
                startActivity(intent);
                break;
            case R.id.item_3:
                Toast.makeText(this, "第三项点击", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_4:
                // 选中之后 关闭 drawer
                // 退出应用  api 16  兼容 找 compat
                //finishAffinity();
                ActivityCompat.finishAffinity(this);
                Toast.makeText(this, "第四项点击 退出应用", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }
}
