package com.mobiquity.localdel;

import android.content.Context;

/**
 * Created by rsampath on 7/21/14.
 */
public interface BaseInfo {
    public String getDescription();
    public String getSubtitleString();
    public void view(Context context) ;

    public int getDrawable();
}
