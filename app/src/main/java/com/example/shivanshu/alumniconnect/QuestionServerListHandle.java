package com.example.shivanshu.alumniconnect;

/**
 * Created by shivanshu on 4/9/2017.
 */

public class QuestionServerListHandle {
    String Question;
    String Answer;
    QuestionServerListHandle(String question,String answer)
    {
        Question=question;
        Answer=answer;

    }

    public String getQuestion() {
        return Question;
    }

    public String getAnswer() {
        return Answer;
    }
}
