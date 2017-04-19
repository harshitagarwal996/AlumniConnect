package com.example.shivanshu.alumniconnect;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shivanshu on 3/28/2017.
 */

public class DetailFetchViewHolder extends RecyclerView.ViewHolder implements Callback<MailChimpList>{
    TextView CompanyNameDetail;
    TextView Durration;
    TextView ViewMore;
  ImageView companyImage;
     String tab;
    String imageurl;


    int Flag=0;
    FrameLayout DetailLayout;
    FragmentManager manager;
    View view;


    public DetailFetchViewHolder(View itemView) {
        super(itemView);
        CompanyNameDetail=(TextView)itemView.findViewById(R.id.company_fetch_name);
        Durration=(TextView)itemView.findViewById(R.id.durration);
        companyImage=(ImageView)itemView.findViewById(R.id.company_image);


        ViewMore=(TextView)itemView.findViewById(R.id.view_more);
        itemView.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
            view=v;
                setConnection();


            }
        });
    }
    public void currentStatus(String s,String Image)
    {
imageurl=Image;
        tab=s;
    }
    private void setConnection()
    {
        Call<MailChimpList> call= RetrofitObject.getRetrofitObject().companyDetails(2,tab);
        call.enqueue(this);
    }


    @Override
    public void onResponse(Call<MailChimpList> call, Response<MailChimpList> response) {
        MailChimpList list=response.body();
        String s="";
        for(CompanyServerDetails list1:list.companyDetails) {

            s= list1.getCompanyName();
            DetailHandleClass.jobDescription=list1.getJobDescription();
            DetailHandleClass.NumberOfRound=list1.getNumberOfRound();
            Log.d("digvijay",""+list1.getJobDescription());
            DetailHandleClass.NumberOfApplied=list1.getNumberofApplied();
            DetailHandleClass.NumberOfSelected=list1.getNumberOfSelected();

        }
        Intent intent=new CompanyFullDetailActivity().getIntent(view.getContext(),tab,imageurl);
        view.getContext().startActivity(intent);

    }

    @Override
    public void onFailure(Call<MailChimpList> call, Throwable t) {

    }
}
