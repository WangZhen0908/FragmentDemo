package com.moon.fragment.normal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.moon.fragment.R;
import com.moon.fragment.hideshow.FragmentOne;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new FragmentOne()).commit();
    }
}
