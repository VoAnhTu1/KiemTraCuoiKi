package com.example.profileth;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:

                return new Profile_fragment();
            case 1:
                return  new LvMonAn_fragment();
            default: return new Profile_fragment();
        }
    };

    @Override
    public int getCount() {
        return 2;
    }
}
