package com.example.shivanshu.alumniconnect;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionAnswerListActivity extends AppCompatActivity implements Callback<QuestionServerList>,QuestionAnswerFragment.OnFragmentInteractionListener {
FragmentManager manager;
    AlertDialog alertDialog;
    List<QuestionServerListHandle> details=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_answer_list);
        manager=getSupportFragmentManager();
        Call<QuestionServerList> call= RetrofitObject.getRetrofitObject().questionList("");
        call.enqueue(this);
        AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("please Waiit");
        alertDialog=alertDialogBuilder.create();
        alertDialog.show();

    }
    public static Intent getIntentActivity(Context c)
    {
        Intent intent=new Intent(c,QuestionAnswerListActivity.class);
        return intent;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onResponse(Call<QuestionServerList> call, Response<QuestionServerList> response) {
        alertDialog.cancel();
        QuestionServerList list=response.body();
        for(QuestionServerList.QuestionServerLIstExpose list1:list.companyDetails)
        {
            Log.d("digvijay",""+list1.getQuestion());
            details.add(new QuestionServerListHandle(list1.getQuestion(),list1.getAnswer()));
        }

        QuestionAnswerFragment fragment=QuestionAnswerFragment.newInstance(details);
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.full_deatils,fragment);
        transaction.commit();
    }



    @Override
    public void onFailure(Call<QuestionServerList> call, Throwable t) {

    }
}
