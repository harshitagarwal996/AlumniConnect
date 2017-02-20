package com.example.shivanshu.alumniconnect;

import android.util.Log;

/**
 * Created by shivanshu on 2/18/2017.
 */

public class DetailHandleModel {
    public static String[] DetailArray=new String[7];
    public static void studentRegistrationDetail(String[] s){
        Log.d("digvijay","function is called");
        for(int i=0;i<s.length;i++)
        {
          DetailArray[i]=s[i];
           // Log.d("digvijay",DetailArray[i] );
        }


    }
    public static void alumniRegistrationDetail(String[] s)
    {
        for(int i=0;i<s.length;i++)
        {
            DetailArray[i]=s[i];
        }

    }
    public String DeatilDisplay(int i)
    {

        return DetailArray[i];
    }


}
