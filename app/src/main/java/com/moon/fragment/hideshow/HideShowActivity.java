package com.moon.fragment.hideshow;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.moon.fragment.R;

public class HideShowActivity extends AppCompatActivity {

    private FragmentOne mFragmentOne;
    private FragmentTwo mFragmentTwo;
    private FragmentThree mFragmentThree;

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if (mFragmentOne != null) {
                        getSupportFragmentManager().beginTransaction().show(mFragmentOne).commit();
                    } else {
                        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, getFragmentOne()).commit();
                    }
                    if (mFragmentTwo != null) {
                        getSupportFragmentManager().beginTransaction().hide(mFragmentTwo).commit();
                    }

                    if (mFragmentThree != null) {
                        getSupportFragmentManager().beginTransaction().hide(mFragmentThree).commit();
                    }
                    return true;
                case R.id.navigation_dashboard:
                    if (mFragmentTwo != null) {
                        getSupportFragmentManager().beginTransaction().show(mFragmentTwo).commit();
                    } else {
                        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, getFragmentTwo()).commit();
                    }

                    if (mFragmentOne != null) {
                        getSupportFragmentManager().beginTransaction().hide(mFragmentOne).commit();
                    }

                    if (mFragmentThree != null) {
                        getSupportFragmentManager().beginTransaction().hide(mFragmentThree).commit();
                    }
                    return true;
                case R.id.navigation_notifications:
                    if (mFragmentThree != null) {
                        getSupportFragmentManager().beginTransaction().show(mFragmentThree).commit();
                    } else {
                        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, getFragmentThree()).commit();
                    }
                    if (mFragmentOne != null) {
                        getSupportFragmentManager().beginTransaction().hide(mFragmentOne).commit();
                    }

                    if (mFragmentTwo != null) {
                        getSupportFragmentManager().beginTransaction().hide(mFragmentTwo).commit();
                    }
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hide_show);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, getFragmentOne()).commit();
    }

    private FragmentOne getFragmentOne() {
        if (mFragmentOne == null) {
            mFragmentOne = new FragmentOne();
        }
        return mFragmentOne;
    }

    private FragmentTwo getFragmentTwo() {
        if (mFragmentTwo == null) {
            mFragmentTwo = new FragmentTwo();
        }
        return mFragmentTwo;
    }

    private FragmentThree getFragmentThree() {
        if (mFragmentThree == null) {
            mFragmentThree = new FragmentThree();
        }
        return mFragmentThree;
    }

}
