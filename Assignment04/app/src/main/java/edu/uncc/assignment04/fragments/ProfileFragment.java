//Assignment 4
//ProfileFragment.java
//Zeke Marshall
package edu.uncc.assignment04.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.uncc.assignment04.R;
import edu.uncc.assignment04.Response;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    Response response;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        TextView name = view.findViewById(R.id.textViewName);
        TextView email = view.findViewById(R.id.textViewEmail);
        TextView income = view.findViewById(R.id.textViewIncomeValue);
        TextView education = view.findViewById(R.id.textViewEdu);
        TextView marital = view.findViewById(R.id.textViewMaritalStatus);
        TextView living = view.findViewById(R.id.textViewLivingStatus);

        if (getArguments() != null) {
            response = (Response) getArguments().getSerializable("response");
        }

        name.setText(response.getName());
        email.setText(response.getEmail());
        income.setText(response.getIncome());
        education.setText(response.getEducation());
        marital.setText(response.getMaritalStatus());
        living.setText(response.getLivingStatus());

        return view;
    }
}