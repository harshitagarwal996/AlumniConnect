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

import com.example.shivanshu.alumniconnect.dummy.DummyContent;

public class ProfileActivity extends AppCompatActivity implements ProfileFooterFragment.OnProfileFooterFragmentInteractionListener,ProfileDataFragment.OnProfileDataFragmentInteractionListener,ProfileHeaderFragment.OnProfileHeaderFragmentInteractionListener,CompanyNameFragment.OnCompanyNameFragmentInteractionListener{

    FragmentManager manager;

    public static Intent getProfileActivityIntent(Context c)
    {
        Intent intent =new Intent(c,ProfileActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        manager = getSupportFragmentManager();
        if(manager.findFragmentById(R.id.profile_header_fragment_profile_activity)==null)
        {

            ProfileHeaderFragment profileHeaderFragment=new ProfileHeaderFragment();
            FragmentTransaction profileHeaderFragmentTransaction=manager.beginTransaction();
            profileHeaderFragmentTransaction.add(R.id.profile_header_fragment_profile_activity,profileHeaderFragment);
            profileHeaderFragmentTransaction.commit();
        }
        if(manager.findFragmentById(R.id.profile_data_fragment_profile_activity)==null)
        {
           ProfileDataFragment profileDataFragment=new ProfileDataFragment();
            FragmentTransaction profileDataFragmentTransaction=manager.beginTransaction();

            profileDataFragmentTransaction.add(R.id.profile_data_fragment_profile_activity,profileDataFragment);
            profileDataFragmentTransaction.commit();
        }
        if(manager.findFragmentById(R.id.profile_footer_fragment_profile_activity)==null)
        {
            ProfileFooterFragment profileFooterFragment=new ProfileFooterFragment();
            FragmentTransaction profileFooterfragmentTransaction=manager.beginTransaction();
            profileFooterfragmentTransaction.add(R.id.profile_footer_fragment_profile_activity,profileFooterFragment);
            profileFooterfragmentTransaction.commit();
        }
    }

    @Override
    public void onProfileDataFragmentInteraction(View uri) {
        
    }

    @Override
    public void onProfileFooterFragmentInteraction(View uri) {
        Log.d("harshit","button clicked");
        if(uri.getId()==R.id.home_fragment_profile_footer)
        {
            //may have some bugs
            FragmentTransaction transaction = manager.beginTransaction().replace(R.id.profile_data_fragment_profile_activity, new ProfileDataFragment());
            transaction.commit();
            Log.d("harshit","home button clicked");
        }
        else if(uri.getId()==R.id.profile_fragment_profile_footer)
        {

        }
        else if(uri.getId()==R.id.company_fragment_profile_footer)
        {
            FragmentTransaction transaction = manager.beginTransaction().replace(R.id.profile_data_fragment_profile_activity, new CompanyNameFragment());
            transaction.commit();
            Log.d("harshit","company button clicked");

        }
        else if(uri.getId()==R.id.chat_fragment_profile_footer)
        {

        }
        else if(uri.getId()==R.id.setting_fragment_profile_footer)
        {

        }
    }

    @Override
    public void onProfileHeaderFragmentInteraction(Uri uri) {

    }

    @Override
    public void onCompanyNameFragmentInteraction(DummyContent.DummyItem item) {
        Log.d("harshit","onCompanyNameInteraction called");
    }
}
