package com.example.ageofempires.core;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import com.example.ageofempires.R;
import com.example.ageofempires.interfaces.FragmentCallback;
import com.example.ageofempires.presentation.main.HomeFragment;

public class BaseActivity extends AppCompatActivity implements FragmentCallback {

    private Context context;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        context = this;

        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setMessage(getText(R.string.default_loading_text));
        mProgressDialog.setCancelable(false);

        setFragments();
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
    }

    public void setFragments(){
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        HomeFragment homeFragment = new HomeFragment(this);
        fragmentTransaction.replace(R.id.base_content, homeFragment);
        fragmentTransaction.commit();
    }

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
