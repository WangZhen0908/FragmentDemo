package com.moon.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.moon.fragment.normal.FragmentActivity;
import com.moon.fragment.hideshow.HideShowActivity;
import com.moon.fragment.vp.ViewPagerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.vp_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainActivity.this, ViewPagerActivity.class);
            }
        });
        findViewById(R.id.hide_show_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainActivity.this, HideShowActivity.class);
            }
        });
        findViewById(R.id.normal_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainActivity.this, FragmentActivity.class);
            }
        });
    }

    private static void startActivity(Context context, Class<?> clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }
}
