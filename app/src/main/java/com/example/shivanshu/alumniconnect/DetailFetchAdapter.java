package com.example.shivanshu.alumniconnect;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by shivanshu on 3/28/2017.
 */

public class DetailFetchAdapter extends RecyclerView.Adapter<DetailFetchViewHolder> {
Context context;
   static List<CompanyServerListHandle> list;
    @Override
    public DetailFetchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context=parent.getContext();
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.company_detail_recyclerview,parent,false);

        return new DetailFetchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailFetchViewHolder holder, int position) {

        holder.CompanyNameDetail.setText(list.get(position).getId() );
        holder.Durration.setText(list.get(position).getTitle());

        Picasso.with(context)
                .load(list.get(position).getImage())
                .resize(200,200)
                .into(holder.companyImage);
        holder.currentStatus(holder.CompanyNameDetail.getText().toString(),list.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
