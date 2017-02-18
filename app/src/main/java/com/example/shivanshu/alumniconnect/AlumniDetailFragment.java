package com.example.shivanshu.alumniconnect;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.shivanshu.alumniconnect.R.drawable.selected_box;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AlumniDetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AlumniDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlumniDetailFragment extends Fragment implements View.OnFocusChangeListener{
   int[]  ValidationId={R.id.name_validation,R.id.college_validation,R.id.company_validation,R.id.email_validation,R.id.phone_number_validation,R.id.tech_validation};
   private  TextView[] ValidationViews=new TextView[7];
    int[] EditTextId={R.id.name,R.id.college_name,R.id.company_name,R.id.email_id,R.id.contact_number,R.id.working_technology};
    EditText[] AlumniDetails=new EditText[7];
    String s="";
    int i=0;
int count=0;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private OnFragmentInteractionListener mListener;

    public AlumniDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlumniDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AlumniDetailFragment newInstance() {
        AlumniDetailFragment fragment = new AlumniDetailFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        //fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_alumni_detail, container, false);
        for(i=0;i<ValidationId.length;i++)
        {
            ValidationViews[i]=(TextView)view.findViewById(ValidationId[i]);
            AlumniDetails[i]=(EditText)view.findViewById(EditTextId[i]);
            AlumniDetails[i].setOnFocusChangeListener(this);
        }
        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onAlumniDetailInteraction();
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
    public void onFocusChange(View v, boolean hasFocus) {
        for (i = 0; i < AlumniDetails.length; i++) {
            if (i != 0) {
                if (v == AlumniDetails[i]) {
                    s = AlumniDetails[i - 1].getText().toString();
                    if(s.length()==0)
                    {
                        ValidationViews[i-1].setVisibility(View.VISIBLE);
                    }
                    else if(ValidationViews[i-1].getVisibility()==View.VISIBLE)
                    {
                        ValidationViews[i-1].setVisibility(View.GONE);

                    }

                    }

                }
            }
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onAlumniDetailInteraction();
    }
}
