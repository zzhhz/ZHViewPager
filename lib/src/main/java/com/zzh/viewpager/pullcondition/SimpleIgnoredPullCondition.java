package com.zzh.viewpager.pullcondition;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

import com.zzh.viewpager.HViewPager;

import java.lang.ref.WeakReference;

public class SimpleIgnoredPullCondition implements HViewPager.PullCondition
{
    private final WeakReference<View> mView;
    private Rect mRect;

    public SimpleIgnoredPullCondition(View view)
    {
        mView = new WeakReference<>(view);
    }

    public final View getView()
    {
        return mView == null ? null : mView.get();
    }

    @Override
    public boolean canPull(MotionEvent event, HViewPager viewPager)
    {
        final View view = getView();
        if (view == null)
        {
            viewPager.removePullCondition(this);
            return true;
        }

        if (mRect == null)
            mRect = new Rect();

        view.getGlobalVisibleRect(mRect);
        if (mRect.contains((int) event.getRawX(), (int) event.getRawY()))
            return false;

        return true;
    }
}
