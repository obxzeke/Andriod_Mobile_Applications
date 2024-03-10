//Assignment 4
//SelectEducationFragment.java
//Zeke Marshall
package edu.uncc.assignment04.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import edu.uncc.assignment04.MainActivity;
import edu.uncc.assignment04.R;
import edu.uncc.assignment04.Response;


public class SelectEducationFragment extends Fragment {

    public static final String EDUCATION_KEY = "EDUCATION";

    public SelectEducationFragment() {
        // Required empty public constructor
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
        View view = inflater.inflate(R.layout.fragment_select_education, container, false);

        RadioGroup educationGroup = view.findViewById(R.id.radioGroup);

        view.findViewById(R.id.buttonCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        });

        view.findViewById(R.id.buttonSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton selectedButton = educationGroup.findViewById(educationGroup.getCheckedRadioButtonId());

                if (getArguments() != null) {
                    response = (Response) getArguments().getSerializable("response");
                }

                try {
                    if (selectedButton != null) {
                        String education = selectedButton.getText().toString();
                        response.setEducation(education);
                    }
                    else {
                        throw new Exception();
                    }

                    if (getActivity() != null){
                        ((MainActivity)getActivity()).goToDemographicFragment(response);
                    }

                } catch (Exception e) {
                    Toast.makeText(getActivity(), "Please select an option", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}