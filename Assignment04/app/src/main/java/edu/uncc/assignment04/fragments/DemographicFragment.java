//Assignment 4
//DemographicFragment.java
//Zeke Marshall
package edu.uncc.assignment04.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import edu.uncc.assignment04.MainActivity;
import edu.uncc.assignment04.R;
import edu.uncc.assignment04.Response;

public class DemographicFragment extends Fragment {


    public DemographicFragment() {
        // Required empty public constructor
    }

    public static DemographicFragment newInstance(String param1, String param2) {
        DemographicFragment fragment = new DemographicFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    Response response;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_demographic, container, false);

        if (getArguments() != null) {
            response = (Response) getArguments().getSerializable("response");
        }

        TextView textEducation = view.findViewById(R.id.textViewEducation);
        if (response != null){
            if (response.getEducation() != null){
                textEducation.setText(response.getEducation());
            }
            TextView textMarital = view.findViewById(R.id.textViewMaritalStatus);
            if (response.getMaritalStatus() != null){
                textMarital.setText(response.getMaritalStatus());
            }
            TextView textLiving = view.findViewById(R.id.textViewLivingStatus);
            if (response.getLivingStatus() != null){
                textLiving.setText(response.getLivingStatus());
            }
            TextView textIncome = view.findViewById(R.id.textViewIncomeStatus);
            if (response.getIncome() != null){
                textIncome.setText(response.getIncome());
            }
        }

        //Education
        view.findViewById(R.id.buttonSelectEducation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() != null){
                    ((MainActivity)getActivity()).goToEducationFragment(response);
                }
            }
        });

        //Marital
        view.findViewById(R.id.buttonSelectMarital).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() != null){
                    ((MainActivity)getActivity()).goToMaritalFragment(response);
                }
            }
        });

        //Living
        view.findViewById(R.id.buttonSelectLiving).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() != null){
                    ((MainActivity)getActivity()).goToLivingFragment(response);
                }
            }
        });

        //Income
        view.findViewById(R.id.buttonSelectIncome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() != null){
                    ((MainActivity)getActivity()).goToIncomeFragment(response);
                }
            }
        });

        //Next
        view.findViewById(R.id.buttonNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (response.getEducation() != null && response.getMaritalStatus() != null && response.getLivingStatus() != null && response.getIncome() != null){
                    if (getActivity() != null){
                        ((MainActivity)getActivity()).goToProfileFragment(response);
                    }
                }
                else{
                    Toast.makeText(getActivity(), "Please fill out all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }
}