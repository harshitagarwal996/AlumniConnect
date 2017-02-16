package com.example.shivanshu.alumniconnect;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StudentDetail extends AppCompatActivity implements StudentDetailFragment.OnFragmentInteractionListener,AlumniDetailFragment.OnFragmentInteractionListener{
FragmentManager detailManager;
    FragmentTransaction detailTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);
detailManager=getSupportFragmentManager();
        if(detailManager.getFragments()==null)
        {
            StudentDetailFragment studentDetailFragment=StudentDetailFragment.newInstance();
            detailTransaction=detailManager.beginTransaction();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onAlumniDetailInteraction() {

    }
}
