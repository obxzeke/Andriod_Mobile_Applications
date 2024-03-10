package edu.uncc.assignment05.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import edu.uncc.assignment05.MainActivity;
import edu.uncc.assignment05.R;
import edu.uncc.assignment05.models.User;

public class UserDetailsFragment extends Fragment {
    private User user;
    private OnDeleteUserClickListener deleteUserClickListener;
    public UserDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            user = (User) getArguments().getSerializable("user");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_details, container, false);
        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewEmail = view.findViewById(R.id.textViewEmail);
        TextView textViewAge = view.findViewById(R.id.textViewAge);
        TextView textViewState = view.findViewById(R.id.textViewState);
        TextView textViewGender = view.findViewById(R.id.textViewGender);
        TextView textViewGroup = view.findViewById(R.id.textViewGroup);
        Button btnBack = view.findViewById(R.id.buttonBack);
        ImageView imageViewDelete = view.findViewById(R.id.imageViewDelete);

        if (user != null){
            textViewName.setText(user.getName());
            textViewEmail.setText(user.getEmail());
            textViewAge.setText(String.valueOf(user.getAge()));
            textViewState.setText(user.getState());
            textViewGender.setText(user.getGender());
            textViewGroup.setText(user.getGroup());
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        });

        imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (deleteUserClickListener != null && user != null){
                    deleteUserClickListener.onDeleteUserClick(user);
                }
            }
        });

        return view;
    }
    public interface OnDeleteUserClickListener{
        void onDeleteUserClick(User user);
    }

    public void setOnDeleteUserClickListener(MainActivity mainActivity){
        deleteUserClickListener = mainActivity;
    }
}