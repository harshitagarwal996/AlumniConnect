package com.example.shivanshu.alumniconnect;

/**
 * Created by shivanshu on 2/25/2017.
 */

public class DetailHandleClass {

    static   String jobDescription="";
    static int NumberOfRound;
   static int NumberOfApplied;
    static int NumberOfSelected;

    public static int NumberOfRound() {
        return NumberOfRound;
    }

    public static String getJobDescription() {

        return jobDescription;
    }

    public static int NumberOfApplied() {
        return NumberOfApplied;
    }

    public static int getNumberOfSelected() {
        return NumberOfSelected;
    }
}
