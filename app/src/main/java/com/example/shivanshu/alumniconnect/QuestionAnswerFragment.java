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

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link QuestionAnswerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link QuestionAnswerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionAnswerFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private static List<QuestionServerListHandle> details=new ArrayList<>();

    private OnFragmentInteractionListener mListener;

    public QuestionAnswerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuestionAnswerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuestionAnswerFragment newInstance(List<QuestionServerListHandle> list) {
        QuestionAnswerFragment fragment = new QuestionAnswerFragment();
        Bundle args = new Bundle();
        details.clear();
        details=list;
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
       View view= inflater.inflate(R.layout.fragment_question_answer, container, false);
        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.question_answer);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new QuestionAdapterClass ());
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
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
        void onFragmentInteraction(Uri uri);
    }
    public class QuestionAdapterClass extends RecyclerView.Adapter<QuestionViewHolder>
    {

        @Override
        public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater=(LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view=inflater.inflate(R.layout.question_answer_layout,parent,false);
            return new QuestionViewHolder(view);
        }

        @Override
        public void onBindViewHolder(QuestionViewHolder holder, int position) {
            holder.position.append(""+position);
            holder.question.setText(details.get(position).getQuestion());
            holder.answer.setText(details.get(position).getAnswer());

        }

        @Override
        public int getItemCount() {
            return details.size();
        }
    }
    public class QuestionViewHolder extends RecyclerView.ViewHolder
    {
        TextView position;
        TextView question;
        TextView answer;
        TextView comment;

        public QuestionViewHolder(View itemView) {
            super(itemView);
            position=(TextView)itemView.findViewById(R.id.position);
            question=(TextView)itemView.findViewById(R.id.question);
            answer=(TextView)itemView.findViewById(R.id.anser_text);
            comment=(TextView)itemView.findViewById(R.id.comment);
            comment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
