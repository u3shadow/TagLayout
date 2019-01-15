package com.u3coding.taglayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class TagLayout extends ViewGroup {
    private int width;
    private int height;

    public TagLayout(Context context) {
        super(context);
    }
    public TagLayout(Context context,AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
       int childMaxHeight = -1;
       int childWidth = 0;
       int cl = 0,ct = 0;
       for(int i = 0;i < getChildCount();i++){
        View child = getChildAt(i);
        if (child.getMeasuredHeight() > childMaxHeight){
            childMaxHeight = child.getMeasuredHeight();
        }
        childWidth += child.getMeasuredWidth();
        child.layout(cl,ct,cl+child.getMeasuredWidth(),child.getMeasuredHeight()+ct);
        cl += child.getMeasuredWidth();
        if (childWidth >= width){
            ct += childMaxHeight;
            cl = 0;
            childMaxHeight = -1;
            childWidth = 0;
        }
       }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
       super.onMeasure(widthMeasureSpec, heightMeasureSpec);
       width = MeasureSpec.getSize(widthMeasureSpec);
       height = MeasureSpec.getSize(heightMeasureSpec);
       int childMaxHeight = -1;
       int childWidth = 0;
       for(int i = 0;i < getChildCount();i++){
        View child = getChildAt(i);
        measureChild(child,widthMeasureSpec,heightMeasureSpec);
        if (child.getHeight() > childMaxHeight){
            childMaxHeight = child.getHeight();
        }
        childWidth += child.getWidth();
        if (childWidth >= width){
            height += childMaxHeight;
            childMaxHeight = -1;
            childWidth = 0;
        }
       }
       setMeasuredDimension(width,1000);
    }
    public void setAdapter(TagAdapter adapter){
        if (adapter == null){
            return;
        }
        removeAllViews();
        for (int i = 0;i < adapter.getItemCount();i++){
            View child = adapter.getViews(i,this);
            addView(child);
        }
    }
}
