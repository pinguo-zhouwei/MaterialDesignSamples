package com.zhouwei.md.materialdesignsamples.behavoir;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.zhouwei.md.materialdesignsamples.MaterialDesignSimpleApplication;
import com.zhouwei.md.materialdesignsamples.R;

/**
 *
 *   自定义Behavior ：实现RecyclerView(或者其他可滑动View，如：NestedScrollView) 滑动覆盖header 的效果
 * Created by zhouwei on 16/12/19.
 */

public class CoverHeaderScrollBehavior extends CoordinatorLayout.Behavior<View> {
    public static final String TAG = "CoverHeaderScroll";

    public CoverHeaderScrollBehavior(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }


    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, View child, int layoutDirection) {
        Log.i(TAG,"onLayoutChild.....");
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
        if(params!=null && params.height == CoordinatorLayout.LayoutParams.MATCH_PARENT){
            child.layout(0,0,parent.getWidth(),parent.getHeight());
            child.setTranslationY(getHeaderHeight());
            return true;
        }

        return super.onLayoutChild(parent, child, layoutDirection);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        // 在这个方法里面只处理向上滑动
        if(dy < 0){
            return;
        }

        float transY =  child.getTranslationY() - dy;
        Log.i(TAG,"transY:"+transY+"++++child.getTranslationY():"+child.getTranslationY()+"---->dy:"+dy);
        if(transY > 0){
            child.setTranslationY(transY);
            consumed[1]= dy;
        }
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        // 在这个方法里只处理向下滑动
        if(dyUnconsumed >0){
            return;
        }

        float transY = child.getTranslationY() - dyUnconsumed;
        Log.i(TAG,"------>transY:"+transY+"****** child.getTranslationY():"+child.getTranslationY()+"--->dyUnconsumed"+dxUnconsumed);
        if(transY > 0 && transY < getHeaderHeight()){
            child.setTranslationY(transY);
        }
    }

    /**
     * 获取Header 高度
     * @return
     */
    public int getHeaderHeight(){
        return MaterialDesignSimpleApplication.getAppContext().getResources().getDimensionPixelOffset(R.dimen.header_height);
    }

}
