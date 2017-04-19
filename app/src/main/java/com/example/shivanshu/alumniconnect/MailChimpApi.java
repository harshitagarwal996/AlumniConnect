package com.example.shivanshu.alumniconnect;

import android.support.v7.view.ActionMode;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by shivanshu on 2/22/2017.
 */

public interface MailChimpApi {

    @FormUrlEncoded
    @POST("index.php")
    public  Call<MailChimpApiLIst> insertUser(
            @Field("name") String name,
            @Field("collegename") String collegename,
            @Field("collegeid") String collegeid,
            @Field("emailid") String email,
            @Field("contactnumber") long contactnumber,
            @Field("branch") String branch,
            @Field("password") String password);


    @FormUrlEncoded
    @POST("alumni.php")
    public  Call<MailChimpApiLIst> insertAlumni(
            @Field("name") String name,
            @Field("collegename") String collegename,
            @Field("collegeid") String collegeid,
            @Field("emailid") String email,
            @Field("contactnumber") long contactnumber,
            @Field("branch") String branch,
            @Field("password") String password);


    @GET("company.php")
    public Call<MailChimpList> companyDetails(@Query("querycode") int querycode,@Query("companyname") String companyname);

    @GET("company.php")
    public Call<CompanyServerList> companyList(@Query("querycode") int querycode,@Query("companyname") String companyname);
    @GET("question.php")
    public Call<QuestionServerList> questionList(@Query("companyname") String companyname);
    @GET("studentvalidate.php")
    public Call<MailChimpApiLIst> studentValidate(@Query("collegeid") String querycode,@Query("password") String companyname);
    @GET("alumnivalidate.php")
    public Call<MailChimpApiLIst> alumniValidate(@Query("collegeid") String querycode,@Query("password") String companyname);
}
