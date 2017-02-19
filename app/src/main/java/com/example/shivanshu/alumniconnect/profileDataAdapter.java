package com.example.shivanshu.alumniconnect;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Harshit on 17-02-2017.
 */
public class profileDataAdapter extends RecyclerView.Adapter<profileDataViewHolder> {
    private int itemCount=30;
    @Override
    public profileDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View inflate = inflater.inflate(R.layout.recycler_data_profile, parent, false);
        return new profileDataViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(profileDataViewHolder holder, int position) {
        holder.textView.setText("Company "+(position+1)+" campus placement");

    }

    @Override
    public int getItemCount() {
        return itemCount;
    }
}