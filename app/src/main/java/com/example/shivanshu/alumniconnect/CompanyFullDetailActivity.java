package com.example.shivanshu.alumniconnect;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.x;

public class CompanyFullDetailActivity extends AppCompatActivity implements CompanyFullDetailFragment.OnFragmentInteractionListener,Callback<QuestionServerList>,QuestionAnswerFragment.OnFragmentInteractionListener {

    static String CompanyName="";
    FragmentManager manager;
    static String imageurl;
    ImageView CompanyImage;
    TransitionManager transitionManager;
    AlertDialog alertDialog;
     List<QuestionServerListHandle> details=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_full_detail);
        CompanyImage=(ImageView) findViewById(R.id.company_image_view);
        Picasso.with(this).load(imageurl).into(CompanyImage);
        manager=getSupportFragmentManager();
      CompanyFullDetailFragment fragment=CompanyFullDetailFragment.newInstance();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.full_deatils,fragment);
        transaction.commit();


    }
    public static Intent  getIntent(Context c,String Companyname ,String image)
    {
        CompanyName=Companyname;
imageurl=image;
        Intent intent=new Intent(c,CompanyFullDetailActivity.class);
        return intent;
    }

    @Override
    public void onFragmentInteraction() {
        Call<QuestionServerList> call= RetrofitObject.getRetrofitObject().questionList(CompanyName);
        call.enqueue(this);
        AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("please Waiit");
        alertDialog=alertDialogBuilder.create();
        alertDialog.show();

    }

    @Override
    public void onResponse(Call<QuestionServerList> call, Response<QuestionServerList> response) {
        alertDialog.cancel();
        QuestionServerList list=response.body();
        for(QuestionServerList.QuestionServerLIstExpose list1:list.companyDetails)
        {
            Log.d("digvijay",""+list1.getQuestion());
            details.add(new QuestionServerListHandle(list1.getQuestion(),list1.getAnswer()));
        }

        QuestionAnswerFragment fragment=QuestionAnswerFragment.newInstance(details);
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.full_deatils,fragment);
        transaction.commit();
    }

    @Override
    public void onFailure(Call<QuestionServerList> call, Throwable t) {
        Log.d("digvijay",""+t);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
