package com.example.shivanshu.alumniconnect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by shivanshu on 4/9/2017.
 */

public class QuestionServerList {

    @Expose
    @SerializedName("companyname")
    public List<QuestionServerList.QuestionServerLIstExpose> companyDetails;


    public class QuestionServerLIstExpose
    {
        @Expose
        @SerializedName("question")
        private  String Question;

        @Expose
        @SerializedName("answer")
        private  String Answer;



        public String getQuestion() {

            return Question;
        }

        public String getAnswer()
        {
            return Answer;
        }

    }
}
