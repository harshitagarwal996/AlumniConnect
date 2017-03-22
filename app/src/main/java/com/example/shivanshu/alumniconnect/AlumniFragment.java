package com.example.shivanshu.alumniconnect;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AlumniFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AlumniFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlumniFragment extends Fragment implements View.OnClickListener {
    TextView student;
    EditText AlumniId;
    EditText AlumniPassword;
    Button login;
    Button Register;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnAlumniInteractionListener mListener;

    public AlumniFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlumniFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AlumniFragment newInstance() {
        AlumniFragment fragment = new AlumniFragment();
        Bundle args = new Bundle();
      //  args.putString(ARG_PARAM1, param1);
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

        View view=inflater.inflate(R.layout.fragment_alumni, container, false);
        student=(TextView)view.findViewById(R.id.current_student);
        student.setOnClickListener(this);
        AlumniId=(EditText)view.findViewById(R.id.student_alumni_id);
        AlumniPassword=(EditText)view.findViewById(R.id.student_alumni_password);
        login=(Button)view.findViewById(R.id.login);
        login.setOnClickListener(this);
        Register=(Button)view.findViewById(R.id.register);
        Register.setOnClickListener(this);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(View v) {
        if (mListener != null) {
            switch(v.getId()) {
                case R.id.current_student: {
                    mListener.onAlumniInteraction(1);
                    break;
                }
                case R.id.login: {
                    mListener.onAlumniInteraction(2);
                    break;
                }
                case R.id.register: {
                    mListener.onAlumniInteraction(3);
                    break;
                }
            }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnAlumniInteractionListener) {
            mListener = (OnAlumniInteractionListener) context;
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
this.onButtonPressed(v);
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
    public interface OnAlumniInteractionListener {
        // TODO: Update argument type and name
        void onAlumniInteraction(int count);
    }
}
