package com.example.shivanshu.alumniconnect;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class StudentDetail extends AppCompatActivity implements StudentDetailFragment.OnFragmentInteractionListener,AlumniDetailFragment.OnFragmentInteractionListener{
FragmentManager detailManager;
    FragmentTransaction detailTransaction;
    private final int STUNDENT_INDEX=1;
    private final int ALUMNI_INDEX=0;
    static int j;
    public static Intent getIntent(Context context ,int id)
    {
        j=id;
        Intent intent=new Intent(context,StudentDetail.class);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);
detailManager=getSupportFragmentManager();
        detailTransaction=detailManager.beginTransaction();

        if(j==STUNDENT_INDEX)
        {
            StudentDetailFragment studentDetailFragment=StudentDetailFragment.newInstance();
            detailTransaction.add(R.id.detail_fragment,studentDetailFragment);
            detailTransaction.commit();
        }
        else if(j==ALUMNI_INDEX)
        {
            AlumniDetailFragment alumnitDetailFragment=AlumniDetailFragment.newInstance();
            detailTransaction.add(R.id.detail_fragment,alumnitDetailFragment);
            detailTransaction.commit();

        }

    }

    @Override
    public void onStudentDetailInteraction(Uri uri) {

    }

    @Override
    public void onAlumniDetailInteraction() {

    }
}
