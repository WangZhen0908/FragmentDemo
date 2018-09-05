package com.moon.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public abstract class HiddenVisibleFragment extends Fragment {

    protected boolean mIsReady = false;

    /**
     * 是否是ViewPager模式
     */
    private boolean mIsViewPager;
    private boolean mIsVisibleToUser;

    /**
     * 是否是hide、show模式
     */
    private boolean mIsHideShow;
    private boolean mHidden;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Log.i("info", "HiddenVisibleFragment :" + getClass().getSimpleName() + " onCreate ");
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        Log.i("info", "HiddenVisibleFragment :" + getClass().getSimpleName() + " onCreateView ");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        Log.i("info", "HiddenVisibleFragment :" + getClass().getSimpleName() + " onViewCreated ");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        mIsViewPager = true;
        mIsVisibleToUser = isVisibleToUser;
//        Log.i("info", "HiddenVisibleFragment :" + getClass().getSimpleName() + " setUserVisibleHint " + isVisibleToUser);
        super.setUserVisibleHint(isVisibleToUser);
        if (!mIsReady)//view没有创建的时候不进行操作
            return;

        if (isVisibleToUser) {
            visible();
        } else {
            hide();
        }
    }

    @Override
    public void onResume() {//和activity的onResume绑定，Fragment初始化的时候必调用，但切换fragment的hide和visible的时候可能不会调用！
        super.onResume();
//        Log.i("info", "HiddenVisibleFragment :" + getClass().getSimpleName() + " onResume ");
        mIsReady = true;
        if (isShow()) {
            visible();
        }
    }

    private boolean isShow() {

        if (mIsViewPager) {
            return mIsVisibleToUser;
        }

        if (mIsHideShow) {
            return !mHidden;
        }

        return true;
    }

    @Override
    public void onPause() {
        super.onPause();
//        Log.i("info", "HiddenVisibleFragment :" + getClass().getSimpleName() + " onPause ");
        if (!isShow()) {
            return;
        }
        hide();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        mIsHideShow = true;
        mHidden = hidden;
//        Log.i("info", "HiddenVisibleFragment :" + getClass().getSimpleName() + " onHiddenChanged " + hidden);
        //默认fragment创建的时候是可见的，但是不会调用该方法！切换可见状态的时候会调用，但是调用onResume，onPause的时候却不会调用
        super.onHiddenChanged(hidden);
        if (!hidden) {
            visible();
        } else {
            hide();
        }
    }

    private void visible() {
        onVisible();
    }

    private void hide() {
        onHidden();
    }

    /**
     * 可见
     */
    protected void onVisible() {
        Log.i("info", "HiddenVisibleFragment :" + getClass().getSimpleName() + " onVisible ");
    }

    /**
     * fragment不可见的时候操作,onPause的时候,以及不可见的时候调用
     */
    protected void onHidden() {
        Log.i("info", "HiddenVisibleFragment :" + getClass().getSimpleName() + " onHidden ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mIsReady = false;
    }
}
