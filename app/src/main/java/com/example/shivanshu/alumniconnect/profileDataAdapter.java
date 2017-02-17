package com.example.shivanshu.alumniconnect;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Harshit on 17-02-2017.
 */
public class profileDataAdapter extends RecyclerView.Adapter {
    private int itemCount=0;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View inflate = inflater.inflate(R.layout.recycler_data_profile, parent, false);
        return new profileDataViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }
    public void setItemCount(){
    }

    @Override
    public int getItemCount() {
        return 20;
    }
}