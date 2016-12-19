package com.zhouwei.md.materialdesignsamples.behavoir;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.OverScroller;

import com.zhouwei.md.materialdesignsamples.MaterialDesignSimpleApplication;
import com.zhouwei.md.materialdesignsamples.R;

import java.lang.ref.WeakReference;

/**
 * Created by zhouwei on 16/12/15.
 */

public class HeaderScrollBehavior extends CoordinatorLayout.Behavior<View> {
     public static final String TAG = "HeaderScrollBehavior";

     private WeakReference<View> mDependencyView;

     private OverScroller mOverScroller;

     private Handler mHandler;

     private  boolean isExpand = false;

     private boolean isScrolling = false;

     public  HeaderScrollBehavior(Context context, AttributeSet attributeSet){
         super(context,attributeSet);
         mOverScroller = new OverScroller(context);
         mHandler = new Handler();

     }
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        if(isDepend(dependency)){
            Log.i("zhouwei","isDeoendent : true");
            mDependencyView = new WeakReference<View>(dependency);
            return true;
        }

        return false;
    }
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        Resources resources = getDependencyView().getResources();
        final float progress = 1.f -
                Math.abs(dependency.getTranslationY() / (dependency.getHeight() - resources.getDimension(R.dimen.header_offset)));
        Log.i(TAG,"dependency.getTranslationY():"+dependency.getTranslationY());
        child.setTranslationY(dependency.getHeight() + dependency.getTranslationY());

        float scale = 1 + 0.4f * (1.f - progress);
        dependency.setScaleX(scale);
        dependency.setScaleY(scale);

        dependency.setAlpha(progress);


        return true;
    }

    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, View child, int layoutDirection) {
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
        if(params!=null && params.height == CoordinatorLayout.LayoutParams.MATCH_PARENT){
            child.layout(0,0,parent.getWidth(),parent.getHeight()- getHeaderCollspateHeight());
            return true;
        }

        return super.onLayoutChild(parent, child, layoutDirection);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        isScrolling = false;
        mOverScroller.abortAnimation();
        super.onNestedScrollAccepted(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View get, int dx, int dy, int[] consumed) {
        Log.e(TAG,"--->invoke onNestedPreScroll");
        Log.i(TAG,"dy---->"+dy);
       if(dy < 0){
           return;
       }
       View dependentView = getDependencyView();
        Log.i(TAG,"TranslationY():"+dependentView.getTranslationY()+" dy---->"+dy);
        float newTranslationY = dependentView.getTranslationY() - dy;
        float minHeaderTranslation = -(dependentView.getHeight() - getHeaderCollspateHeight());
        Log.i(TAG,"onNestedPreScroll:::newTranslationY:"+newTranslationY+"--->minHeaderTranslation"+minHeaderTranslation);
        if(newTranslationY > minHeaderTranslation){
            dependentView.setTranslationY(newTranslationY);
            consumed[1] = dy;
        }
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        Log.e(TAG,"++++invoke onNestedScroll");
       Log.i(TAG,"dyUnconsumed:"+dyUnconsumed);
       if(dyUnconsumed > 0){
           return;
       }
        View dependentView = getDependencyView();
        float newTranslateY = dependentView.getTranslationY() - dyUnconsumed;
        final float maxHeaderTranslate = 0;
        Log.i(TAG,"onNestedScroll:::newTranslateY:"+newTranslateY+"--->maxHeaderTranslate"+maxHeaderTranslate);
        if (newTranslateY < maxHeaderTranslate) {
            dependentView.setTranslationY(newTranslateY);
        }
    }

   @Override
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY) {
        return onUserStopDragging(velocityY);
    }

    @Override
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target) {
        if(!isScrolling){
            onUserStopDragging(800);
        }
    }

    private boolean onUserStopDragging(float velocity) {
        View dependentView = getDependencyView();
        float translateY = dependentView.getTranslationY();
        float minHeaderTranslate = -(dependentView.getHeight() - getHeaderCollspateHeight());

        if (translateY == 0 || translateY == minHeaderTranslate) {
            return false;
        }

        boolean targetState; // Flag indicates whether to expand the content.
        if (Math.abs(velocity) <= 800) {
            if (Math.abs(translateY) < Math.abs(translateY - minHeaderTranslate)) {
                targetState = false;
            } else {
                targetState = true;
            }
            velocity = 800; // Limit velocity's minimum value.
        } else {
            if (velocity > 0) {
                targetState = true;
            } else {
                targetState = false;
            }
        }

        float targetTranslateY = targetState ? minHeaderTranslate : 0;
        mOverScroller.startScroll(0, (int) translateY, 0, (int) (targetTranslateY - translateY), (int) (1000000 / Math.abs(velocity)));
        mHandler.post(flingRunnable);
        isScrolling = true;

        return true;
    }


    private View getDependencyView (){
        return mDependencyView.get();
    }
    /**
     * header 折叠高度
     * @return
     */
    public int getHeaderCollspateHeight(){
        return MaterialDesignSimpleApplication.getAppContext().getResources().getDimensionPixelOffset(R.dimen.header_offset);
    }

    public boolean isDepend(View dependency){
        return dependency!=null && dependency.getId() == R.id.header_view;
    }

    private Runnable flingRunnable = new Runnable() {
        @Override
        public void run() {
           if(mOverScroller.computeScrollOffset()){
               getDependencyView().setTranslationY(mOverScroller.getCurrY());
               mHandler.post(this);
           } else{
               isExpand = getDependencyView().getTranslationX() != 0;
               isScrolling = false;
           }
        }
    };
}
