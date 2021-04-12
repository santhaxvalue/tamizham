package com.xvalue.myapplication;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.xvalue.myapplication.fragment.AllFragment;
import com.xvalue.myapplication.fragment.FavFragment;
import com.xvalue.myapplication.fragment.MostFragment;
import com.xvalue.myapplication.fragment.TrendingFragment;

public class BottomTab extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_tab);
        bottomNavigation = findViewById(R.id.bottom_navigation);

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Fragment fragment = new TrendingFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment, fragment.getClass().getSimpleName())
                .commit();

    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_action, menu) ;

        return true ;
    }*/

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.navigation_trending:
                    Log.e("Fragment", "TESTING");

                    Fragment fragment = new TrendingFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, fragment, fragment.getClass().getSimpleName())
                            .commit();
                    //openFragment(TrendingFragment.newInstance("", ""));
                    return true;
                case R.id.navigation_most:

                    Fragment fragment1 = new MostFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, fragment1, fragment1.getClass().getSimpleName())
                            .commit();
                    //openFragment(MostFragment.newInstance("", ""));
                    return true;
                case R.id.navigation_all:
                    Fragment fragment2 = new AllFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, fragment2, fragment2.getClass().getSimpleName())
                            .commit();
                   // openFragment(AllFragment.newInstance("", ""));
                    return true;
                case R.id.navigation_fav:
                    Fragment fragment3 = new FavFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, fragment3, fragment3.getClass().getSimpleName())
                            .commit();
                    //openFragment(FavFragment.newInstance("", ""));
                    return true;

            }
            return false;
        }
    };


}
