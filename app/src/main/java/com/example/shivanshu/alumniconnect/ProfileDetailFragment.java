package com.example.shivanshu.alumniconnect;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ProfileDetailFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
TextView DetailChangeTextView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private OnFragmentInteractionListener mListener;

    public ProfileDetailFragment() {
    }


    public static ProfileDetailFragment newInstance() {
        ProfileDetailFragment fragment = new ProfileDetailFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_profile_detail, container, false);
        DetailChangeTextView=(TextView)view.findViewById(R.id.detai_changing_button);
        DetailChangeTextView.setOnClickListener(this);
        RecyclerView DetailRecyclerView=(RecyclerView)view.findViewById(R.id.profile_detail_view_recyclerview);
        DetailRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        DetailRecyclerView.setAdapter(new ProfileDetailAdapter());
        return view;
    }

    public void onButtonPressed() {
        if (mListener != null) {
            mListener.onFragmentInteraction();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        onButtonPressed();

    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction();
    }



     //Adapter Class

    private class ProfileDetailAdapter extends RecyclerView.Adapter<ProfileDetailViewHolder>
    {

        @Override
        public ProfileDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context=parent.getContext();
            LayoutInflater inflate=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view=inflate.inflate(R.layout.recycler_data_profile,parent,false);
            return new ProfileDetailViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ProfileDetailViewHolder holder, int position) {
            holder.DeatilView.setText("nothing has to display please fill your all deastils");

        }

        @Override
        public int getItemCount() {
            return 7;
        }
    }




    // ProfileDetailViewHoder Class
    private class ProfileDetailViewHolder extends RecyclerView.ViewHolder
    {TextView DeatilView;

        public ProfileDetailViewHolder(View itemView) {
            super(itemView);
            DeatilView=(TextView)itemView.findViewById(R.id.detail_text_view);
        }
    }




}
