package com.zzh.viewpager.pullcondition;

import android.view.MotionEvent;

import com.zzh.viewpager.HViewPager;


public class LockPullCondition implements HViewPager.PullCondition
{
    @Override
    public boolean canPull(MotionEvent event, HViewPager viewPager)
    {
        return false;
    }
}
