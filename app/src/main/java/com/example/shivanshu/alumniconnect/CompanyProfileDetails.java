package com.example.shivanshu.alumniconnect;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CompanyProfileDetails.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CompanyProfileDetails#newInstance} factory method to
 * create an instance of this fragment.
 */

public class CompanyProfileDetails extends Fragment implements Callback<CompanyServerList> {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    List<CompanyServerListHandle> detail=new ArrayList<>();
    private String mParam1;
    private String mParam2;
    EditText searchtext;
    String s="";
    ImageButton searchbutton;
RecyclerView detailRecyclerView;
    DetailFetchAdapter detailAdapter;
    View view;
    AlertDialog alertDialog;
    private OnCompanyDetailInteractionListener mListener;

    public CompanyProfileDetails() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CompanyProfileDetails.
     */
    // TODO: Rename and change types and number of parameters
    public static CompanyProfileDetails newInstance() {
        CompanyProfileDetails fragment = new CompanyProfileDetails();
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
         view=inflater.inflate(R.layout.fragment_company_profile_details, container, false);
        searchtext=(EditText)view.findViewById(R.id.search);
        searchbutton=(ImageButton)view.findViewById(R.id.search_button);
        searchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s= searchtext.getText().toString();
                if(s.equals(""))
                {
                    Toast.makeText(getContext(),"Please Enter Valid name",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    onButtonPressed(s);
                }

            }
        });
        searchtext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    onButtonPressed(s);
                }

return false;
            }
        });

        Call<CompanyServerList> call= RetrofitObject.getRetrofitObject().companyList(1,"");
        call.enqueue(this);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(view.getContext());
        alertDialogBuilder.setMessage("please wait");
         alertDialog = alertDialogBuilder.create();
        alertDialog.show();

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String s) {
        if (mListener != null) {
            mListener.onCompanyDetailInteraction(s);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnCompanyDetailInteractionListener) {
            mListener = (OnCompanyDetailInteractionListener) context;
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
    public void onResponse(Call<CompanyServerList> call, Response<CompanyServerList> response) {
        alertDialog.cancel();
CompanyServerList list=response.body();
        for(CompanyServerList.CompanyServerLIstExpose list1:list.companyDetails) {

            detail.add(new CompanyServerListHandle(list1.getCompanyName(),list1.getDurration(),list1.getImageurl()));

        }
DetailFetchAdapter.list=detail;
        detailRecyclerView=(RecyclerView)view.findViewById(R.id.detail_recyclerview);
        detailRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        detailAdapter=new DetailFetchAdapter();
        detailRecyclerView.setAdapter(detailAdapter);

    }

    @Override
    public void onFailure(Call<CompanyServerList> call, Throwable t) {
        Log.d("digvijay",""+t);
      alertDialog.cancel();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(view.getContext());
        alertDialogBuilder.setMessage("please check your Internet Connection");
        alertDialog = alertDialogBuilder.create();
        alertDialog.show();



    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnCompanyDetailInteractionListener {
        // TODO: Update argument type and name
        void onCompanyDetailInteraction(String s);
    }
}
