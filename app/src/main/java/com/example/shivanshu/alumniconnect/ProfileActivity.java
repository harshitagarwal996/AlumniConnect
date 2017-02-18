package com.example.shivanshu.alumniconnect;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
public class ProfileActivity extends AppCompatActivity{


    public static Intent getProfileActivityIntent(Context c)
    {
        Intent intent =new Intent(c,ProfileActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        FragmentManager manager=getSupportFragmentManager();
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
}
