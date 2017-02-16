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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        currentStudent=(TextView)findViewById(R.id.current_student);
        alumni=(TextView)findViewById(R.id.alumni);
      //  currentStudent.setOnClickListener(this);
        //alumni.setOnClickListener(this);
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

        }
        if(count==3)
        {
            Intent intent=new Intent(this,StudentDetail.class);
startActivity(intent);
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
            Intent intent=new Intent(this,StudentDetail.class);
            startActivity(intent);
        }

        }
}
