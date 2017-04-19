package com.example.shivanshu.alumniconnect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by shivanshu on 4/5/2017.
 */

public class CompanyServerDetails {
    @Expose
    @SerializedName("companyname")
    private  String companyName;

    @Expose
    @SerializedName("durration")
    private  String durration;
    @Expose
    @SerializedName("jobdiscription")
    private  String jobDescription;

    @Expose
    @SerializedName("numberofround")
    private  int numberOfRound;

    @Expose
    @SerializedName("numberofstudentselected")
    private   int numberOfSelected;

    @Expose
    @SerializedName("numberofstudentapplied")
    private  int numberofApplied;
    @Expose
    @SerializedName("imageurl")
    private  String imageurl ;

    public  String getCompanyName() {
        return companyName;
    }

    public String getDurration() {
        return durration;
    }

    public  String getJobDescription() {
        return jobDescription;
    }

    public  int getNumberOfRound() {
        return numberOfRound;
    }

    public  int getNumberOfSelected() {
        return numberOfSelected;
    }

    public int getNumberofApplied() {
        return numberofApplied;

    }

    public String getImageurl() {
        return imageurl;
    }
}
