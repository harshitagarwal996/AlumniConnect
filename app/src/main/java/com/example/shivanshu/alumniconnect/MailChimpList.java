package com.example.shivanshu.alumniconnect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by shivanshu on 2/22/2017.
 */

public class MailChimpList {
    @Expose
    @SerializedName("companyname")
    public List<CompanyServerDetails> companyDetails;
}
