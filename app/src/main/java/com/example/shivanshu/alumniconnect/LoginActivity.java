package com.example.shivanshu.alumniconnect;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements LoginFragment.OnStudentInteractionListener,AlumniFragment.OnAlumniInteractionListener{
TextView currentStudent;
    TextView alumni;
    FrameLayout frameLayout;
    FragmentManager fragmentManager;
    String Username="";
    String Password="";
    FragmentTransaction LoginTransaction;
    boolean LoginStatus = false;

    public final int STUDENT_INDEX=1;
    public final int Alumni_INDEX=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        frameLayout=(FrameLayout)findViewById(R.id.student_login_fragment);
        currentStudent=(TextView)findViewById(R.id.current_student);
        alumni=(TextView)findViewById(R.id.alumni);
        if(fragmentManager==null) {
            fragmentManager = getSupportFragmentManager();
            LoginFragment loginFragment = LoginFragment.newInstance();
            FragmentTransaction LoginTransaction = fragmentManager.beginTransaction();
            LoginTransaction.replace(R.id.student_login_fragment, loginFragment);
            LoginTransaction.commit();
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onStudentInteraction(int count) {
        Fade fade=new Fade();
        fade.setDuration(500);
        TransitionManager.beginDelayedTransition(frameLayout,fade);
        if(count==1)
        {
            AlumniFragment alumniFragment = AlumniFragment.newInstance();
            FragmentTransaction LoginTransaction = fragmentManager.beginTransaction();
            LoginTransaction.replace(R.id.student_login_fragment, alumniFragment);
            //LoginTransaction.addToBackStack(null);
            LoginTransaction.commit();
        }
        if(count==2) {

            Username = LoginFragment.studentId();
            Password = LoginFragment.studentPassword();

            if (Username.equals("") || Password.equals("")) {
                Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
            } else {
                DataBaseConnectivity db = new DataBaseConnectivity(this);
                Cursor cr = db.studentGetAuthorised(db);
                cr.moveToFirst();
                do {
                    Log.d("digvijay", cr.getString(0));
                    if ((Username.equals(cr.getString(0))) && (Password.equals(cr.getString(1)))) ;
                    {
                        LoginStatus = true;
                    }

                } while (cr.moveToNext());

                if (LoginStatus) {
                    Intent intent = ProfileActivity.getProfileActivityIntent(this, STUDENT_INDEX);
                    startActivity(intent);
                    finish();
                } else {

                    Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_LONG).show();
                }
            }
        }
        if(count==3)
        {
            Intent intent=StudentDetail.getIntent(this,STUDENT_INDEX);
startActivity(intent);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onAlumniInteraction(int count) {
        Fade fade=new Fade();
        fade.setDuration(500);
        TransitionManager.beginDelayedTransition(frameLayout,fade);
        if (count == 1) {

            LoginFragment loginFragment = LoginFragment.newInstance();
            FragmentTransaction LoginTransaction = fragmentManager.beginTransaction();
            LoginTransaction.replace(R.id.student_login_fragment, loginFragment);
          //  LoginTransaction.addToBackStack(null);
            LoginTransaction.commit();

        }
        if(count==2)
        { Username=LoginFragment.studentId();
            Password=LoginFragment.studentPassword();
            Intent intent=ProfileActivity.getProfileActivityIntent(this,Alumni_INDEX);
            startActivity(intent);
            finish();
        }
        if(count==3)
        {
            Intent intent=StudentDetail.getIntent(this,Alumni_INDEX);
            startActivity(intent);
        }

        }

}
