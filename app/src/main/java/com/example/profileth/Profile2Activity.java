package com.example.profileth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile2Activity extends AppCompatActivity {
    BottomNavigationView bv;
    ViewPager mViewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment);

        mViewPager = findViewById(R.id.view_pg);
        setUpViewPager();

        //tạo sựu kiện bottom menu
        bv = findViewById(R.id.bottom_nv);
        bv.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_home:
                    mViewPager.setCurrentItem(0);
                    break;
                case R.id.action_profile:
                    mViewPager.setCurrentItem(1);
                    break;
            }
            return true;
        });



    }
    private void setUpViewPager() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(viewPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bv.getMenu().findItem(R.id.action_home).setChecked(true);
                        break;
                    case 1:
                        bv.getMenu().findItem(R.id.action_profile).setChecked(true);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}


