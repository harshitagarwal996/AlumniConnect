package com.example.shivanshu.alumniconnect;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity implements ProfileHeaderFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        FragmentManager manager=getSupportFragmentManager();
        if(manager.findFragmentById(R.id.profile_header_fragment_profile_activity)==null)
        {

            ProfileHeaderFragment profileHeaderFragment=new ProfileHeaderFragment();
            FragmentTransaction profileHeaderFragmenttransaction=manager.beginTransaction();
            profileHeaderFragmenttransaction.add(R.id.profile_header_fragment_profile_activity,profileHeaderFragment);
            profileHeaderFragmenttransaction.commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
