package mx.iteso.jaimeapp.pideseloajaime.Gui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.facebook.FacebookSdk;

import java.util.Locale;

import mx.iteso.jaimeapp.pideseloajaime.R;
public class ActivityTienda extends ActivityAbstract {

    private static final String DEBUG_TAG = "ActivityTienda";

    private TabLayout tabLayout;
    private ViewPager viewPager;
    SectionsPagerAdapter mSectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(DEBUG_TAG, "OnCreate");
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this);
        setContentView(R.layout.activity_tienda);
        onCreateDrawer();

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);


    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FragmentBeverages();
                case 1:
                    return new FragmentComida();
                case 2:
                    return new FragmentPaquetes();
            }
            return null;
        }
        public int getCount() {
            return 3;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0: return getString(R.string.fragment_tab1);
                case 1: return getString(R.string.fragment_tab2);
                case 2: return getString(R.string.fragment_tab3);
            }
            return null;
        }
    }

}
