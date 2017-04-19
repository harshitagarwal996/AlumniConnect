package com.example.shivanshu.alumniconnect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by shivanshu on 4/6/2017.
 */

public class CompanyServerList {
    @Expose
    @SerializedName("companyname")
    public List<CompanyServerLIstExpose> companyDetails;


    public class CompanyServerLIstExpose
    {
        @Expose
        @SerializedName("companyname")
        private  String companyName;

        @Expose
        @SerializedName("durration")
        private  String durration;
        @Expose
        @SerializedName("imageurl")
        private  String imageurl;



        public String getDurration() {

            return durration;
        }

        public String getCompanyName()
        {
            return companyName;
        }

        public String getImageurl() {
            return imageurl;
        }
    }

}
