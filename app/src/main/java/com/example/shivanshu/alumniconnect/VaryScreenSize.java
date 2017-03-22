package com.example.shivanshu.alumniconnect;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by shivanshu on 3/2/2017.
 */

public class VaryScreenSize {
    public static int width=0;//720 for my screen
    public static int height=0;//1280 for my screen
    public static void setHeadingSize()
    {
        int variation=0;

        if(height>1280)
        {
            variation=height-1280+height/43;
        }

    }

}
