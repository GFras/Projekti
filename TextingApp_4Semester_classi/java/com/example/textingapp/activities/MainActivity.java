package com.example.textingapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import com.example.textingapp.R;
import com.example.textingapp.fragments.FragmentMain;
import com.example.textingapp.fragments.FragmentProfile;
import com.example.textingapp.fragments.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializacija TabLayout in ViewPager
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        // Poveži TabLayout z ViewPager
        tabLayout.setupWithViewPager(viewPager);

        // Ustvari ViewPagerAdapter za upravljanje fragmentov
        ViewPagerAdapter VPAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        // Dodaj fragmente v ViewPagerAdapter
        VPAdapter.addFragment(new FragmentProfile(),"PROFILE");
        VPAdapter.addFragment(new FragmentMain(),"MAIN");
        //VPAdapter.addFragment(new FragmentSettings(),"SETTINGS"); // Ta fragment je morda zakomentiran za zdaj

        // Nastavi ViewPagerAdapter v ViewPager
        viewPager.setAdapter(VPAdapter);
    }
}
