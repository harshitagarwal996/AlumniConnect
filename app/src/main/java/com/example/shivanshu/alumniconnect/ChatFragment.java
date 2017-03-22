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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class ChatFragment extends Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView ChatRecyclerView;
    static int Count=0;
    private String mParam1;
    private String mParam2;
    Button ChatButton;
    EditText ChatText;
    View view;
    ChatAdapter adapter;

    private OnChatFragmentInteractionListener mListener;

    public ChatFragment() {
    }


    public static ChatFragment newInstance() {
        ChatFragment fragment = new ChatFragment();
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
       view= inflater.inflate(R.layout.fragment_chat, container, false);
        ChatButton=(Button)view.findViewById(R.id.chat_button);
        ChatButton.setOnClickListener(this);
        ChatText=(EditText)view.findViewById(R.id.chat_data);
        ChatRecyclerView=(RecyclerView)view.findViewById(R.id.chat_recycler_view);
        ChatRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new ChatAdapter();
        ChatRecyclerView.setAdapter(adapter);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onChatFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnChatFragmentInteractionListener) {
            mListener = (OnChatFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnChatFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        TextView ChatWarningTextView;
        ChatWarningTextView= (TextView) view.findViewById(R.id.chat_box_warning);
        if (ChatText.getText().toString().equals("")) {

            ChatWarningTextView.setVisibility(View.VISIBLE);

        }
        else {
            ChatWarningTextView.setVisibility(View.GONE);
            ChatDataHandleClass.setList(ChatText.getText().toString());
            ChatText.setText("");
            adapter.notifyDataSetChanged();

        }

    }   /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnChatFragmentInteractionListener {
        // TODO: Update argument type and name
        void onChatFragmentInteraction(Uri uri);
    }

    private class ChatAdapter extends RecyclerView.Adapter<ChatViewHolder>{

        @Override
        public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater=(LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view=inflater.inflate(R.layout.chat_detail_layout,parent,false);
            return new ChatViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ChatViewHolder holder, int position) {
            List<String> DataList=ChatDataHandleClass.getList();
            List<String> Date=ChatDataHandleClass.getDate();
            holder.ChatText.setText(DataList.get(position));
            holder.DateTime.setText(Date.get(position));

        }

        @Override
        public int getItemCount() {
            return ChatDataHandleClass.chatListLength();
        }
    }
    private class ChatViewHolder extends RecyclerView.ViewHolder{
        TextView ChatText;
        TextView DateTime;

        public ChatViewHolder(View itemView) {
            super(itemView);
            DateTime=(TextView)itemView.findViewById(R.id.date_time);
            ChatText=(TextView)itemView.findViewById(R.id.chat_text);
        }
    }

}
