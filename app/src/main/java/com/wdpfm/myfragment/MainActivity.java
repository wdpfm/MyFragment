package com.wdpfm.myfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // 随底部标签切换的Fragment
    private Fragment myFragment1, myFragment2, myFragment3,currentFragment;
    // 底部标签的文本
    private TextView tab_1, tab_2, tab_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initTab();
    }
    /**
     * 初始化UI
     */
    private void initUI() {
        tab_1 = (TextView) findViewById(R.id.tv_tab1);
        tab_2 = (TextView) findViewById(R.id.tv_tab2);
        tab_3 = (TextView) findViewById(R.id.tv_tab3);
        tab_1.setOnClickListener(this);
        tab_2.setOnClickListener(this);
        tab_3.setOnClickListener(this);
    }

    /**
     * 初始化底部标签
     */
    private void initTab() {
        if (myFragment1 == null) {
            myFragment1 = new Fragment_One();
        }
        if (!myFragment1.isAdded()) {
            // 提交事务
            getSupportFragmentManager().beginTransaction().add(R.id.content_layout, myFragment1).commit();
            // 记录当前Fragment
            currentFragment = myFragment1;
            // 设置底部tab变化
            tab_1.setBackgroundColor(Color.RED);
            tab_2.setBackgroundColor(Color.WHITE);
            tab_3.setBackgroundColor(Color.WHITE);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_tab1: // 第一个Page
                showFragment1();
                break;
            case R.id.tv_tab2: // 第二个Page
                showFragment2();
                break;
            case R.id.tv_tab3: // 第三个Page
                showFragment3();
                break;
            default:
                break;
        }
    }

    /**
     * 点击第一个tab
     */
    private void showFragment1() {
        //开启事务，fragment的控制是由事务来实现的
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        //第一种方式（add），初始化fragment并添加到事务中，如果为null就new一个
        if (myFragment1 == null) {
            myFragment1 = new Fragment_One();
            transaction.add(R.id.content_layout,myFragment1);
        }
        //隐藏所有fragment
        hideAllFragment(transaction);
        //显示需要显示的fragment
        transaction.show(myFragment1);
        //提交事务
        transaction.commit();
        // 设置底部tab变化
        tab_1.setBackgroundColor(Color.RED);
        tab_2.setBackgroundColor(Color.WHITE);
        tab_3.setBackgroundColor(Color.WHITE);
    }

    /**
     * 点击第二个tab
     */
    private void showFragment2() {
        //开启事务，fragment的控制是由事务来实现的
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        //第一种方式（add），初始化fragment并添加到事务中，如果为null就new一个
        if (myFragment2 == null) {
            myFragment2 = new Fragment_Two();
            transaction.add(R.id.content_layout,myFragment2);
        }
        //隐藏所有fragment
        hideAllFragment(transaction);
        //显示需要显示的fragment
        transaction.show(myFragment2);
        //提交事务
        transaction.commit();
        // 设置底部tab变化
        tab_1.setBackgroundColor(Color.WHITE);
        tab_2.setBackgroundColor(Color.RED);
        tab_3.setBackgroundColor(Color.WHITE);
    }

    /**
     * 点击第三个tab
     */
    private void showFragment3() {
        //开启事务，fragment的控制是由事务来实现的
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        //第一种方式（add），初始化fragment并添加到事务中，如果为null就new一个
        if (myFragment3 == null) {
            myFragment3 = new Fragment_Three();
            transaction.add(R.id.content_layout,myFragment3);
        }
        //隐藏所有fragment
        hideAllFragment(transaction);
        //显示需要显示的fragment
        transaction.show(myFragment3);
        //提交事务
        transaction.commit();
        // 设置底部tab变化
        tab_1.setBackgroundColor(Color.WHITE);
        tab_2.setBackgroundColor(Color.WHITE);
        tab_3.setBackgroundColor(Color.RED);
    }

    //隐藏所有的fragment
    private void hideAllFragment(FragmentTransaction transaction){
        if(myFragment1 != null){
            transaction.hide(myFragment1);
        }
        if(myFragment2 != null){
            transaction.hide(myFragment2);
        }
        if(myFragment3 != null){
            transaction.hide(myFragment3);
        }
    }

}
