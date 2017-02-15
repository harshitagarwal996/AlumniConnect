package com.example.shivanshu.alumniconnect;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements LoginFragment.OnFragmentInteractionListener,View.OnClickListener,AlumniFragment.OnFragmentInteractionListener{
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
        currentStudent.setOnClickListener(this);
        alumni.setOnClickListener(this);
        fragmentManager=getSupportFragmentManager();
        LoginFragment loginFragment=LoginFragment.newInstance();
         LoginTransaction=fragmentManager.beginTransaction();
        LoginTransaction.add(R.id.student_login_fragment,loginFragment);
        LoginTransaction.commit();

    }

    @Override
    public void onFragmentInteraction() {

    }

    @Override
    public void onClick(View v) {
        if(v==currentStudent)
        {
            LoginFragment loginFragment=LoginFragment.newInstance();
             LoginTransaction=fragmentManager.beginTransaction();
            LoginTransaction.replace(R.id.student_login_fragment,loginFragment);
            LoginTransaction.addToBackStack(null);
            currentStudent.setBackgroundResource(R.color.unclicked);
            currentStudent.setTextColor(getResources().getColor(R.color.clicked));
            alumni.setBackgroundResource(R.color.clicked);
            alumni.setTextColor(getResources().getColor(R.color.unclicked));
            LoginTransaction.commit();

        }
        else
        {
            AlumniFragment alumniFragment=AlumniFragment.newInstance();
             LoginTransaction=fragmentManager.beginTransaction();
            LoginTransaction.replace(R.id.student_login_fragment,alumniFragment);
            currentStudent.setBackgroundResource(R.color.clicked);
            currentStudent.setTextColor(getResources().getColor(R.color.unclicked));
            alumni.setTextColor(getResources().getColor(R.color.clicked));
            alumni.setBackgroundResource(R.color.unclicked);
LoginTransaction.addToBackStack(null);
            LoginTransaction.commit();
        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
