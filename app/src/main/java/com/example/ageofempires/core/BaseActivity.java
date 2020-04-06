package com.example.ageofempires.core;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import com.example.ageofempires.R;
import com.example.ageofempires.adapter.TabPagerAdapter;
import com.example.ageofempires.data.models.MemoryCache;
import com.example.ageofempires.interfaces.FragmentCallback;
import com.example.ageofempires.presentation.civilization.CivilizationFragment;
import com.google.android.material.tabs.TabLayout;

public class BaseActivity extends AppCompatActivity implements FragmentCallback {

    private Context context;
    private ProgressDialog mProgressDialog;
    private MemoryCache memoryCache;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        context = this;

        memoryCache = new MemoryCache();

        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setMessage(getText(R.string.default_loading_text));
        mProgressDialog.setCancelable(false);

        //setFragments();
        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), this, memoryCache);
        mViewPager = findViewById(R.id.viewPagerMenu);
        mViewPager.setAdapter(tabPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mTabLayout = findViewById(R.id.tabMainDishes);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
    }

    /*public void setFragments(){
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        CivilizationFragment civilizationFragment = new CivilizationFragment(this);
        fragmentTransaction.replace(R.id.base_content, civilizationFragment);
        fragmentTransaction.commit();
    }*/

    @Override
    public void showLoadingDialog() {
        if (mProgressDialog != null)
            mProgressDialog.show();
    }

    @Override
    public void hideLoadingDialog() {
        if (mProgressDialog != null)
            mProgressDialog.dismiss();
    }


}
