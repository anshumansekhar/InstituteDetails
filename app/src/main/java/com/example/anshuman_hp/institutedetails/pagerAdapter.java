package com.example.anshuman_hp.institutedetails;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Anshuman-HP on 31-03-2017.
 */

public class pagerAdapter extends FragmentStatePagerAdapter {
    public pagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:return new TimelineFragment();
            case 1:return new AboutInstituteFragment();
            default:return null;
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:return "Timeline";
            case 1:return "About";
            default:return "Hello";
        }

    }
}
