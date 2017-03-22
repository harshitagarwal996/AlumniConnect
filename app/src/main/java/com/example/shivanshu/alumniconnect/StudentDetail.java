package com.example.shivanshu.alumniconnect;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class StudentDetail extends AppCompatActivity implements StudentDetailFragment.OnFragmentInteractionListener,AlumniDetailFragment.OnFragmentInteractionListener{
    String D1="";
    String D2="";
    String D3="";
    String D4="";
    String D5="";
    String D6="";
    String D7="";

    FragmentManager detailManager;
    DataBaseConnectivity myDb;
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
     myDb=new DataBaseConnectivity(this);
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
    public void onStudentDetailInteraction() {

        for(int i=0;i<DetailHandleModel.DetailArray.length;i++)
        {
             D1=DetailHandleModel.DetailArray[i];
             D2=DetailHandleModel.DetailArray[i];
             D3=DetailHandleModel.DetailArray[i];
             D4=DetailHandleModel.DetailArray[i];
             D5=DetailHandleModel.DetailArray[i];
             D6=DetailHandleModel.DetailArray[i];
             D7=DetailHandleModel.DetailArray[i];
        }
    boolean x= myDb.studentDataInsert(D1,D2,D3,D4,D5,D6,D7);
        if(x) {
            Intent intent = ProfileActivity.getProfileActivityIntent(this, STUNDENT_INDEX);
            startActivity(intent);
            finish();
        }
        else
        {
            Toast.makeText(this,"Data donot insert",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onAlumniDetailInteraction(String[] s) {
        for(int i=0;i<DetailHandleModel.DetailArray.length;i++)
        {
            D1=DetailHandleModel.DetailArray[i];
            D2=DetailHandleModel.DetailArray[i];
            D3=DetailHandleModel.DetailArray[i];
            D4=DetailHandleModel.DetailArray[i];
            D5=DetailHandleModel.DetailArray[i];
            D6=DetailHandleModel.DetailArray[i];
            D7=DetailHandleModel.DetailArray[i];
        }
        myDb.alumniDataInsert(D1,D2,D3,D4,D5,D6,D7);
        Intent intent=ProfileActivity.getProfileActivityIntent(this,ALUMNI_INDEX);
        startActivity(intent);

    }
}
