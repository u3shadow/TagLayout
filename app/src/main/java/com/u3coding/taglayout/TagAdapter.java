package com.u3coding.taglayout;

import android.view.View;
import android.view.ViewGroup;

public abstract class TagAdapter {
    public abstract int getItemCount();
    public abstract View getViews(int p, ViewGroup viewGroup);
}
