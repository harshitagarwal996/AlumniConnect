package com.example.shivanshu.alumniconnect;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Harshit on 17-02-2017.
 */
public class profileDataViewHolder extends RecyclerView.ViewHolder {
    TextView textView;
    public profileDataViewHolder(View view) {
        super(view);
        textView= (TextView) view.findViewById(R.id.profile_data_recycler_text_view);
    }
}
