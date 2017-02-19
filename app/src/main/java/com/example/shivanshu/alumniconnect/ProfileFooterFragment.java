package com.example.shivanshu.alumniconnect;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfileFooterFragment.OnProfileFooterFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfileFooterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFooterFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    ImageView HomeScreenImageView;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    int[] imageButtonId={R.id.company_fragment_profile_footer,R.id.setting_fragment_profile_footer,R.id.profile_fragment_profile_footer,R.id.chat_fragment_profile_footer,R.id.home_fragment_profile_footer};
    ImageButton[] imageButtons=new ImageButton[5];

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnProfileFooterFragmentInteractionListener mListener;

    public ProfileFooterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFooterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFooterFragment newInstance(String param1, String param2) {
        ProfileFooterFragment fragment = new ProfileFooterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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
        View view=inflater.inflate(R.layout.fragment_profile_footer, container, false);
        view.setOnClickListener(this);
        for (int i=0;i<5;i++) {
            imageButtons[i] = (ImageButton) view.findViewById(imageButtonId[i]);
            imageButtons[i].setOnClickListener(this);
        }
            return  view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(View uri) {
        if (mListener != null) {
            mListener.onProfileFooterFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnProfileFooterFragmentInteractionListener) {
            mListener = (OnProfileFooterFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnProfileFooterFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
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
    public interface OnProfileFooterFragmentInteractionListener {
        // TODO: Update argument type and name
        void onProfileFooterFragmentInteraction(View uri);
    }
}
