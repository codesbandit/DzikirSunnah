package net.dlingogroups.dzikirsunnah;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar mToolbar;
    private ImageView header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TabLayout tabLayout = (TabLayout) findViewById(R.id.htab_tabs);
//        final ViewPager viewPager = (ViewPager)findViewById(R.id.htab_viewpager);
//        tabLayout.setupWithViewPager(viewPager);
//
//
//        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//
//                viewPager.setCurrentItem(tab.getPosition());
//
//                switch (tab.getPosition()) {
//                    case 0:
//                        showToast("One");
//                        break;
//                    case 1:
//                        showToast("Two");
//                        break;
//                }
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//
//            private void setupViewPager(ViewPager viewPager) {
//                ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
//                adapter.AddFragment(new dzikir1(getResources().getColor(R.color.accent_material_light)), "Pagi");
//                adapter.AddFragment(new dzikir2(getResources().getColor(R.color.ripple_material_light)), "Petang");
////                adapter.AddFragment(new DummyFragment(getResources().getColor(R.color.button_material_dark)), "MOUSE");
//                viewPager.setAdapter(adapter);
//            }
//    });
//}

        tabLayout = (TabLayout)findViewById(R.id.tabLayoutId);
        viewPager = (ViewPager)findViewById(R.id.viewPagerId);
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        header = (ImageView)findViewById(R.id.headerImg);

        //Toolbar support back action
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Dzikir Pagi & Petang");

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()){
                    case 0:
                        header.setImageResource(R.drawable.sunriseheader);
                        break;
                    case 1:
                        header.setImageResource(R.drawable.header);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new dzikir1(),"Dzikir Pagi");
        adapter.AddFragment(new dzikir2(),"Dzikir Petang");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
