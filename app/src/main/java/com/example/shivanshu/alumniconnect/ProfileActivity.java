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

public class ProfileActivity extends AppCompatActivity implements ChatFragment.OnChatFragmentInteractionListener,ProfileFooterFragment.OnProfileFooterFragmentInteractionListener,ProfileDataFragment.OnProfileDataFragmentInteractionListener,StudentDetailFragment.OnFragmentInteractionListener,ProfileHeaderFragment.OnProfileHeaderFragmentInteractionListener,CompanyNameFragment.OnCompanyNameFragmentInteractionListener,ProfileDetailFragment.OnProfileDetailFragmentInteractionListener,AlumniDetailFragment.OnFragmentInteractionListener {
FrameLayout HeaderLayout;
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
        HeaderLayout=(FrameLayout)findViewById(R.id.profile_header_fragment_profile_activity);
        manager = getSupportFragmentManager();
        if (manager.findFragmentById(R.id.profile_header_fragment_profile_activity) == null) {

            ProfileHeaderFragment profileHeaderFragment = new ProfileHeaderFragment();
            FragmentTransaction profileHeaderFragmentTransaction = manager.beginTransaction();
            profileHeaderFragmentTransaction.add(R.id.profile_header_fragment_profile_activity, profileHeaderFragment);
            profileHeaderFragmentTransaction.commit();
        }
        if (manager.findFragmentById(R.id.profile_data_fragment_profile_activity) == null) {
            ProfileDataFragment profileDataFragment = new ProfileDataFragment();
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
    public void onProfileDataFragmentInteraction(View uri) {

    }

    @Override
    public void onProfileFooterFragmentInteraction(View uri) {
        Log.d("harshit", "button clicked");
        if (uri.getId() == R.id.home_fragment_profile_footer) {
            //may have some bugs
            HeaderLayout.setVisibility(View.VISIBLE);
            FragmentTransaction transaction = manager.beginTransaction().replace(R.id.profile_data_fragment_profile_activity, new ProfileDataFragment());
            transaction.commit();
            Log.d("harshit", "home button clicked");
        } else if (uri.getId() == R.id.profile_fragment_profile_footer) {

            HeaderLayout.setVisibility(View.VISIBLE);
            FragmentTransaction transaction = manager.beginTransaction().replace(R.id.profile_data_fragment_profile_activity, new ProfileDetailFragment());
            transaction.commit();
            Log.d("harshit", "profile button clicked");
        } else if (uri.getId() == R.id.company_fragment_profile_footer) {
            HeaderLayout.setVisibility(View.VISIBLE);
            FragmentTransaction transaction = manager.beginTransaction().replace(R.id.profile_data_fragment_profile_activity, new CompanyNameFragment());
            transaction.commit();
            Log.d("harshit", "company button clicked");

        }

        else if (uri.getId() == R.id.chat_fragment_profile_footer) {


            FragmentTransaction transaction = manager.beginTransaction().replace(R.id.profile_data_fragment_profile_activity, ChatFragment.newInstance());
            transaction.commit();
            HeaderLayout.setVisibility(View.GONE);
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
    public void onAlumniDetailInteraction(String[] s) {
        FragmentTransaction transaction = manager.beginTransaction().replace(R.id.profile_data_fragment_profile_activity, new ProfileDetailFragment());
        transaction.commit();

    }

    @Override
    public void onChatFragmentInteraction(Uri uri) {

    }
}