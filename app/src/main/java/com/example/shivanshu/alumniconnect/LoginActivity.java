package com.example.shivanshu.alumniconnect;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements LoginFragment.OnStudentInteractionListener,AlumniFragment.OnAlumniInteractionListener{
TextView currentStudent;
    TextView alumni;
    FragmentManager fragmentManager;
    FragmentTransaction LoginTransaction;
    public final int STUDENT_INDEX=1;
    public final int Alumni_INDEX=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        currentStudent=(TextView)findViewById(R.id.current_student);
        alumni=(TextView)findViewById(R.id.alumni);
        if(fragmentManager==null) {
            fragmentManager = getSupportFragmentManager();
            LoginFragment loginFragment = LoginFragment.newInstance();
            LoginTransaction = fragmentManager.beginTransaction();
            LoginTransaction.add(R.id.student_login_fragment, loginFragment);
            LoginTransaction.commit();
        }

    }

    @Override
    public void onStudentInteraction(int count) {
        if(count==1)
        {
            AlumniFragment alumniFragment = AlumniFragment.newInstance();
            LoginTransaction = fragmentManager.beginTransaction();
            LoginTransaction.replace(R.id.student_login_fragment, alumniFragment);
            LoginTransaction.addToBackStack(null);
            LoginTransaction.commit();
        }
        if(count==2)
        {String Username=LoginFragment.studentId();
            String Password=LoginFragment.studentPassword();
            Intent intent=ProfileActivity.getProfileActivityIntent(this);
            startActivity(intent);

        }
        if(count==3)
        {
            Intent intent=StudentDetail.getIntent(this,STUDENT_INDEX);
startActivity(intent);
            finish();
        }

    }

    @Override
    public void onAlumniInteraction(int count) {
        if (count == 1) {

            LoginFragment loginFragment = LoginFragment.newInstance();
            LoginTransaction = fragmentManager.beginTransaction();
            LoginTransaction.replace(R.id.student_login_fragment, loginFragment);
            LoginTransaction.addToBackStack(null);
            LoginTransaction.commit();

        }
        if(count==2)
        {String Username=LoginFragment.studentId();
            String Password=LoginFragment.studentPassword();

        }
        if(count==3)
        {
            Intent intent=StudentDetail.getIntent(this,Alumni_INDEX);
            startActivity(intent);
            finish();
        }

        }
}
