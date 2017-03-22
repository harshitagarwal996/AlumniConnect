package com.example.shivanshu.alumniconnect;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StudentDetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StudentDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentDetailFragment extends Fragment implements View.OnFocusChangeListener,View.OnClickListener{

private final int VALIDDATA=1;
    private final int INVALIDDATA=2;
    int[]  ValidationId={R.id.name_validation,R.id.college_validation,R.id.college_id_validation,R.id.email_validation,R.id.phone_number_validation,R.id.branch_validation};
    private  TextView[] ValidationViews=new TextView[6 ];
    int[] EditTextId={R.id.name,R.id.college_name,R.id.college_id,R.id.email_id,R.id.contact_number,R.id.branch};
    EditText[] StudentDetails=new EditText[6];
     String[] s=new String[6];
    Button TakeStudentsDetails;
   static int i=0;
private static int CheckedEnteryError=0;
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public StudentDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StudentDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StudentDetailFragment newInstance() {
        StudentDetailFragment fragment = new StudentDetailFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
       // args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
          //  mParam1 = getArguments().getString(ARG_PARAM1);
           // mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_student_detail, container, false);
        for(i=0;i<ValidationId.length;i++)
        {

            ValidationViews[i]=(TextView)view.findViewById(ValidationId[i]);
            StudentDetails[i]=(EditText)view.findViewById(EditTextId[i]);
            StudentDetails[i].setOnFocusChangeListener( this);
        }
        TakeStudentsDetails=(Button)view.findViewById(R.id.take_student_detail_button);
        TakeStudentsDetails.setOnClickListener(this);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event


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

        for (i = 0; i < StudentDetails.length; i++) {
            if (i != 0) {
                if (v == StudentDetails[i]) {
                    s[i-1] = StudentDetails[i - 1].getText().toString();
                    if(s[i-1].length()==0)
                    {
                        CheckedEnteryError=INVALIDDATA;
                        ValidationViews[i-1].setVisibility(View.VISIBLE);
                    }
                    else if(ValidationViews[i-1].getVisibility()==View.VISIBLE)
                    {
                        CheckedEnteryError=VALIDDATA;
                        ValidationViews[i-1].setVisibility(View.GONE);

                    }
                    else
                    {
                        CheckedEnteryError=VALIDDATA;
                    }
                }
            }
        }

    }

    @Override
    public void onClick(View v) {
        s[i-1]=StudentDetails[i-1].getText().toString();

        if(CheckedEnteryError==VALIDDATA||CheckedEnteryError==0) {
            for(int j=0;j<StudentDetails.length;j++)
            {
                Log.d("digvijay",""+s[j]);
            }

            DetailHandleModel.studentRegistrationDetail(s);
            if(i!=0)
                Log.d("digvijay", "Data is valid");
                if (mListener != null) {
                    mListener.onStudentDetailInteraction();


                }
            }

            else
            {
                Log.d("digvijay","Data is not valid");
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
        void onStudentDetailInteraction();
    }
}
