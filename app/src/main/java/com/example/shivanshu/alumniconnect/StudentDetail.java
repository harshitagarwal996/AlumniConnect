package com.example.shivanshu.alumniconnect;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.LENGTH_LONG;

public class StudentDetail extends AppCompatActivity implements StudentDetailFragment.OnFragmentInteractionListener,AlumniDetailFragment.OnFragmentInteractionListener,Callback<MailChimpApiLIst> {
    String D1 = "";
    String D2 = "";
    String D3 = "";
    String D4 = "";
    String D5 = "";
    String D6 = "";
    String D7 = "";
String result="";
    FragmentManager detailManager;
    DataBaseConnectivity myDb;
    FragmentTransaction detailTransaction;
    private final int STUNDENT_INDEX = 1;
    private final int ALUMNI_INDEX = 0;
    static int j;

    public static Intent getIntent(Context context, int id) {
        j = id;
        Intent intent = new Intent(context, StudentDetail.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);
        myDb = new DataBaseConnectivity(this);
        detailManager = getSupportFragmentManager();
        detailTransaction = detailManager.beginTransaction();

        if (j == STUNDENT_INDEX) {
            StudentDetailFragment studentDetailFragment = StudentDetailFragment.newInstance();
            detailTransaction.add(R.id.detail_fragment, studentDetailFragment);
            detailTransaction.commit();
        } else if (j == ALUMNI_INDEX) {
            AlumniDetailFragment alumnitDetailFragment = AlumniDetailFragment.newInstance();
            detailTransaction.add(R.id.detail_fragment, alumnitDetailFragment);
            detailTransaction.commit();

        }

    }

    @Override
    public void onStudentDetailInteraction() {
        double x=0;
        int i=0;
            D1 = DetailHandleModel.DetailArray[i];
            D2 = DetailHandleModel.DetailArray[i+1];
            D3 = DetailHandleModel.DetailArray[i+2];
            D4 = DetailHandleModel.DetailArray[i+3];
            D5 = DetailHandleModel.DetailArray[i+4];
            D6 = DetailHandleModel.DetailArray[i+5];
            D7 = DetailHandleModel.DetailArray[i+6];
           x=Double.parseDouble(D5);
        Call<MailChimpApiLIst> call= RetrofitObject.getRetrofitObject().insertUser(D1, D2, D3, D4, D5, D6, D7);
        call.enqueue(this);




}

    @Override
    public void onAlumniDetailInteraction(String[] s) {
        double x=0;
        int i=0;
        D1 = DetailHandleModel.DetailArray[i];
        D2 = DetailHandleModel.DetailArray[i+1];
        D3 = DetailHandleModel.DetailArray[i+2];
        D4 = DetailHandleModel.DetailArray[i+3];
        D5 = DetailHandleModel.DetailArray[i+4];
        D6 = DetailHandleModel.DetailArray[i+5];
        D7 = DetailHandleModel.DetailArray[i+6];
        x=Double.parseDouble(D5);
        Call<MailChimpApiLIst> call= RetrofitObject.getRetrofitObject().insertAlumni(D1, D2, D3, D4, D5, D6, D7);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<MailChimpApiLIst> call, Response<MailChimpApiLIst> response) {
        MailChimpApiLIst list=response.body();
        result=list.totalItems.toString();

        if (!result.equals("")) {
            Intent intent = ProfileActivity.getProfileActivityIntent(this, STUNDENT_INDEX);
            startActivity(intent);
            finish();
        }

        else

        {
            Toast.makeText(this, "Data donot insert", LENGTH_LONG).show();
        }
    }

    @Override
    public void onFailure(Call<MailChimpApiLIst> call, Throwable t) {
        t.printStackTrace();
        result="";
        Toast.makeText(this, "please check your url pattern", Toast.LENGTH_SHORT).show();

    }
}
