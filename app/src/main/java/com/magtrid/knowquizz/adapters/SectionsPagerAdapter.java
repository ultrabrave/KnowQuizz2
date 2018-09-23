package com.magtrid.knowquizz.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.magtrid.knowquizz.views.tabs.LuckyFragment;
import com.magtrid.knowquizz.views.tabs.MatchFragment;
import com.magtrid.knowquizz.views.tabs.PartyFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return PartyFragment.newInstance();
            case 1:
                return LuckyFragment.newIntance();
            case 2:
                return MatchFragment.newInstance();
            default:
                return PartyFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }
}
