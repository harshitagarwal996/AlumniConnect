package com.example.shivanshu.alumniconnect;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.shivanshu.alumniconnect.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity implements ChatFragment.OnChatFragmentInteractionListener,ProfileFooterFragment.OnProfileFooterFragmentInteractionListener,StudentDetailFragment.OnFragmentInteractionListener,ProfileHeaderFragment.OnProfileHeaderFragmentInteractionListener,CompanyNameFragment.OnCompanyNameFragmentInteractionListener,ProfileDetailFragment.OnProfileDetailFragmentInteractionListener,AlumniDetailFragment.OnFragmentInteractionListener,CompanyProfileDetails.OnCompanyDetailInteractionListener , Callback<MailChimpList> {

    FragmentManager manager;
    static Context context;
    static int HostingDetails;
    private final int STUDENTINDEX = 1;
    private final int ALUMNIINDEX = 0;
    private int flagExitOnBackPressed=0;

    public static Intent getProfileActivityIntent(Context c, int Deatils) {
        HostingDetails = Deatils;
        Intent intent = new Intent(c, ProfileActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        flagExitOnBackPressed=0;

        manager = getSupportFragmentManager();

        if (manager.findFragmentById(R.id.profile_data_fragment_profile_activity) == null) {
            CompanyProfileDetails profileDataFragment = CompanyProfileDetails.newInstance();
            FragmentTransaction profileDataFragmentTransaction = manager.beginTransaction();

            profileDataFragmentTransaction.add(R.id.profile_data_fragment_profile_activity, profileDataFragment);
            profileDataFragmentTransaction.commit();
        }
        if (manager.findFragmentById(R.id.profile_footer_fragment_profile_activity) == null) {
            ProfileFooterFragment profileFooterFragment = new ProfileFooterFragment();
            FragmentTransaction profileFooterfragmentTransaction = manager.beginTransaction();
            profileFooterfragmentTransaction.add(R.id.profile_footer_fragment_profile_activity, profileFooterFragment);
            profileFooterfragmentTransaction.commit();
        }
    }
    @Override
    public void onBackPressed() {
        if(flagExitOnBackPressed>=2)
            finish();
        Toast.makeText(this,"Press again to exit",Toast.LENGTH_SHORT).show();
        flagExitOnBackPressed+=1;
    }


    @Override
    public void onProfileFooterFragmentInteraction(View uri) {
        Log.d("harshit", "button clicked");
        if (uri.getId() == R.id.home_fragment_profile_footer) {
            Intent intent=QuestionAnswerListActivity.getIntentActivity(this);
            startActivity(intent);


        } else if (uri.getId() == R.id.profile_fragment_profile_footer) {

            FragmentTransaction transaction = manager.beginTransaction().replace(R.id.profile_data_fragment_profile_activity, new ProfileDetailFragment());
            transaction.commit();
            Log.d("harshit", "profile button clicked");
        } else if (uri.getId() == R.id.company_fragment_profile_footer) {

            FragmentTransaction transaction = manager.beginTransaction().replace(R.id.profile_data_fragment_profile_activity, CompanyProfileDetails.newInstance());
            transaction.commit();

            Log.d("harshit", "company button clicked");

        }

        else if (uri.getId() == R.id.chat_fragment_profile_footer) {


            FragmentTransaction transaction = manager.beginTransaction().replace(R.id.profile_data_fragment_profile_activity, ChatFragment.newInstance());
            transaction.commit();
        }

        else if (uri.getId() == R.id.setting_fragment_profile_footer) {
            //TODO: clear shared preferences
            finish();

        }
    }

    @Override
    public void onProfileHeaderFragmentInteraction(Uri uri) {

    }

    @Override
    public void onCompanyNameFragmentInteraction(DummyContent.DummyItem item) {
        Log.d("harshit", "onCompanyNameInteraction called");
    }

    // Changes Created by Digvijay singh k on 20feb2016

    @Override
    public void onProfileDetailFragmentInteraction() {

        if (HostingDetails == STUDENTINDEX) {
            FragmentTransaction transaction = manager.beginTransaction().replace(R.id.profile_data_fragment_profile_activity, StudentDetailFragment.newInstance());
            transaction.commit();

        } else if (HostingDetails == ALUMNIINDEX) {

            FragmentTransaction transaction = manager.beginTransaction().replace(R.id.profile_data_fragment_profile_activity, AlumniDetailFragment.newInstance());
            transaction.commit();
        }

    }

    @Override
    public void onStudentDetailInteraction() {

        FragmentTransaction transaction = manager.beginTransaction().replace(R.id.profile_data_fragment_profile_activity, new ProfileDetailFragment());
        transaction.commit();
    }

    @Override
    public void onAlumniDetailInteraction() {
        FragmentTransaction transaction = manager.beginTransaction().replace(R.id.profile_data_fragment_profile_activity, new ProfileDetailFragment());
        transaction.commit();

    }

    @Override
    public void onChatFragmentInteraction(Uri uri) {

    }

    @Override
    public void onCompanyDetailInteraction(String s) {
        Log.d("digvijay",s);
        Call<MailChimpList> call= RetrofitObject.getRetrofitObject().companyDetails(2,s);
        call.enqueue((this));



    }

    @Override
    public void onResponse(Call<MailChimpList> call, Response<MailChimpList> response) {
        MailChimpList list=response.body();
        String s="";
        String companyName="";
for(CompanyServerDetails list1:list.companyDetails) {
     s= list1.getImageurl();
    companyName=list1.getCompanyName();
    DetailHandleClass.jobDescription=list1.getJobDescription();
    DetailHandleClass.NumberOfRound=list1.getNumberOfRound();
    Log.d("digvijay",""+list1.getJobDescription());
    DetailHandleClass.NumberOfApplied=list1.getNumberofApplied();
    DetailHandleClass.NumberOfSelected=list1.getNumberOfSelected();

}
        Intent intent=CompanyFullDetailActivity.getIntent(this,companyName,s);
        startActivity(intent);

    }

    @Override
    public void onFailure(Call<MailChimpList> call, Throwable t) {
        Log.d("digvijay",""+t);

    }
}