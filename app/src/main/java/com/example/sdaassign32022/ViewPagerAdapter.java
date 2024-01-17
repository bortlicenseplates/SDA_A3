package com.example.sdaassign32022;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.lang.reflect.Array;

/*
 * viewPager adapter.
 * @author Chris Coughlan 2019
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private Tab[] fragments;

    ViewPagerAdapter(@NonNull FragmentManager fm, int behavior, Context nContext) {
        super(fm, behavior);
        context = nContext;
        fragments = new Tab[]{new Welcome(), new ProductList(), new OrderTshirt()};
    }

    @NonNull
    @Override
    public Fragment getItem(int position) { return (Fragment) fragments[position]; }

    @Override
    public int getCount() { return fragments.length; }

    @Override
    public CharSequence getPageTitle(int position) { return fragments[position].getTitle(); }
}
