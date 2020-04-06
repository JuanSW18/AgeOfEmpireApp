package com.example.ageofempires.adapter;

import com.example.ageofempires.interfaces.FragmentCallback;
import com.example.ageofempires.presentation.civilization.CivilizationFragment;
import com.example.ageofempires.presentation.unit.UnitFragment;
import com.example.ageofempires.utils.Constants;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabPagerAdapter extends FragmentPagerAdapter {

    private static int NUMBER_OF_TABS = 2;
    private FragmentCallback fragmentCallback;

    public TabPagerAdapter(@NonNull FragmentManager fm,FragmentCallback fragmentCallback) {
        super(fm);
        this.fragmentCallback = fragmentCallback;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch ( position ){
            case 0:
                return new CivilizationFragment(fragmentCallback);
            case 1:
                return new UnitFragment(fragmentCallback);
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch ( position ){
            case 0:
                return Constants.CIVILIZATIONS;
            case 1:
                return Constants.UNITS;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUMBER_OF_TABS;
    }
}
