package com.example.shivanshu.alumniconnect;

import android.content.Context;
import android.net.Uri;
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
 * {@link LoginFragment.OnStudentIntractionListener} interface
 * to handle interaction events.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment implements View.OnClickListener{

   static TextView alumni;
    static EditText StudentId;
    static EditText StudentPassword;
   static Button login;
    static Button Register;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnStudentInteractionListener mListener;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public  static String studentId()
    {
        return StudentId.getText().toString();
    }
    public static String studentPassword()
    {
        return StudentPassword.getText().toString();
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
        View view=inflater.inflate(R.layout.fragment_login, container, false);
        alumni=(TextView)view.findViewById(R.id.alumni);
        alumni.setOnClickListener(this);
        StudentId=(EditText)view.findViewById(R.id.studdent_login_id);
        StudentPassword=(EditText)view.findViewById(R.id.student_login_password);
        login=(Button)view.findViewById(R.id.login);
        login.setOnClickListener(this);
        Register=(Button)view.findViewById(R.id.register);
        Register.setOnClickListener(this);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(View v) {
        if (mListener != null) {
            switch(v.getId())
            {
                case R.id.alumni:
                {
                    mListener.onStudentInteraction(1);
                    break;
                }
                case R.id.login:
                {
                    mListener.onStudentInteraction(2);
                    break;
                }
                case R.id.register:
                {
                    mListener.onStudentInteraction(3);
                    break;
                }
            }

        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnStudentInteractionListener) {
            mListener = (OnStudentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnStudentIntractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v)
    {
        onButtonPressed(v);

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
    public interface OnStudentInteractionListener {
        // TODO: Update argument type and name
        void onStudentInteraction(int count);
    }
}
